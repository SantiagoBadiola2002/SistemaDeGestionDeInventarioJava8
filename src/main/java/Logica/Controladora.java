
package Logica;



import Persistencia.CategoriaJpaController;
import Persistencia.ProductoJpaController;
import Persistencia.ProveedorJpaController;

public class Controladora implements IControladora{
    
    public Controladora() {
    }
    
     CategoriaJpaController categoriaJpa = new CategoriaJpaController();
     ProductoJpaController productoJpa = new ProductoJpaController();
     ProveedorJpaController ProveedorJpa = new ProveedorJpaController();
    
}
