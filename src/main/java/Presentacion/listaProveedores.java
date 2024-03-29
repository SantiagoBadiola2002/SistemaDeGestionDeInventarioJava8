/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Presentacion;

import Logica.Controladora;
import Logica.DTProveedor;
import Logica.IControladora;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pc
 */
public class listaProveedores extends javax.swing.JInternalFrame {

    private IControladora control;

    /**
     * Creates new form altaCategoria
     */
    public listaProveedores(IControladora icu) {
        control = icu;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProveedores = new javax.swing.JTable();
        btnEliminar2 = new javax.swing.JButton();

        btnEliminar.setText("ELIMINAR CATEGORIA");

        setClosable(true);
        setTitle("Lista Proveedores");
        setPreferredSize(new java.awt.Dimension(700, 600));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tableProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProveedores);

        btnEliminar2.setText("ELIMINAR PRODUCTO");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btnEliminar2)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        try {
            // Obtener las categorías del controlador
            ArrayList<DTProveedor> proveedores = (ArrayList<DTProveedor>) control.traerDTProveedores();

            // Crear el modelo de la tabla
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Información de Contacto");

            // Llenar el modelo de tabla con los datos del ArrayList
            for (DTProveedor proveedor : proveedores) {
                modelo.addRow(new Object[]{proveedor.getNombre(), proveedor.getInformacionDeContacto()});
            }

            // Asignar el modelo de tabla al JTable
            tableProveedores.setModel(modelo);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los proveedores", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        try {
            int selectedRow = tableProveedores.getSelectedRow();
            if (selectedRow != -1) { // Asegurarse de que se haya seleccionado una fila
                Object id = tableProveedores.getValueAt(selectedRow, 0); // Obtener el valor de la columna ID de la fila seleccionada
                control.eliminarProveedor((String) id);
                DefaultTableModel model = (DefaultTableModel) tableProveedores.getModel();
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Proveedor eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el proveedor, asegurese que no haya productos asociados a el", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProveedores;
    // End of variables declaration//GEN-END:variables
}
