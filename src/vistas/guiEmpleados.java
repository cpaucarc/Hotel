package vistas;

import Component.TableModel;
import Component.Tables;
import Component.TextField;
import Conexion.Control;
import Database.Controller;
import componentes.Colores;
import componentes.Fuentes;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import componentes.Mensajes;
import componentes.Validador;

/**
 * @author Frank Paucar
 */
public class guiEmpleados extends javax.swing.JFrame implements Colores, Fuentes{

    private int idEmpleado = 0;
    Controller control = Control.getControl();
    
    Mensajes msg = new Mensajes();
    Validador vld = new Validador();
    
    TableModel mdActivos = new TableModel();
    TableModel mdDespedidos = new TableModel();

    String[] hdActivos = new String[]{"Id", "DNI", "Empleado", "Correo", "Telefono", "Cargo", "Sueldo"};
    String[] hdDespedidos = new String[]{"Id", "DNI", "Empleado", "Correo", "Telefono", "Cargo", "Sueldo"};

    public guiEmpleados() throws SQLException {
        initComponents();
        Configuracion();
    }

    private void Configuracion() throws SQLException {
        setExtendedState(6);
        control.fillCombo(cbCargo, "SELECT * FROM cargos;", 2);

        Tables.setModel(tbActivos, mdActivos, hdActivos);
        Tables.setModel(tbDespedidos, mdDespedidos, hdDespedidos);
        Tables.Light(tbActivos);
        Tables.Light(tbDespedidos);
        Tables.HideColumn(tbActivos, 0);
        Tables.HideColumn(tbDespedidos, 0);        
        Tables.setRightAlignmentToColumn(tbActivos, 6);
        Tables.setRightAlignmentToColumn(tbDespedidos, 6);

        try {
            LlenarTablaActivos();
            LlenarTablaDespedidos();
        } catch (SQLException ex) {
            System.out.println("No se puede llenar las tablas \n" + ex);
        }
    }

    private void LlenarTablaActivos() throws SQLException {
        control.fillTable(mdActivos, "SELECT Id, DNI, concat_ws(' ', Paterno, Materno, Nombres) Empleado, Correo, Telefono, Cargo, Sueldo "
                + "FROM v_empleados_activos "
                + "WHERE Paterno LIKE '" + txBuscarActivo.getText() + "%' or DNI LIKE '" + txBuscarActivo.getText() + "%' or "
                + "Cargo LIKE '" + txBuscarActivo.getText() + "%';", 7);
    }

    private void LlenarTablaDespedidos() throws SQLException {
        control.fillTable(mdDespedidos, "SELECT Id, DNI, concat_ws(' ', Paterno, Materno, Nombres) Empleado, Correo, Telefono, Cargo, Sueldo FROM v_empleados_inactivos "
                + "WHERE Paterno LIKE '" + txBuscarActivo.getText() + "%' or DNI LIKE '" + txBuscarDespedido.getText() + "%' or "
                + "Cargo LIKE '" + txBuscarDespedido.getText() + "%';", 7);
    }

    private void SeleccionarEmpleado(String id, String[] datosEmpleado) throws SQLException {
        idEmpleado = Integer.parseInt(id);
        txDni.setText(datosEmpleado[1]);
        txApePaterno.setText(datosEmpleado[2]);
        txApeMaterno.setText(datosEmpleado[3]);
        txNombres.setText(datosEmpleado[4]);
        txCorreo.setText(datosEmpleado[5]);
        txTelefono.setText(datosEmpleado[6]);
        cbCargo.setSelectedItem(datosEmpleado[7]);
    }

    private void RegistrarEmpleado() throws SQLException {
        String sql = "CALL sp_registrar_empleado(" + txDni.getText() + ",'"
                + txApePaterno.getText() + "','" + txApeMaterno.getText() + "','" + txNombres.getText() + "',";
        if (txCorreo.getText().isEmpty()) {
            sql += "null,";
        } else {
            sql += "'" + txCorreo.getText() + "',";
        }
        if (txTelefono.getText().isEmpty()) {
            sql += "null,";
        } else {
            sql += "'" + txTelefono.getText() + "',";
        }
        sql += "'" + cbCargo.getSelectedItem().toString() + "');";

        String[] rsta = control.getRowData(sql, 2);

        if (rsta[0].equals("1")) { //Verdadero
            msg.Exito(rsta[1]);
            LimpiarCampos();
        } else {
            msg.Error(rsta[1]);
        }
    }

    private void ActualizarEmpleado() throws SQLException {
        String sql = "CALL sp_actualizar_empleado(" + idEmpleado + "," + txDni.getText() + ",'"
                + txApePaterno.getText() + "','" + txApeMaterno.getText() + "','" + txNombres.getText() + "',";
        if (txCorreo.getText().isEmpty()) {
            sql += "null,";
        } else {
            sql += "'" + txCorreo.getText() + "',";
        }
        if (txTelefono.getText().isEmpty()) {
            sql += "null,";
        } else {
            sql += "'" + txTelefono.getText() + "',";
        }
        sql += "'" + cbCargo.getSelectedItem().toString() + "');";

        String[] rsta = control.getRowData(sql, 2);

        if (rsta[0].equals("1")) { //Verdadero
            msg.Exito(rsta[1]);
            idEmpleado = 0;
            LimpiarCampos();
        } else {
            msg.Error(rsta[1]);
        }
    }

    private void LimpiarCampos() {
        txDni.setText(null);
        txApePaterno.setText(null);
        txApeMaterno.setText(null);
        txNombres.setText(null);
        txTelefono.setText(null);
        txCorreo.setText(null);
        cbCargo.setSelectedIndex(0);
    }
    
    private boolean CamposLlenos() {
        if (vld.validarCampoConLongitud(txDni, 8)) {
            if (vld.validarCampo(txApePaterno)) {
                if (vld.validarCampo(txApeMaterno)) {
                    if (vld.validarCampo(txNombres)) {
                        if (vld.validarCombo(cbCargo)) {
                            return true;
                        } else {
                            cbCargo.grabFocus();
                            msg.Advertencia("El campo Cargo es obligatorio");
                            return false;
                        }
                    } else {
                        txNombres.grabFocus();
                        msg.Advertencia("El campo Nombres es obligatorio");
                        return false;
                    }
                } else {
                    txApeMaterno.grabFocus();
                    msg.Advertencia("El campo Apellido Materno es obligatorio");
                    return false;
                }
            } else {
                txApePaterno.grabFocus();
                msg.Advertencia("El campo Apellido Paterno es obligatorio");
                return false;
            }
        } else {
            txDni.grabFocus();
            msg.Advertencia("El campo DNI es obligatorio");
            return false;
        }
    }

    private void DespedirEmpleado() throws SQLException {
        if (idEmpleado != 0) {
            String nomEmpleado = control.getData("SELECT concat_ws(' ', Paterno, Materno, Nombres) Empleado FROM v_empleados_activos where id = " + idEmpleado + ";", 1);
            int resp = msg.Pregunta("¿Quieres despedir a " + nomEmpleado + "?");
            if (resp == 0) {
                String mensaje = control.getData("CALL sp_despedir_empleado(" + idEmpleado + ")", 1);
                System.out.println(mensaje);
            }
        } else {
            msg.Advertencia("No ha seleccionado ningun elemento");
        }
    }

    private void RecontratarEmpleado() throws SQLException {
        if (idEmpleado != 0) {
            String nomEmpleado = control.getData("SELECT concat_ws(' ', Paterno, Materno, Nombres) Empleado FROM v_empleados_inactivos where id = " + idEmpleado + ";", 1);
            int resp = msg.Pregunta("¿Quieres recontratar a " + nomEmpleado + "?");
            if (resp == 0) {
                String mensaje = control.getData("CALL sp_recontratar_empleado(" + idEmpleado + ")", 1);
                System.out.println(mensaje);
            }
        } else {
            msg.Advertencia("No ha seleccionado ningun elemento");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmCampos = new javax.swing.JPopupMenu();
        miLimpiarCampos = new javax.swing.JMenuItem();
        pmTbActivos = new javax.swing.JPopupMenu();
        miDespedir = new javax.swing.JMenuItem();
        pmTbDespedidos = new javax.swing.JPopupMenu();
        miContratar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txDni = new javax.swing.JTextField();
        txApePaterno = new javax.swing.JTextField();
        txApeMaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txNombres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txTelefono = new javax.swing.JTextField();
        txCorreo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        btRegistrar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txBuscarActivo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbActivos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txBuscarDespedido = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDespedidos = new javax.swing.JTable();

        miLimpiarCampos.setText("Limpiar todos los campos");
        miLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLimpiarCamposActionPerformed(evt);
            }
        });
        pmCampos.add(miLimpiarCampos);

        miDespedir.setText("Despedir al empleado");
        miDespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDespedirActionPerformed(evt);
            }
        });
        pmTbActivos.add(miDespedir);

        miContratar.setText("Contratar empleado");
        miContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miContratarActionPerformed(evt);
            }
        });
        pmTbDespedidos.add(miContratar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(pmCampos);
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(FONT_TITLE_1);
        jLabel2.setForeground(COLOR_TITLE_1);
        jLabel2.setText("Empleados");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, 35));

        jLabel3.setFont(FONT_TITLE_2);
        jLabel3.setForeground(COLOR_TITLE_2);
        jLabel3.setText("Datos personales");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 290, 20));

        jLabel4.setFont(FONT_TITLE_2);
        jLabel4.setForeground(COLOR_TITLE_2);
        jLabel4.setText("Datos del empleo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, 20));

        jLabel5.setFont(FONT_TITLE_2);
        jLabel5.setForeground(COLOR_TITLE_2);
        jLabel5.setText("Datos de contacto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        jLabel6.setFont(FONT_TITLE_3);
        jLabel6.setForeground(COLOR_TITLE_3);
        jLabel6.setText("DNI");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        txDni.setFont(FONT_COMPONENT_TEXT);
        txDni.setForeground(COLOR_COMPONENT_TEXT);
        txDni.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txDniKeyTyped(evt);
            }
        });
        jPanel1.add(txDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 25));

        txApePaterno.setFont(FONT_COMPONENT_TEXT);
        txApePaterno.setForeground(COLOR_COMPONENT_TEXT);
        txApePaterno.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txApePaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txApePaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 125, 25));

        txApeMaterno.setFont(FONT_COMPONENT_TEXT);
        txApeMaterno.setForeground(COLOR_COMPONENT_TEXT);
        txApeMaterno.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txApeMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txApeMaternoKeyTyped(evt);
            }
        });
        jPanel1.add(txApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 220, 125, 25));

        jLabel8.setFont(FONT_TITLE_3);
        jLabel8.setForeground(COLOR_TITLE_3);
        jLabel8.setText("Nombres");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 20));

        txNombres.setFont(FONT_COMPONENT_TEXT);
        txNombres.setForeground(COLOR_COMPONENT_TEXT);
        txNombres.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txNombresKeyTyped(evt);
            }
        });
        jPanel1.add(txNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 270, 25));

        jLabel9.setFont(FONT_TITLE_3);
        jLabel9.setForeground(COLOR_TITLE_3);
        jLabel9.setText("Telefono");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 20));

        jLabel11.setFont(FONT_TITLE_3);
        jLabel11.setForeground(COLOR_TITLE_3);
        jLabel11.setText("Correo Electronico");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, 20));

        txTelefono.setFont(FONT_COMPONENT_TEXT);
        txTelefono.setForeground(COLOR_COMPONENT_TEXT);
        txTelefono.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 125, 25));

        txCorreo.setFont(FONT_COMPONENT_TEXT);
        txCorreo.setForeground(COLOR_COMPONENT_TEXT);
        txCorreo.setSelectionColor(COLOR_COMPONENT_SELECTION);
        jPanel1.add(txCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 270, 25));

        jLabel12.setFont(FONT_TITLE_3);
        jLabel12.setForeground(COLOR_TITLE_3);
        jLabel12.setText("Cargo");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, 20));

        cbCargo.setFont(FONT_COMPONENT_TEXT);
        cbCargo.setForeground(COLOR_COMPONENT_TEXT);
        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 270, 25));

        btRegistrar.setBackground(COLOR_BTN_PRIMARY_BG);
        btRegistrar.setFont(FONT_BTN_PRIMARY);
        btRegistrar.setForeground(COLOR_BTN_PRIMARY_FG);
        btRegistrar.setText("Registrar Empleado");
        btRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 600, 160, 35));

        jLabel28.setFont(FONT_TITLE_3);
        jLabel28.setForeground(COLOR_TITLE_3);
        jLabel28.setText("Apellido Paterno");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, 20));

        jLabel37.setFont(FONT_TITLE_3);
        jLabel37.setForeground(COLOR_TITLE_3);
        jLabel37.setText("Apellido Materno");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 200, 120, 20));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.WEST);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(31, 26, 46));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(FONT_TITLE_3);
        jLabel1.setForeground(COLOR_TITLE_3);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel1.setText("Buscar");

        txBuscarActivo.setFont(FONT_COMPONENT_TEXT);
        txBuscarActivo.setForeground(COLOR_COMPONENT_TEXT);
        txBuscarActivo.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txBuscarActivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarActivoKeyTyped(evt);
            }
        });

        tbActivos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbActivos.setComponentPopupMenu(pmTbActivos);
        tbActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbActivosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbActivos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txBuscarActivo)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBuscarActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Empleados Activos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(FONT_TITLE_3);
        jLabel10.setForeground(COLOR_TITLE_3);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel10.setText("Buscar");

        txBuscarDespedido.setFont(FONT_COMPONENT_TEXT);
        txBuscarDespedido.setForeground(COLOR_COMPONENT_TEXT);
        txBuscarDespedido.setSelectionColor(COLOR_COMPONENT_SELECTION);
        txBuscarDespedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txBuscarDespedidoKeyTyped(evt);
            }
        });

        tbDespedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDespedidos.setComponentPopupMenu(pmTbDespedidos);
        tbDespedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDespedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDespedidos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txBuscarDespedido)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBuscarDespedido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Empleados Despedidos", jPanel4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        if (CamposLlenos()) {
            if (idEmpleado == 0) {
                try {
                    RegistrarEmpleado();
                } catch (SQLException ex) {
                    System.out.println("Hubo un error al registrar al empleado \n" + ex);
                }
            } else {
                try {
                    ActualizarEmpleado();
                } catch (SQLException ex) {
                    System.out.println("Hubo un error al actualizar al empleado \n" + ex);
                }
            }
        }
        try {
            LlenarTablaActivos();
            LlenarTablaDespedidos();
        } catch (SQLException ex) {
            System.out.println("No se puede llenar las tablas \n" + ex);
        }

    }//GEN-LAST:event_btRegistrarActionPerformed

    private void tbDespedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDespedidosMouseClicked
        try {
            String id = (String) Tables.getDataFromSelectedRow(tbDespedidos, 0);
            String[] datosEmpleado = control.getRowData("SELECT * FROM v_empleados_inactivos WHERE Id = " + id + ";", 9);
            SeleccionarEmpleado(id, datosEmpleado);
        } catch (SQLException ex) {
            System.out.println("No se puede capturar el id del empleado despedido\n" + ex);
        }
    }//GEN-LAST:event_tbDespedidosMouseClicked

    private void tbActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActivosMouseClicked
        try {
            String id = (String) Tables.getDataFromSelectedRow(tbActivos, 0);
            String[] datosEmpleado = control.getRowData("SELECT * FROM v_empleados_activos WHERE Id = " + id + ";", 9);
            SeleccionarEmpleado(id, datosEmpleado);
        } catch (SQLException ex) {
            System.out.println("No se puede capturar el id del empleado activo\n" + ex);
        }
    }//GEN-LAST:event_tbActivosMouseClicked

    private void miLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLimpiarCamposActionPerformed
        LimpiarCampos();
    }//GEN-LAST:event_miLimpiarCamposActionPerformed

    private void miDespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDespedirActionPerformed
        try {
            DespedirEmpleado();
            LimpiarCampos();
            LlenarTablaActivos();
            LlenarTablaDespedidos();
        } catch (SQLException ex) {
            Logger.getLogger(guiEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miDespedirActionPerformed

    private void miContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miContratarActionPerformed
        try {
            RecontratarEmpleado();
            LimpiarCampos();
            LlenarTablaActivos();
            LlenarTablaDespedidos();
        } catch (SQLException ex) {
            Logger.getLogger(guiEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miContratarActionPerformed

    private void txDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDniKeyTyped
        TextField.dni(evt, txDni);
    }//GEN-LAST:event_txDniKeyTyped

    private void txTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTelefonoKeyTyped
        TextField.phone(evt, txTelefono);
    }//GEN-LAST:event_txTelefonoKeyTyped

    private void txApePaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txApePaternoKeyTyped
        TextField.capitalize(evt, txApePaterno);
        TextField.noSpace(evt);
    }//GEN-LAST:event_txApePaternoKeyTyped

    private void txApeMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txApeMaternoKeyTyped
        TextField.capitalize(evt, txApeMaterno);
        TextField.noSpace(evt);
    }//GEN-LAST:event_txApeMaternoKeyTyped

    private void txNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNombresKeyTyped
        TextField.capitalize(evt, txNombres);
    }//GEN-LAST:event_txNombresKeyTyped

    private void txBuscarActivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarActivoKeyTyped
        try {
            LlenarTablaActivos();
        } catch (SQLException ex) {
            Logger.getLogger(guiEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txBuscarActivoKeyTyped

    private void txBuscarDespedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txBuscarDespedidoKeyTyped
        try {
            LlenarTablaDespedidos();
        } catch (SQLException ex) {
            Logger.getLogger(guiEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txBuscarDespedidoKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Error al asignar el LAF.");
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new guiEmpleados().setVisible(true);
            } catch (SQLException ex) {
                System.out.println("No se puede abrir el interfaz Empleados");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegistrar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem miContratar;
    private javax.swing.JMenuItem miDespedir;
    private javax.swing.JMenuItem miLimpiarCampos;
    private javax.swing.JPopupMenu pmCampos;
    private javax.swing.JPopupMenu pmTbActivos;
    private javax.swing.JPopupMenu pmTbDespedidos;
    private javax.swing.JTable tbActivos;
    private javax.swing.JTable tbDespedidos;
    private javax.swing.JTextField txApeMaterno;
    private javax.swing.JTextField txApePaterno;
    private javax.swing.JTextField txBuscarActivo;
    private javax.swing.JTextField txBuscarDespedido;
    private javax.swing.JTextField txCorreo;
    private javax.swing.JTextField txDni;
    private javax.swing.JTextField txNombres;
    private javax.swing.JTextField txTelefono;
    // End of variables declaration//GEN-END:variables
}
