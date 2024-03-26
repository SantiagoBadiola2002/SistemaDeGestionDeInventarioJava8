package Logica;

import Persistencia.CategoriaJpaController;
import Persistencia.ProductoJpaController;
import Persistencia.ProveedorJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora implements IControladora {

    public Controladora() {
    }

    CategoriaJpaController categoriaJpa = new CategoriaJpaController();
    ProductoJpaController productoJpa = new ProductoJpaController();
    ProveedorJpaController proveedorJpa = new ProveedorJpaController();

    @Override
    public void altaCategoria(String nombreCategoria) throws Exception {
        Categoria categoria = new Categoria(nombreCategoria);
        try {
            categoriaJpa.create(categoria);
        } catch (Exception ex) {
            throw new Exception("La categoría ya existe.");
        }
    }

    @Override
    public void altaProveedor(String nombreProveedor, String informacionContacto) throws Exception {
        Proveedor proveedor = new Proveedor(nombreProveedor, informacionContacto);
        try {
            proveedorJpa.create(proveedor);
        } catch (Exception ex) {
            throw new Exception("El proveedor ya existe.");
        }
    }

    @Override
    public void altaProducto(String nombreProducto, String desc, double costo, int cantStock, String nombreCategoria, String nombreProveedor) throws Exception {

        Categoria categoria = traerCategoria(nombreCategoria);
        Proveedor proveedor = traerProveedor(nombreProveedor);
        Producto producto = new Producto(nombreProducto, desc, costo, cantStock, categoria, proveedor);
        try {
            productoJpa.create(producto);
        } catch (Exception ex) {
            throw new Exception("El producto ya existe.");
        }
    }

    @Override
    public void modificarCategoria(String categoriaAAmodificar, String nuevoNombreCategoria) throws Exception {
        try {

            Categoria categoria = traerCategoria(categoriaAAmodificar);
            Categoria categoriaModificada = new Categoria(categoria.getId(), nuevoNombreCategoria);

            categoriaJpa.edit(categoriaModificada);
        } catch (Exception ex) {
            throw new Exception("Error al modificar la categoria.");
        }
    }

    @Override
    public void modificarProveedor(String nombreProveedor, String nuevoContacto) throws Exception {
        try {
            Proveedor proveedorAModificar = new Proveedor(nombreProveedor, nuevoContacto);
            proveedorJpa.edit(proveedorAModificar);
        } catch (Exception ex) {
            throw new Exception("Error al modificar el proveedor.");
        }
    }

    @Override
    public void modificarProducto(String nombreProducto, String nuevoNombreProducto, String desc, double costo, int cantStock, String nombreCategoria, String nombreProveedor) throws Exception {
        try {
            Proveedor proveedor = proveedorJpa.findProveedor(nombreProveedor);
            Categoria categoria = traerCategoria(nombreCategoria);
            Producto producto = traerProducto(nombreProducto);
            
            Producto p = new Producto(producto.getId(), nuevoNombreProducto, desc, costo, cantStock, categoria, proveedor);
            productoJpa.edit(p);
           

        } catch (Exception ex) {
            throw new Exception("Error al modificar el producto");
        }
    }
    
    @Override
    public void eliminarProducto(Long idProducto) throws Exception{
        try{
            productoJpa.destroy(idProducto);
        } catch (Exception ex) {
            throw new Exception("Error al eliminar el producto");
        }
    }
    
    @Override
    public void eliminarCategoria(int idCategoria) throws Exception{
        try{
            categoriaJpa.destroy(idCategoria);
        } catch (Exception ex) {
            throw new Exception("Error al eliminar la categoria");
        }
    }
    
    @Override
    public void eliminarProveedor(String nombreProveedor) throws Exception{
        try{
            proveedorJpa.destroy(nombreProveedor);
        } catch (Exception ex) {
            throw new Exception("Error al eliminar el proveedor");
        }
    }

    @Override
    public List<DTCategoria> traerCategorias() throws Exception {
        List<DTCategoria> listaCategorias = new ArrayList<DTCategoria>();
        try {
            List<Categoria> categorias = categoriaJpa.findCategoriaEntities();
            for (Categoria c : categorias) {
                DTCategoria dtCategoria = new DTCategoria(c.getId(), c.getNombre());
                listaCategorias.add(dtCategoria);
            }
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            // Aquí podrías manejar la excepción de alguna manera si es necesario.
        }
        return listaCategorias;
    }

    @Override
    public List<DTProveedor> traerDTProveedores() throws Exception {
        List<Proveedor> proveedores = proveedorJpa.findProveedorEntities();
        List<DTProveedor> dtProveedores = new ArrayList<>();

        for (Proveedor proveedor : proveedores) {
            DTProveedor dtProveedor = new DTProveedor(proveedor.getNombre(), proveedor.getInformacionDeContacto());
            dtProveedores.add(dtProveedor);
        }

        return dtProveedores;
    }

    @Override
    public List<DTProducto> traerDTProductos() throws Exception {
        List<Producto> productos = productoJpa.findProductoEntities();
        List<DTProducto> dtProductos = new ArrayList<>();

        for (Producto producto : productos) {
            DTProducto dtProducto = new DTProducto(producto.getId(), producto.getNombre(),
                    producto.getDescripcion(), producto.getPrecio(), producto.getCantidadEnStock(),
                    producto.getCategoria().getNombre(), producto.getProveedor().getNombre());
            dtProductos.add(dtProducto);
        }

        return dtProductos;
    }

    @Override
    public DTProveedor traerDTProveedor(String nombreProveedor) throws Exception {
        Proveedor proveedor = proveedorJpa.findProveedor(nombreProveedor);
        DTProveedor dtProveedor = new DTProveedor(proveedor.getNombre(), proveedor.getInformacionDeContacto());
        return dtProveedor;
    }

    @Override
    public DTProducto traerDTProducto(String nombreProducto) throws Exception {
        try{
            
        Producto producto = traerProducto(nombreProducto);
        DTProducto dtProducto = new DTProducto(producto.getId(), producto.getNombre(),
                        producto.getDescripcion(), producto.getPrecio(), producto.getCantidadEnStock(),
                        producto.getCategoria().getNombre(), producto.getProveedor().getNombre());
           
        return dtProducto;
        }catch(Exception ex){
                throw new Exception("Error al cargar el producto");
                }
    }

    @Override
    public Categoria traerCategoria(String nombreCategoria) throws Exception {
        Categoria categoria = null;
        int idCategoria = -1;
        List<Categoria> categorias = categoriaJpa.findCategoriaEntities();

        for (Categoria c : categorias) {
            if (c.getNombre().equals(nombreCategoria)) {
                idCategoria = c.getId();
                break;
            }
        }

        try {
            categoria = categoriaJpa.findCategoria(idCategoria);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    @Override
    public Proveedor traerProveedor(String nombreProveedor) throws Exception {
        Proveedor proveedor = null;
        try {
            proveedor = proveedorJpa.findProveedor(nombreProveedor);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }

    @Override
    public Producto traerProducto(String nombreProducto) throws Exception {
        Producto producto = null;

        List<Producto> productos = productoJpa.findProductoEntities();

        for (Producto p : productos) {
            if (p.getNombre().equals(nombreProducto)) {
                producto = p;
                break;
            }
        }
        return producto;
    }

}
