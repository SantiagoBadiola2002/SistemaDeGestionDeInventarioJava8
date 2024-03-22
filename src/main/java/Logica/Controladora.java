package Logica;

import static Logica.Producto_.categoria;
import static Logica.Producto_.proveedor;
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
    public List<String> traerCategorias() throws Exception {
        List<String> listaCategorias = new ArrayList<String>();
        try {
            List<Categoria> categorias = categoriaJpa.findCategoriaEntities();
            for (Categoria c : categorias) {
                listaCategorias.add(c.getNombre());
            }
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
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
    public Categoria traerCategoria(String nombreCategoria) throws Exception {
        Categoria categoria = null; // Declaración fuera del bloque try
        try {
             categoria = categoriaJpa.findCategoria(nombreCategoria);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  categoria;
    }
    
     public Proveedor traerProveedor(String nombreProveedor) throws Exception{
         Proveedor proveedor = null;
         try {
            proveedor = proveedorJpa.findProveedor(nombreProveedor);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
     }

}
