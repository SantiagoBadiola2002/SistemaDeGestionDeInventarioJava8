package Logica;

import Persistencia.CategoriaJpaController;
import Persistencia.ProductoJpaController;
import Persistencia.ProveedorJpaController;
import Persistencia.exceptions.PreexistingEntityException;
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
    public  void altaProveedor(String nombreProveedor, String informacionContacto) throws Exception{
        Proveedor proveedor = new Proveedor( nombreProveedor,  informacionContacto);
        try {
        proveedorJpa.create(proveedor);
    } catch (Exception ex) {
         throw new Exception("El proveedor ya existe.");
    }
    }

    
}
