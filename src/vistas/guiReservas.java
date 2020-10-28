package vistas;

import Component.Tables;
import javax.swing.JOptionPane;

public class guiReservas extends javax.swing.JFrame {

    public guiReservas() {
        initComponents();
        Configuraciones();
    }
        
    private void Configuraciones(){
        setExtendedState(6);
        Tables.Dark(tbReservas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txDni = new javax.swing.JTextField();
        txApePaterno = new javax.swing.JTextField();
        txApeMaterno = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txNombres = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txCorreo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btRegistrar = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btElegirEmpresa = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        dcSalida = new com.toedter.calendar.JDateChooser();
        dcEntrada = new com.toedter.calendar.JDateChooser();
        jLabel44 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        cbHabDisponibles = new javax.swing.JComboBox<>();
        cbTipoHab = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txBuscarReserva = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbReservas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(380, 700));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(8, 37, 69));
        jLabel10.setText("Reservas");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 35));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(3, 32, 65));
        jLabel38.setText("Datos personales");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 140, 20));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(3, 32, 65));
        jLabel39.setText("Habitacion");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 535, -1, 20));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(53, 75, 99));
        jLabel41.setText("DNI");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        txDni.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txDni.setForeground(new java.awt.Color(60, 80, 102));
        txDni.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 100, 25));

        txApePaterno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApePaterno.setForeground(new java.awt.Color(60, 80, 102));
        txApePaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 125, 25));

        txApeMaterno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApeMaterno.setForeground(new java.awt.Color(60, 80, 102));
        txApeMaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 180, 125, 25));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(53, 75, 99));
        jLabel43.setText("Nombres");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, 20));

        txNombres.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txNombres.setForeground(new java.awt.Color(60, 80, 102));
        txNombres.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 270, 25));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(53, 75, 99));
        jLabel45.setText("Correo Electronico");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 20));

        txCorreo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txCorreo.setForeground(new java.awt.Color(60, 80, 102));
        txCorreo.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 270, 25));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(53, 75, 99));
        jLabel46.setText("Fecha de Salida");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 495, -1, 25));

        btRegistrar.setBackground(new java.awt.Color(0, 120, 255));
        btRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btRegistrar.setText("Registrar reserva");
        btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 660, 160, 35));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(92, 108, 133));
        jLabel47.setText("Apellido Paterno");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 120, 20));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(92, 108, 133));
        jLabel48.setText("Apellido Materno");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 160, 120, 20));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(53, 75, 99));
        jLabel49.setText("Ninguna");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 190, 20));

        btElegirEmpresa.setForeground(new java.awt.Color(33, 29, 37));
        btElegirEmpresa.setText("Elegir");
        btElegirEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btElegirEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElegirEmpresaActionPerformed(evt);
            }
        });
        jPanel4.add(btElegirEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(3, 32, 65));
        jLabel40.setText("Representacion de empresa");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 20));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(53, 75, 99));
        jLabel50.setText("Hab. disponibles");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, -1, 25));

        dcSalida.setDateFormatString("yyyy-MM-dd");
        dcSalida.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel4.add(dcSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 495, 150, 25));

        dcEntrada.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel4.add(dcEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 455, 150, 25));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(3, 32, 65));
        jLabel44.setText("Fechas");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 20));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(53, 75, 99));
        jLabel51.setText("Fecha de Entrada");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 455, -1, 25));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(53, 75, 99));
        jLabel52.setText("Tipo de Habitacion");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, 25));

        cbHabDisponibles.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbHabDisponibles.setForeground(new java.awt.Color(75, 88, 118));
        cbHabDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbHabDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 150, 25));

        cbTipoHab.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbTipoHab.setForeground(new java.awt.Color(75, 88, 118));
        cbTipoHab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 150, 25));

        jScrollPane1.setViewportView(jPanel4);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel11.setText("Buscar");

        txBuscarReserva.setForeground(new java.awt.Color(75, 88, 118));
        txBuscarReserva.setSelectionColor(new java.awt.Color(0, 122, 255));
        txBuscarReserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarReservaKeyTyped(evt);
            }
        });

        tbReservas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbReservasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbReservas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txBuscarReserva)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBuscarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btElegirEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElegirEmpresaActionPerformed
        new EmpresasRegistradas(this, true).setVisible(true);
    }//GEN-LAST:event_btElegirEmpresaActionPerformed

    private void txBuscarReservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarReservaKeyTyped

    }//GEN-LAST:event_txBuscarReservaKeyTyped

    private void tbReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservasMouseClicked

    }//GEN-LAST:event_tbReservasMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(guiReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btElegirEmpresa;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbHabDisponibles;
    private javax.swing.JComboBox<String> cbTipoHab;
    private com.toedter.calendar.JDateChooser dcEntrada;
    private com.toedter.calendar.JDateChooser dcSalida;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    public static javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbReservas;
    private javax.swing.JTextField txApeMaterno;
    private javax.swing.JTextField txApePaterno;
    private javax.swing.JTextField txBuscarReserva;
    private javax.swing.JTextField txCorreo;
    private javax.swing.JTextField txDni;
    private javax.swing.JTextField txNombres;
    // End of variables declaration//GEN-END:variables
}
