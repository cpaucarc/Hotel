package vistas;

import Component.ListModel;
import Component.Lists;
import Component.TableModel;
import Component.Tables;
import Conexion.Control;
import Database.Controller;
import componentes.Colores;
import componentes.Fuentes;
import componentes.Mensajes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Lugares extends javax.swing.JDialog implements Colores, Fuentes {

    Controller control = Control.getControl();
    Mensajes msg = new Mensajes();

    TableModel model = new TableModel();
    ListModel mdDeptos = new ListModel();
    ListModel mdPaises = new ListModel();
        
    String[] header = new String[]{"Id", "Provincia", "Departamento", "Pais"};
    
    private int idLugar = 0;

    public Lugares(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        Configuraciones();
    }

    private void Configuraciones() throws SQLException {
        Tables.setModel(tbLugares, model, header);
        Tables.Light(tbLugares);
        Tables.HideColumn(tbLugares, 0);
        llenarTabla();
        ltDeptos.setModel(mdDeptos);
        scDepto.setVisible(false);
        Lists.Light(ltDeptos);
        ltPaises.setModel(mdPaises);
        scPais.setVisible(false);
        Lists.Light(ltPaises);
    }

    private void llenarTabla() throws SQLException {
        control.fillTable(model, "SELECT * FROM v_lugares;", 4);
    }
    
    private void registrarLugar(){
        
    }
    
    private void elegirLugar(){
        guiReservas.idLugar = Integer.parseInt(Tables.getDataFromSelectedRow(tbLugares, 0).toString());
        guiReservas.lbLugar.setText(Tables.getDataFromSelectedRow(tbLugares, 1).toString() + " - " + Tables.getDataFromSelectedRow(tbLugares, 2).toString());
        this.dispose();
    }
    
    private void llenarDeptos(String depto) throws SQLException{
        control.fillList(mdDeptos, "SELECT depto FROM deptos WHERE depto LIKE '"+depto+"%' ORDER BY depto LIMIT 3;", 1);
        mostrarLista(ltDeptos, scDepto);
    }
    
    private void llenarPaises(String pais) throws SQLException{
        control.fillList(mdPaises, "SELECT pais FROM paises WHERE pais LIKE '"+pais+"%' ORDER BY pais LIMIT 3;", 1);
        mostrarLista(ltPaises, scPais);
    }
    
    private void mostrarLista(JList lista, JScrollPane scroll){
        if (lista.getModel().getSize() == 0){
            ocultarLista(scroll);
        }else{
            scroll.setVisible(true);
        }
    }
    
    private void ocultarLista(JScrollPane scroll){
        scroll.setVisible(false);
    }
    
    private void seleccionarItemDeLista(JTextField campo, JList lista, JScrollPane scroll){
        campo.setText(lista.getSelectedValue().toString());
        ocultarLista(scroll);
        campo.grabFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txBuscar = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLugares = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        txProv = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txDepto = new javax.swing.JTextField();
        scDepto = new javax.swing.JScrollPane();
        ltDeptos = new javax.swing.JList<>();
        txPais = new javax.swing.JTextField();
        scPais = new javax.swing.JScrollPane();
        ltPaises = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/icons8_forward_arrow_20px.png"))); // NOI18N
        jMenuItem1.setText("Elegir lugar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 560));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(FONT_TITLE_1);
        jLabel10.setForeground(COLOR_TITLE_1);
        jLabel10.setText("Lugares");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 15, -1, 40));

        jLabel42.setFont(FONT_TITLE_3);
        jLabel42.setForeground(COLOR_TITLE_3);
        jLabel42.setText("Pais");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, 20));

        jLabel43.setFont(FONT_TITLE_3);
        jLabel43.setForeground(COLOR_TITLE_3);
        jLabel43.setText("Buscar");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 50, 25));

        txBuscar.setFont(FONT_COMPONENT_TEXT);
        txBuscar.setForeground(COLOR_COMPONENT_TEXT);
        txBuscar.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 520, 25));

        btRegistrar.setBackground(COLOR_BTN_PRIMARY_BG);
        btRegistrar.setFont(FONT_BTN_PRIMARY);
        btRegistrar.setForeground(COLOR_BTN_PRIMARY_FG);
        btRegistrar.setText("Registrar empresa");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 140, -1, 35));

        tbLugares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbLugares.setComponentPopupMenu(jPopupMenu1);
        tbLugares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLugaresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLugares);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 650, 260));

        jLabel44.setFont(FONT_TITLE_3);
        jLabel44.setForeground(COLOR_TITLE_3);
        jLabel44.setText("Provincia");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        txProv.setFont(FONT_COMPONENT_TEXT);
        txProv.setForeground(COLOR_COMPONENT_TEXT);
        txProv.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel1.add(txProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 200, 25));

        jLabel45.setFont(FONT_TITLE_3);
        jLabel45.setForeground(COLOR_TITLE_3);
        jLabel45.setText("Departamento");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, 20));

        txDepto.setFont(FONT_COMPONENT_TEXT);
        txDepto.setForeground(COLOR_COMPONENT_TEXT);
        txDepto.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txDepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDeptoKeyTyped(evt);
            }
        });
        jPanel1.add(txDepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 200, 25));

        ltDeptos.setForeground(COLOR_COMPONENT_TEXT);
        ltDeptos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ltDeptos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltDeptosMouseClicked(evt);
            }
        });
        scDepto.setViewportView(ltDeptos);

        jPanel1.add(scDepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 115, 200, 97));

        txPais.setFont(FONT_COMPONENT_TEXT);
        txPais.setForeground(COLOR_COMPONENT_TEXT);
        txPais.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txPaisKeyTyped(evt);
            }
        });
        jPanel1.add(txPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 200, 25));

        ltPaises.setForeground(COLOR_COMPONENT_TEXT);
        ltPaises.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ltPaises.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ltPaisesMouseClicked(evt);
            }
        });
        scPais.setViewportView(ltPaises);

        jPanel1.add(scPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 115, 200, 97));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/icon_search_h.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/icon_search.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/icon_search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 40, 25));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyTyped
        try {
            llenarTabla();
        } catch (SQLException ex) {
            System.out.println("No se puede llenar la tabla");
        }
    }//GEN-LAST:event_txBuscarKeyTyped

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed

    }//GEN-LAST:event_btRegistrarActionPerformed

    private void tbLugaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLugaresMouseClicked

    }//GEN-LAST:event_tbLugaresMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        elegirLugar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txDeptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDeptoKeyTyped
        try {
            String _depto = txDepto.getText();
            if(!_depto.isEmpty()){
                llenarDeptos(_depto);
            }else{
                ocultarLista(scDepto);
            }
        } catch (SQLException ex) {
            System.out.println("No se puede cargar la lista de Departamentos");
        }
    }//GEN-LAST:event_txDeptoKeyTyped

    private void txPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txPaisKeyTyped
        try {
            String _pais = txPais.getText();
            if(!_pais.isEmpty()){
                llenarPaises(_pais);
            }else{
                ocultarLista(scPais);
            }
        } catch (SQLException ex) {
            System.out.println("No se puede cargar la lista de Paises");
        }
    }//GEN-LAST:event_txPaisKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("****************");
        System.out.println(ltDeptos.getModel());
        System.out.println(ltDeptos.getModel().getSize());
        System.out.println(ltDeptos.getParent());
        System.out.println(ltDeptos.getParent().getName());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ltDeptosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltDeptosMouseClicked
        seleccionarItemDeLista(txDepto, ltDeptos, scDepto);
        try {
            txPais.setText(control.getData("SELECT pais FROM paises WHERE id = (SELECT paises_id FROM deptos WHERE depto = '"+txDepto.getText()+"');", 1));
        } catch (SQLException ex) {
            System.out.println("No se puede extraer pais");
        }
    }//GEN-LAST:event_ltDeptosMouseClicked

    private void ltPaisesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltPaisesMouseClicked
        seleccionarItemDeLista(txPais, ltPaises, scPais);
    }//GEN-LAST:event_ltPaisesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        msg.Advertencia("Buscando...");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lugares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                Lugares dialog = new Lugares(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Lugares.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> ltDeptos;
    private javax.swing.JList<String> ltPaises;
    private javax.swing.JScrollPane scDepto;
    private javax.swing.JScrollPane scPais;
    private javax.swing.JTable tbLugares;
    private javax.swing.JTextField txBuscar;
    private javax.swing.JTextField txDepto;
    private javax.swing.JTextField txPais;
    private javax.swing.JTextField txProv;
    // End of variables declaration//GEN-END:variables

}
