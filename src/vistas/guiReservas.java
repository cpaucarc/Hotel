package vistas;

import Component.Dates;
import Component.TableModel;
import Component.Tables;
import componentes.Colores;
import componentes.Fuentes;
import componentes.Interfaz;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class guiReservas extends javax.swing.JFrame implements Fuentes, Colores, Interfaz {

    public static int idEmpresa = 0;
    public static int idLugar = 0;
    private final int idReserva = 0;
    private final TableModel mdPendiente = new TableModel();
    private final String[] hdPendiente = new String[]{"Id", "Fecha Reserva", "Entrada - Salida", "Habitacion", "Precio", "DNI", "Cliente", "Correo", "Procedencia"};
    
    long a ;
    public guiReservas() throws SQLException {
        a = System.currentTimeMillis();
        initComponents();
        System.out.println("acabo init" + (System.currentTimeMillis() - a));
        configuracion();
        System.out.println("acabo conf" + (System.currentTimeMillis() - a));
    }

    @Override
    public final void configuracion() throws SQLException {
        setExtendedState(6);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        Tables.Light(tbReservas);
        control.fillCombo(cbTipoHab, "SELECT tipo_hab FROM tipo_hab;", 1);
        Tables.setModel(tbReservas, mdPendiente, hdPendiente);
        Tables.WidthColumns(tbReservas, 95, 1);
        Tables.WidthColumns(tbReservas, 125, 2, 3);
        Tables.WidthColumns(tbReservas, 55, 4);
        Tables.WidthColumns(tbReservas, 73, 5);
        Tables.HideColumn(tbReservas, 0);
        llenarTablaPendientes();
    }

    @Override
    public boolean camposLlenos() {
        if (vld.validarCampo(txApePaterno)) {
            if (vld.validarCampo(txNombres)) {
                if (vld.validarLabel(lbLugar)) {
                    if (vld.validarFechas(dcEntrada.getDate(), dcSalida.getDate())) {
                        if (vld.validarCombo(cbHabDisponibles)) {
                            return true;
                        } else {
                            cbHabDisponibles.grabFocus();
                            msg.Advertencia("Falta elegir el numero de habitacion");
                            return false;
                        }
                    } else {
                        dcEntrada.grabFocus();
                        msg.Advertencia("Falta las fechas de Entrada y Salida");
                        return false;
                    }
                } else {
                    btElegirLugar.grabFocus();
                    msg.Advertencia("El cliente debe tener un lugar de procedencia");
                    return false;
                }
            } else {
                txNombres.grabFocus();
                msg.Advertencia("El campo Nombres es obligatorio");
                return false;
            }
        } else {
            txApePaterno.grabFocus();
            msg.Advertencia("El campo Apellido Paterno es obligatorio");
            return false;
        }
    }
    
    @Override
    public void limpiarCampos() {
        txDni.setText(null); txDni.grabFocus();
        txApeMaterno.setText(null);
        txApePaterno.setText(null);
        txNombres.setText(null);
        txCorreo.setText(null);
        lbLugar.setText(null);
        lbRazonSocialEmpresa.setText("Ninguna");
        dcEntrada.setDate(null);
        dcSalida.setDate(null);
        cbTipoHab.setSelectedIndex(0);
        cbHabDisponibles.removeAllItems();
    }
    
    private void buscarHabsDisponibles() throws SQLException {
        cbHabDisponibles.removeAllItems();        
        if (vld.validarFechas(dcEntrada.getDate(), dcSalida.getDate()) && vld.validarCombo(cbTipoHab)) {
            try {
                // Mejorar el SP sp_hab_disponibles
                control.fillCombo(cbHabDisponibles, "CALL sp_hab_disponibles('" + cbTipoHab.getSelectedItem().toString() + "', '"+Dates.getYearMonthDay(dcEntrada.getDate())+"', '"+Dates.getYearMonthDay(dcSalida.getDate())+"');", 1);
            } catch (SQLException ex) {
                System.out.println("No se pueden buscar las habitaciones \n" + ex);
            }
        }
    }

    private void registrarReserva() throws SQLException{
        String sql = "'" + Dates.getYearMonthDay(dcEntrada.getDate()) + "', '" + Dates.getYearMonthDay(dcSalida.getDate()) + "', ";
        
        sql += "'" + cbTipoHab.getSelectedItem().toString() + "', ";
        sql += "'" + cbHabDisponibles.getSelectedItem().toString() + "', ";
        
        if (vld.validarCampoConLongitud(txDni, 8))
            sql += txDni.getText() + ", ";
        else
            sql += "null, ";
        
        sql += "'" + txApePaterno.getText()+"', ";
        
        if (vld.validarCampo(txApeMaterno))
            sql += "'" + txApeMaterno.getText() + "', ";
        else
            sql += "null, ";
        
        sql += "'" + txNombres.getText()+"', ";
        
        if (vld.validarCampo(txCorreo))
            sql += "'" + txCorreo.getText() +"', ";
        else
            sql += "null, ";
        
        sql += idLugar + ", ";
        
        if (idEmpresa != 0 && vld.validarLabel(lbLugar))
            sql += idEmpresa;
        else
            sql += "null ";
        
        String[] rsta;
        rsta = control.getRowData("CALL sp_registrar_reserva(" + sql + ")", 2);
        if (rsta[0].equals("1")){
            msg.Exito(rsta[1]);
        }else{
            msg.Error(rsta[1]);
        }
    }
    
    private void llenarTablaPendientes() throws SQLException{
        control.fillTable(mdPendiente, "select id, DATE_FORMAT(fecha_reserva, '%d %b %h:%i') res, f_formatear_fechas(fecha_entrada, fecha_salida) es, concat(habitacion, ' - ',tipo_hab) hab, precio, dni, concat_ws(' ',ap_paterno, ap_materno, nombres) cliente, correo, concat_ws(' - ',provincia, depto, pais) lugar from v_reservas_pendientes having cliente like '"+txBuscarReserva.getText()+"%' order by fecha_entrada, ap_paterno;", 9);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmForm = new javax.swing.JPopupMenu();
        miLimpiarCampos = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txDni = new javax.swing.JTextField();
        txApePaterno = new javax.swing.JTextField();
        txApeMaterno = new javax.swing.JTextField();
        lbLugar = new javax.swing.JLabel();
        txNombres = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txCorreo = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btRegistrar = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lbRazonSocialEmpresa = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btElegirLugar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txBuscarReserva = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbReservas = new javax.swing.JTable();

        miLimpiarCampos.setText("Limpiar campos");
        miLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLimpiarCamposActionPerformed(evt);
            }
        });
        pmForm.add(miLimpiarCampos);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setComponentPopupMenu(pmForm);
        jPanel4.setPreferredSize(new java.awt.Dimension(380, 700));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(FONT_TITLE_1);
        jLabel10.setForeground(COLOR_TITLE_1);
        jLabel10.setText("Reservas");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 30));

        jLabel38.setFont(FONT_TITLE_2);
        jLabel38.setForeground(COLOR_TITLE_2);
        jLabel38.setText("Datos personales");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 140, 20));

        jLabel39.setFont(FONT_TITLE_2);
        jLabel39.setForeground(COLOR_TITLE_2);
        jLabel39.setText("Habitacion");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 535, -1, 20));

        jLabel41.setFont(FONT_TITLE_3);
        jLabel41.setForeground(COLOR_TITLE_3);
        jLabel41.setText("DNI");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 15));

        txDni.setFont(FONT_COMPONENT_TEXT);
        txDni.setForeground(COLOR_COMPONENT_TEXT);
        txDni.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel4.add(txDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 105, 100, 25));

        txApePaterno.setFont(FONT_COMPONENT_TEXT);
        txApePaterno.setForeground(COLOR_COMPONENT_TEXT);
        txApePaterno.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel4.add(txApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 155, 125, 25));

        txApeMaterno.setFont(FONT_COMPONENT_TEXT);
        txApeMaterno.setForeground(COLOR_COMPONENT_TEXT);
        txApeMaterno.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel4.add(txApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 155, 125, 25));

        lbLugar.setFont(FONT_COMPONENT_TEXT);
        lbLugar.setForeground(COLOR_COMPONENT_TEXT);
        jPanel4.add(lbLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 130, 20));

        txNombres.setFont(FONT_COMPONENT_TEXT);
        txNombres.setForeground(COLOR_COMPONENT_TEXT);
        txNombres.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel4.add(txNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 205, 270, 25));

        jLabel45.setFont(FONT_TITLE_3);
        jLabel45.setForeground(COLOR_TITLE_3);
        jLabel45.setText("Correo Electronico");
        jPanel4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, 15));

        txCorreo.setFont(FONT_COMPONENT_TEXT);
        txCorreo.setForeground(COLOR_COMPONENT_TEXT);
        txCorreo.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel4.add(txCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 255, 270, 25));

        jLabel46.setFont(FONT_TITLE_3);
        jLabel46.setForeground(COLOR_TITLE_3);
        jLabel46.setText("Fecha de Salida");
        jPanel4.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 495, -1, 25));

        btRegistrar.setBackground(COLOR_BTN_PRIMARY_BG);
        btRegistrar.setFont(FONT_BTN_PRIMARY);
        btRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btRegistrar.setText("Registrar reserva");
        btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel4.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 660, 160, 35));

        jLabel47.setFont(FONT_TITLE_3);
        jLabel47.setForeground(COLOR_TITLE_3);
        jLabel47.setText("Apellido Paterno");
        jPanel4.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, 15));

        jLabel48.setFont(FONT_TITLE_3);
        jLabel48.setForeground(COLOR_TITLE_3);
        jLabel48.setText("Apellido Materno");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 140, 120, 15));

        lbRazonSocialEmpresa.setFont(FONT_COMPONENT_TEXT);
        lbRazonSocialEmpresa.setForeground(COLOR_COMPONENT_TEXT);
        lbRazonSocialEmpresa.setText("Ninguna");
        jPanel4.add(lbRazonSocialEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 190, 20));

        btElegirEmpresa.setBackground(COLOR_BTN_SECONDARY_BG);
        btElegirEmpresa.setFont(FONT_BTN_SECONDARY);
        btElegirEmpresa.setForeground(COLOR_BTN_SECONDARY_FG);
        btElegirEmpresa.setText("Elegir");
        btElegirEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btElegirEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElegirEmpresaActionPerformed(evt);
            }
        });
        jPanel4.add(btElegirEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 80, 20));

        jLabel40.setFont(FONT_TITLE_2);
        jLabel40.setForeground(COLOR_TITLE_2);
        jLabel40.setText("Representacion de empresa");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, 20));

        jLabel50.setFont(FONT_TITLE_3);
        jLabel50.setForeground(COLOR_TITLE_3);
        jLabel50.setText("Hab. disponibles");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, -1, 25));

        dcSalida.setForeground(COLOR_COMPONENT_TEXT);
        dcSalida.setDateFormatString("d MMM, yyyy");
        dcSalida.setFont(FONT_COMPONENT_TEXT);
        dcSalida.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcSalidaPropertyChange(evt);
            }
        });
        jPanel4.add(dcSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 495, 150, 25));

        dcEntrada.setForeground(COLOR_COMPONENT_TEXT);
        dcEntrada.setDateFormatString("d MMM, yyyy");
        dcEntrada.setFont(FONT_COMPONENT_TEXT);
        dcEntrada.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcEntradaPropertyChange(evt);
            }
        });
        jPanel4.add(dcEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 455, 150, 25));

        jLabel44.setFont(FONT_TITLE_2);
        jLabel44.setForeground(COLOR_TITLE_2);
        jLabel44.setText("Fechas");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 20));

        jLabel51.setFont(FONT_TITLE_3);
        jLabel51.setForeground(COLOR_TITLE_3);
        jLabel51.setText("Fecha de Entrada");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 455, -1, 25));

        jLabel52.setFont(FONT_TITLE_3);
        jLabel52.setForeground(COLOR_TITLE_3);
        jLabel52.setText("Tipo de Habitacion");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, 25));

        cbHabDisponibles.setFont(FONT_COMPONENT_TEXT);
        cbHabDisponibles.setForeground(COLOR_COMPONENT_TEXT);
        jPanel4.add(cbHabDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 150, 25));

        cbTipoHab.setFont(FONT_COMPONENT_TEXT);
        cbTipoHab.setForeground(COLOR_COMPONENT_TEXT);
        cbTipoHab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoHabItemStateChanged(evt);
            }
        });
        jPanel4.add(cbTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 150, 25));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, -1));

        jLabel49.setFont(FONT_TITLE_3);
        jLabel49.setForeground(COLOR_TITLE_3);
        jLabel49.setText("Nombres");
        jPanel4.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 15));

        jLabel53.setFont(FONT_TITLE_3);
        jLabel53.setForeground(COLOR_TITLE_3);
        jLabel53.setText("Lugar");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 20));

        btElegirLugar.setBackground(COLOR_BTN_SECONDARY_BG);
        btElegirLugar.setFont(FONT_BTN_SECONDARY);
        btElegirLugar.setForeground(COLOR_BTN_SECONDARY_FG);
        btElegirLugar.setText("Elegir");
        btElegirLugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btElegirLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElegirLugarActionPerformed(evt);
            }
        });
        jPanel4.add(btElegirLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 80, 20));

        jScrollPane1.setViewportView(jPanel4);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(FONT_TITLE_3);
        jLabel11.setForeground(COLOR_TITLE_3);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel11.setText("Buscar");

        txBuscarReserva.setFont(FONT_COMPONENT_TEXT);
        txBuscarReserva.setForeground(COLOR_COMPONENT_TEXT);
        txBuscarReserva.setSelectionColor(COLOR_COMPONENT_SELECTION);
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btElegirEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElegirEmpresaActionPerformed
        try {
            new EmpresasRegistradas(this, true).setVisible(true);
        } catch (SQLException ex) {
            System.out.println("No se puede abrir la ventana");
        }
    }//GEN-LAST:event_btElegirEmpresaActionPerformed

    private void txBuscarReservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarReservaKeyTyped
        try {
            llenarTablaPendientes();
        } catch (SQLException ex) {
            Logger.getLogger(guiReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txBuscarReservaKeyTyped

    private void tbReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbReservasMouseClicked

    }//GEN-LAST:event_tbReservasMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        msg.Exito("Empresa: " + idEmpresa + "\nLugar: " + idLugar);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btElegirLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElegirLugarActionPerformed
        try {
            new Lugares(this, true).setVisible(true);
        } catch (SQLException ex) {
            System.out.println("No se puede abrir la ventana Lugares");
        }
    }//GEN-LAST:event_btElegirLugarActionPerformed

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        if (camposLlenos()){
            try {
                registrarReserva();
                llenarTablaPendientes();
            } catch (SQLException ex) {
                Logger.getLogger(guiReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void cbTipoHabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoHabItemStateChanged
        try {
            buscarHabsDisponibles();
        } catch (SQLException ex) {
            Logger.getLogger(guiReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbTipoHabItemStateChanged

    private void dcEntradaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcEntradaPropertyChange
        try {
            buscarHabsDisponibles();
        } catch (SQLException ex) {
            Logger.getLogger(guiReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dcEntradaPropertyChange

    private void dcSalidaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcSalidaPropertyChange
        try {
            buscarHabsDisponibles();
        } catch (SQLException ex) {
            Logger.getLogger(guiReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dcSalidaPropertyChange

    private void miLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLimpiarCamposActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_miLimpiarCamposActionPerformed

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
            java.util.logging.Logger.getLogger(guiReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new guiReservas().setVisible(true);
            } catch (SQLException ex) {
                System.out.println("No se puede cargar la ventana de Reservas \n" + ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btElegirEmpresa;
    private javax.swing.JButton btElegirLugar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbHabDisponibles;
    private javax.swing.JComboBox<String> cbTipoHab;
    private com.toedter.calendar.JDateChooser dcEntrada;
    private com.toedter.calendar.JDateChooser dcSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lbLugar;
    public static javax.swing.JLabel lbRazonSocialEmpresa;
    private javax.swing.JMenuItem miLimpiarCampos;
    private javax.swing.JPopupMenu pmForm;
    private javax.swing.JTable tbReservas;
    private javax.swing.JTextField txApeMaterno;
    private javax.swing.JTextField txApePaterno;
    private javax.swing.JTextField txBuscarReserva;
    private javax.swing.JTextField txCorreo;
    private javax.swing.JTextField txDni;
    private javax.swing.JTextField txNombres;
    // End of variables declaration//GEN-END:variables

}
