
package Logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Proveedor implements Serializable {
    @Id
    private String nombre;
    
    private String informacionDeContacto; 
    
    public Proveedor() {
    }

    public Proveedor(String nombre, String informacionDeContacto) {
        this.nombre = nombre;
        this.informacionDeContacto = informacionDeContacto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacionDeContacto() {
        return informacionDeContacto;
    }

    public void setInformacionDeContacto(String informacionDeContacto) {
        this.informacionDeContacto = informacionDeContacto;
    }
    
    
}
