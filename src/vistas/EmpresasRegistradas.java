package vistas;

import Component.TableModel;
import Component.Tables;
import Conexion.Control;
import Database.Controller;
import componentes.Mensajes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresasRegistradas extends javax.swing.JDialog {

    Mensajes msg = new Mensajes();
    Controller control = Control.getControl();
    TableModel model = new TableModel();
    String[] header = new String[]{"Id", "RUC", "Denominacion o Razon Social"};
    private int idDeEmpresa = 0;

    public EmpresasRegistradas(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        Configuracion();
    }

    private void Configuracion() throws SQLException {
        Tables.setModel(tbEmpresas, model, header);
        Tables.Light(tbEmpresas, 27, false);
        Tables.HideColumn(tbEmpresas, 0);
        Tables.WidthColumns(tbEmpresas, 80, 1);
        llenarTabla();
    }

    private void llenarTabla() throws SQLException {
        control.fillTable(model, "SELECT * FROM empresas WHERE razon_social LIKE '" + txBuscar.getText() + "%';", 3);
    }
    
    private void seleccionarFila(){
        idDeEmpresa = Integer.parseInt(Tables.getDataFromSelectedRow(tbEmpresas, 0).toString());
        txRUC.setText(Tables.getDataFromSelectedRow(tbEmpresas, 1).toString());
        txRazonSocial.setText(Tables.getDataFromSelectedRow(tbEmpresas, 2).toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmEmpresas = new javax.swing.JPopupMenu();
        miElegirEmpresa = new javax.swing.JMenuItem();
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

        miElegirEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_enviar.png"))); // NOI18N
        miElegirEmpresa.setText("Elegir empresa");
        pmEmpresas.add(miElegirEmpresa);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(620, 610));
        setPreferredSize(new java.awt.Dimension(620, 610));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(8, 37, 69));
        jLabel10.setText("Empresas");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 35));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(53, 75, 99));
        jLabel42.setLabelFor(txRazonSocial);
        jLabel42.setText("Razon Social");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(53, 75, 99));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel43.setText("Buscar");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, 80, 25));

        txBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txBuscar.setForeground(new java.awt.Color(60, 80, 102));
        txBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 245, 440, 25));

        btRegistrar.setBackground(new java.awt.Color(0, 122, 255));
        btRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btRegistrar.setText("Registrar empresa");
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 35));

        txRazonSocial.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txRazonSocial.setForeground(new java.awt.Color(60, 80, 102));
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
        tbEmpresas.setComponentPopupMenu(pmEmpresas);
        tbEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpresasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpresas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 550, 260));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(53, 75, 99));
        jLabel44.setText("N° RUC");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        txRUC.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txRUC.setForeground(new java.awt.Color(60, 80, 102));
        jPanel1.add(txRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, 25));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        msg.Exito("ID: " + this.idDeEmpresa);
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
    private javax.swing.JPopupMenu pmEmpresas;
    private javax.swing.JTable tbEmpresas;
    private javax.swing.JTextField txBuscar;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txRazonSocial;
    // End of variables declaration//GEN-END:variables
}
