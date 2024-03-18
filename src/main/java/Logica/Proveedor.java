
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true) // Esto asegura que el nombre sea único en la base de datos
    private String nombre;
    
    private String informacionDeContacto; 
    
    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String informacionDeContacto) {
        this.id = id;
        this.nombre = nombre;
        this.informacionDeContacto = informacionDeContacto;
    }

    public Proveedor(String nombre, String informacionDeContacto) {
        this.nombre = nombre;
        this.informacionDeContacto = informacionDeContacto;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
