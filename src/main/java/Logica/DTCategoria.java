
package Logica;


public class DTCategoria {
    private Long id;
    private String nombre;

    public DTCategoria() {
    }

    public DTCategoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
