
package Logica;

import java.util.List;


public interface IControladora {
    
    public abstract void altaCategoria(String nombreCategoria) throws Exception;
    public abstract void altaProveedor(String nombreProveedor, String informacionContacto) throws Exception;
    public abstract void altaProducto(String nombreProducto, String desc, double costo, int cantStock, String nombreCategoria, String nombreProveedor) throws Exception;
    public abstract List<String> traerCategorias() throws Exception;
    public abstract List<DTProveedor> traerDTProveedores() throws Exception;
    public abstract List<DTProducto> traerDTProductos() throws Exception;
    public abstract Categoria traerCategoria(String nombreCategoria) throws Exception;
    public abstract Proveedor traerProveedor(String nombreProveedor) throws Exception;
}
