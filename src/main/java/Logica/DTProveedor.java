
package Logica;


public class DTProveedor {
    
    private Long id;
    private String nombre;
    private String informacionDeContacto; // Opcional

    public DTProveedor() {
    }

    public DTProveedor(Long id, String nombre, String informacionDeContacto) {
        this.id = id;
        this.nombre = nombre;
        this.informacionDeContacto = informacionDeContacto;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInformacionDeContacto() {
        return informacionDeContacto;
    }
    
    
    
}
