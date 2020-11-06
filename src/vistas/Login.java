package vistas;

import componentes.Colores;
import componentes.Fuentes;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Frank Paucar
 */
public class Login extends javax.swing.JFrame implements Colores, Fuentes {

    public Login() {
        initComponents();
        configuracionesDeVentana();
    }

    private void configuracionesDeVentana(){
        setSize(new Dimension(914, 488));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        txContr = new javax.swing.JPasswordField();
        btIngresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btOlvido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(FONT_TITLE_1);
        jLabel1.setForeground(COLOR_TITLE_1);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 78, 200, 40));

        jLabel2.setFont(FONT_TITLE_3);
        jLabel2.setForeground(COLOR_TITLE_3);
        jLabel2.setText("Nombre de usuario");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 166, 200, 22));

        jLabel3.setFont(FONT_TITLE_3);
        jLabel3.setForeground(COLOR_TITLE_3);
        jLabel3.setText("Contraseña");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 229, 200, 22));

        txUsuario.setFont(FONT_COMPONENT_TEXT);
        txUsuario.setForeground(COLOR_COMPONENT_TEXT);
        txUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txUsuario.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel1.add(txUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 188, 200, 27));

        txContr.setFont(FONT_COMPONENT_TEXT);
        txContr.setForeground(COLOR_COMPONENT_TEXT);
        txContr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txContr.setToolTipText("");
        txContr.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel1.add(txContr, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 251, 200, 27));

        btIngresar.setBackground(COLOR_BTN_PRIMARY_BG);
        btIngresar.setFont(FONT_BTN_PRIMARY);
        btIngresar.setForeground(COLOR_BTN_PRIMARY_FG);
        btIngresar.setText("Ingresar");
        btIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 298, 200, 35));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/Login_img.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 650, 450));

        btOlvido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btOlvido.setForeground(new java.awt.Color(0, 122, 255));
        btOlvido.setText("<html>\n<u>Olvide mi contraseña</u>\n<html>");
        btOlvido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btOlvido, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 349, 200, 23));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        try {
            new Principal().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JLabel btOlvido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txContr;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}
