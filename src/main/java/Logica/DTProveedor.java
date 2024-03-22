
package Logica;


public class DTProveedor {
    
    private String nombre;
    private String informacionDeContacto;

    public DTProveedor() {
    }

    public DTProveedor(String nombre, String informacionDeContacto) {
        this.nombre = nombre;
        this.informacionDeContacto = informacionDeContacto;
    }


    public String getNombre() {
        return nombre;
    }

    public String getInformacionDeContacto() {
        return informacionDeContacto;
    }
    
    
    
}
