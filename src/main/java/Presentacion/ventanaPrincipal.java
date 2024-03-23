/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Logica.IControladora;

/**
 *
 * @author Pc
 */
public class ventanaPrincipal extends javax.swing.JFrame {

    private IControladora control;

    /**
     * Creates new form ventanaPrincipal
     */
    public ventanaPrincipal(IControladora icu) {
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

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAlta = new javax.swing.JMenu();
        menuAltaProducto = new javax.swing.JMenuItem();
        menuAltaCategoria = new javax.swing.JMenuItem();
        menuAltaProveedor = new javax.swing.JMenuItem();
        menuBaja = new javax.swing.JMenu();
        menuBajaProducto = new javax.swing.JMenuItem();
        menuBajaCategoria = new javax.swing.JMenuItem();
        menuBajaProveedor = new javax.swing.JMenuItem();
        menuModificar = new javax.swing.JMenu();
        menuModificarProducto = new javax.swing.JMenuItem();
        menuModificarCategoria = new javax.swing.JMenuItem();
        menuModificarProveedor = new javax.swing.JMenuItem();
        menuListar = new javax.swing.JMenu();
        menuListarProductos = new javax.swing.JMenuItem();
        menuListarCategorias = new javax.swing.JMenuItem();
        menuListarProveedores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de inventario");

        panelPrincipal.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("© Santiago Badiola");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel1)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(0, 599, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        menuAlta.setText("ALTA");

        menuAltaProducto.setText("Producto");
        menuAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaProductoActionPerformed(evt);
            }
        });
        menuAlta.add(menuAltaProducto);

        menuAltaCategoria.setText("Categoria");
        menuAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaCategoriaActionPerformed(evt);
            }
        });
        menuAlta.add(menuAltaCategoria);

        menuAltaProveedor.setText("Proveedor");
        menuAltaProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaProveedorActionPerformed(evt);
            }
        });
        menuAlta.add(menuAltaProveedor);

        jMenuBar1.add(menuAlta);

        menuBaja.setText("BAJA");

        menuBajaProducto.setText("Producto");
        menuBaja.add(menuBajaProducto);

        menuBajaCategoria.setText("Categoria");
        menuBaja.add(menuBajaCategoria);

        menuBajaProveedor.setText("Proveedor");
        menuBaja.add(menuBajaProveedor);

        jMenuBar1.add(menuBaja);

        menuModificar.setText("MODIFICAR");

        menuModificarProducto.setText("Producto");
        menuModificar.add(menuModificarProducto);

        menuModificarCategoria.setText("Categoria");
        menuModificar.add(menuModificarCategoria);

        menuModificarProveedor.setText("Proveedor");
        menuModificar.add(menuModificarProveedor);

        jMenuBar1.add(menuModificar);

        menuListar.setText("LISTAR");

        menuListarProductos.setText("Productos");
        menuListarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarProductosActionPerformed(evt);
            }
        });
        menuListar.add(menuListarProductos);

        menuListarCategorias.setText("Categorias");
        menuListarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarCategoriasActionPerformed(evt);
            }
        });
        menuListar.add(menuListarCategorias);

        menuListarProveedores.setText("Proveedores");
        menuListarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuListarProveedoresActionPerformed(evt);
            }
        });
        menuListar.add(menuListarProveedores);

        jMenuBar1.add(menuListar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaProductoActionPerformed
        altaProducto verAltaProducto = new altaProducto(control);
        panelPrincipal.add(verAltaProducto);
        verAltaProducto.show();
    }//GEN-LAST:event_menuAltaProductoActionPerformed

    private void menuAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaCategoriaActionPerformed
        altaCategoria verAltaCategoria = new altaCategoria(control);
        panelPrincipal.add(verAltaCategoria);
        verAltaCategoria.show();
    }//GEN-LAST:event_menuAltaCategoriaActionPerformed

    private void menuAltaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaProveedorActionPerformed
        altaProveedor verAltaProveedor = new altaProveedor(control);
        panelPrincipal.add(verAltaProveedor);
        verAltaProveedor.show();
    }//GEN-LAST:event_menuAltaProveedorActionPerformed

    private void menuListarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarCategoriasActionPerformed
        listaCategorias verListaCategorias = new listaCategorias(control);
        panelPrincipal.add(verListaCategorias);
        verListaCategorias.show();
    }//GEN-LAST:event_menuListarCategoriasActionPerformed

    private void menuListarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarProveedoresActionPerformed
        listaProveedores verListaProveedores = new listaProveedores(control);
        panelPrincipal.add(verListaProveedores);
        verListaProveedores.show();
    }//GEN-LAST:event_menuListarProveedoresActionPerformed

    private void menuListarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuListarProductosActionPerformed
        listaProductos verListaProductos = new listaProductos(control);
        panelPrincipal.add(verListaProductos);
        verListaProductos.show();
    }//GEN-LAST:event_menuListarProductosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAlta;
    private javax.swing.JMenuItem menuAltaCategoria;
    private javax.swing.JMenuItem menuAltaProducto;
    private javax.swing.JMenuItem menuAltaProveedor;
    private javax.swing.JMenu menuBaja;
    private javax.swing.JMenuItem menuBajaCategoria;
    private javax.swing.JMenuItem menuBajaProducto;
    private javax.swing.JMenuItem menuBajaProveedor;
    private javax.swing.JMenu menuListar;
    private javax.swing.JMenuItem menuListarCategorias;
    private javax.swing.JMenuItem menuListarProductos;
    private javax.swing.JMenuItem menuListarProveedores;
    private javax.swing.JMenu menuModificar;
    private javax.swing.JMenuItem menuModificarCategoria;
    private javax.swing.JMenuItem menuModificarProducto;
    private javax.swing.JMenuItem menuModificarProveedor;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
