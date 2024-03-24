
package Logica;


public class DTCategoria {
    private int id;
    private String nombre;

    public DTCategoria() {
    }

    public DTCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    public DTCategoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    
    
}
