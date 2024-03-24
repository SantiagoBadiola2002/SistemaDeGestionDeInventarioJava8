package Logica;

import Persistencia.CategoriaJpaController;
import Persistencia.ProductoJpaController;
import Persistencia.ProveedorJpaController;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
            List<Categoria> categorias = categoriaJpa.findCategoriaEntities();
            int idCategoriaAModificar = -1;

            for (Categoria c : categorias) {
                if (c.getNombre().equals(categoriaAAmodificar)) {
                    idCategoriaAModificar = c.getId(); // Suponiendo que existe un método getId() en la clase Categoria para obtener la ID
                    break; // Se encontró la categoría, se puede salir del bucle
                }
            }
            Categoria categoriaModificada = new Categoria(idCategoriaAModificar, nuevoNombreCategoria);
            //Categoria categoriaModificada = new Categoria(nuevoNombreCategoria);
            categoriaJpa.edit(categoriaModificada);
        } catch (Exception ex) {
            throw new Exception("Error al modificar la categoria.");
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

}
