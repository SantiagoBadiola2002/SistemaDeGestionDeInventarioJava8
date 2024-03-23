
package Logica;


public class DTProducto {
    
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;
    private String nombreCategoria;
    private String nombreProveedor;

    public DTProducto() {
    }

    public DTProducto(Long id, String nombre, String descripcion, double precio, int cantidadEnStock, String nombreCategoria, String nombreProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
        this.nombreCategoria = nombreCategoria;
        this.nombreProveedor = nombreProveedor;
    }
    
    
    public DTProducto(Long id, String nombre, String descripcion, double precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }
    
    
    
}
