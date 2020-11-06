package vistas;

import Component.TableModel;
import Component.Tables;
import Component.TextField;
import componentes.Colores;
import componentes.Fuentes;
import componentes.Interfaz;
import java.sql.SQLException;

public class EmpresasRegistradas extends javax.swing.JDialog implements Colores, Fuentes, Interfaz {

    TableModel model = new TableModel();
    String[] header = new String[]{"Id", "RUC", "Denominacion o Razon Social"};

    private int idDeEmpresa = 0;

    public EmpresasRegistradas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        configuracion();
    }

    @Override
    public final void configuracion() throws SQLException {
        Tables.setModel(tbEmpresas, model, header);
        Tables.HideColumn(tbEmpresas, 0);
        Tables.Light(tbEmpresas);
        Tables.WidthColumns(tbEmpresas, 100, 1);
        llenarTabla();
    }

    @Override
    public void limpiarCampos() {
        idDeEmpresa = 0;
        txRUC.setText(null);
        txRUC.grabFocus();
        txRazonSocial.setText(null);
    }

    @Override
    public boolean camposLlenos() {
        if (vld.validarCampoConLongitud(txRUC, 11)) {
            if (vld.validarCampo(txRazonSocial)) {
                return true;
            } else {
                msg.Advertencia("Es necesario la Razon Social");
                txRazonSocial.grabFocus();
                return false;
            }
        } else {
            msg.Advertencia("Es necesario el numero de RUC");
            txRazonSocial.grabFocus();
            return false;
        }
    }

    private void llenarTabla() throws SQLException {
        control.fillTable(model, "SELECT * FROM empresas WHERE razon_social LIKE '" + txBuscar.getText() + "%';", 3);
    }

    private void seleccionarFila() {
        idDeEmpresa = Integer.parseInt(Tables.getDataFromSelectedRow(tbEmpresas, 0).toString());
        txRUC.setText(Tables.getDataFromSelectedRow(tbEmpresas, 1).toString());
        txRazonSocial.setText(Tables.getDataFromSelectedRow(tbEmpresas, 2).toString());
    }

    private void registrarEmpresa() throws SQLException {
        if (camposLlenos()) {
            control.executeQuery("INSERT INTO empresas VALUES (null, '" + txRUC.getText() + "', '" + txRazonSocial.getText() + "');");
        }
    }

    private void actualizarEmpresa() throws SQLException {
        if (camposLlenos()) {
            control.executeQuery("UPDATE empresas SET ruc = '" + txRUC.getText() + "', razon_social = '" + txRazonSocial.getText() + "' WHERE id = " + idDeEmpresa + ";");
        }
    }
    
    private void escogerEmpresa() throws SQLException{
        String[] datosEmpresa = control.getRowData("SELECT id, razon_social FROM empresas WHERE ruc = '"+txRUC.getText()+"';", 2);
        if (datosEmpresa != null){
            guiReservas.idEmpresa = Integer.parseInt(datosEmpresa[0]);
            guiReservas.lbRazonSocialEmpresa.setText(datosEmpresa[1]);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmTbEmpresas = new javax.swing.JPopupMenu();
        miElegirEmpresa = new javax.swing.JMenuItem();
        pmEmpresas = new javax.swing.JPopupMenu();
        miLimpiar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txBuscar = new javax.swing.JTextField();
        btRegistrar = new javax.swing.JButton();
        txRazonSocial = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpresas = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        txRUC = new javax.swing.JTextField();

        miElegirEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/icons8_forward_arrow_20px.png"))); // NOI18N
        miElegirEmpresa.setText("Elegir empresa");
        miElegirEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miElegirEmpresaActionPerformed(evt);
            }
        });
        pmTbEmpresas.add(miElegirEmpresa);

        miLimpiar.setText("Limpiar campos");
        miLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLimpiarActionPerformed(evt);
            }
        });
        pmEmpresas.add(miLimpiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 610));
        setPreferredSize(new java.awt.Dimension(620, 610));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(pmEmpresas);
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(FONT_TITLE_1);
        jLabel10.setForeground(COLOR_TITLE_1);
        jLabel10.setText("Empresas");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 35));

        jLabel42.setFont(FONT_TITLE_3);
        jLabel42.setForeground(COLOR_TITLE_3);
        jLabel42.setLabelFor(txRazonSocial);
        jLabel42.setText("Razon Social");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel43.setFont(FONT_TITLE_3);
        jLabel43.setForeground(COLOR_TITLE_3);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel43.setText("Buscar");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, 80, 25));

        txBuscar.setFont(FONT_COMPONENT_TEXT);
        txBuscar.setForeground(COLOR_COMPONENT_TEXT);
        txBuscar.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 245, 440, 25));

        btRegistrar.setBackground(COLOR_BTN_PRIMARY_BG);
        btRegistrar.setFont(FONT_BTN_PRIMARY);
        btRegistrar.setForeground(COLOR_BTN_PRIMARY_FG);
        btRegistrar.setText("Registrar empresa");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 140, 35));

        txRazonSocial.setFont(FONT_COMPONENT_TEXT);
        txRazonSocial.setForeground(COLOR_COMPONENT_TEXT);
        txRazonSocial.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel1.add(txRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 550, 25));

        tbEmpresas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEmpresas.setComponentPopupMenu(pmTbEmpresas);
        tbEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpresas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 550, 260));

        jLabel44.setFont(FONT_TITLE_3);
        jLabel44.setForeground(COLOR_TITLE_3);
        jLabel44.setText("N° RUC");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        txRUC.setFont(FONT_COMPONENT_TEXT);
        txRUC.setForeground(COLOR_COMPONENT_TEXT);
        txRUC.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txRUCKeyTyped(evt);
            }
        });
        jPanel1.add(txRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, 25));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed

        try {
            if (idDeEmpresa == 0) {
                registrarEmpresa();
                escogerEmpresa();
            } else {
                actualizarEmpresa();
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo operar la empresa");
        } finally {
            limpiarCampos();
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void txBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarKeyTyped
        try {
            llenarTabla();
        } catch (SQLException ex) {
            System.out.println("No se puede llenar la tabla");
        }
    }//GEN-LAST:event_txBuscarKeyTyped

    private void tbEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpresasMouseClicked
        seleccionarFila();
    }//GEN-LAST:event_tbEmpresasMouseClicked

    private void miElegirEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miElegirEmpresaActionPerformed
        try {
            if (idDeEmpresa != 0){
                escogerEmpresa();
            }
        } catch (SQLException ex) {
            System.out.println("No se puede escoger emmpresa.");
        }
    }//GEN-LAST:event_miElegirEmpresaActionPerformed

    private void miLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_miLimpiarActionPerformed

    private void txRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txRUCKeyTyped
        TextField.ruc(evt, txRUC);
    }//GEN-LAST:event_txRUCKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Error al asignar LAF.");
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                EmpresasRegistradas dialog = new EmpresasRegistradas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                System.out.println("No se puede la abrir la ventana");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miElegirEmpresa;
    private javax.swing.JMenuItem miLimpiar;
    private javax.swing.JPopupMenu pmEmpresas;
    private javax.swing.JPopupMenu pmTbEmpresas;
    private javax.swing.JTable tbEmpresas;
    private javax.swing.JTextField txBuscar;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txRazonSocial;
    // End of variables declaration//GEN-END:variables
}
