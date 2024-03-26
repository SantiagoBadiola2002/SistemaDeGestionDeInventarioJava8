
package Logica;

import java.util.List;


public interface IControladora {
    
    public abstract void altaCategoria(String nombreCategoria) throws Exception;
    public abstract void altaProveedor(String nombreProveedor, String informacionContacto) throws Exception;
    public abstract void altaProducto(String nombreProducto, String desc, double costo, int cantStock, String nombreCategoria, String nombreProveedor) throws Exception;
    
    public abstract void modificarCategoria(String categoriaAModificar, String nuevoNombreCategoria) throws Exception;
    public abstract void modificarProveedor(String nombreProveedor, String nuevoContacto) throws Exception;
    public abstract void modificarProducto(String productoAModificar, String nuevoNombreProducto, String desc, double costo, int cantStock, String nombreCategoria, String nombreProveedor) throws Exception;
   
    public abstract void eliminarProducto(Long idProducto) throws Exception;
    public abstract void eliminarCategoria(int idCategoria) throws Exception;
    public abstract void eliminarProveedor(String nombreProveedor) throws Exception;
    
    public abstract List<DTCategoria> traerCategorias() throws Exception;
    public abstract List<DTProveedor> traerDTProveedores() throws Exception;
    public abstract List<DTProducto> traerDTProductos() throws Exception;
   
    public abstract DTProveedor traerDTProveedor(String nombreProveedor) throws Exception;
    public abstract DTProducto traerDTProducto(String nombreProducto) throws Exception;
   
    public abstract Categoria traerCategoria(String nombreCategoria) throws Exception;
    public abstract Proveedor traerProveedor(String nombreProveedor) throws Exception;
    public abstract Producto traerProducto(String nombreProducto) throws Exception;
}
