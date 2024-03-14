/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package porDefecto;

import Logica.Fabrica;
import Logica.IControladora;
import Presentacion.ventanaPrincipal;

/**
 *
 * @author Pc
 */
public class main {

    public static void main(String[] args) {
        // Inicialización de la Fabrica Fabrica fabrica = Fabrica.getInstance();
        Fabrica fabrica = Fabrica.getInstance();
        IControladora control = fabrica.getIControlador();

        ventanaPrincipal princ = new ventanaPrincipal(control);
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
    }
}
