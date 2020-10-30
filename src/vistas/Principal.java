package vistas;

import Component.TableModel;
import Component.Tables;
import Conexion.Control;
import Database.Controller;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal extends javax.swing.JFrame {

    CardLayout cardLayout;
    Controller control = Control.getControl();
    
    TableModel modelEmpleadosActivo = new TableModel();
    TableModel modelEmpleadosInactivo = new TableModel();
    
    public Principal() throws SQLException {
        initComponents();
        cardLayout = (CardLayout)(pnInterfaces.getLayout());
        configuracionesIniciales();
        Tables.setModel(tbEmpleadosActivos, modelEmpleadosActivo, new String[]{"Id", "Empleado", "Correo", "Telefono", "Cargo", "Sueldo"});
        control.fillTable(modelEmpleadosActivo, "SELECT * FROM v_empleados_activos;", 6);
        Tables.setModel(tbEmpleadosDespedidos, modelEmpleadosInactivo, new String[]{"Id", "Empleado", "Correo", "Telefono", "Cargo", "Sueldo"});
        control.fillTable(modelEmpleadosInactivo, "SELECT * FROM v_empleados_inactivos;", 6);
        Tables.Light(tbEmpleadosActivos);
        Tables.Light(tbEmpleadosDespedidos);

    }
    
    public final void configuracionesIniciales(){
        setExtendedState(6);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmEmpleados = new javax.swing.JPopupMenu();
        miLimpiarCampos = new javax.swing.JMenuItem();
        pmHabitaciones = new javax.swing.JPopupMenu();
        miVolverCargarHabs = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnSidebar = new javax.swing.JPanel();
        lbLogo = new javax.swing.JLabel();
        lbHabitacion = new javax.swing.JLabel();
        lbReserva = new javax.swing.JLabel();
        lbAlojamiento = new javax.swing.JLabel();
        lbServicio = new javax.swing.JLabel();
        lbCliente = new javax.swing.JLabel();
        pnAdministrador = new javax.swing.JPanel();
        lbEmpleado = new javax.swing.JLabel();
        lbComprobante = new javax.swing.JLabel();
        lbConfiguracion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnInterfaces = new javax.swing.JPanel();
        pnDashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnHabitacion = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnNivel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbVolverCargarHabN2 = new javax.swing.JLabel();
        pnNivel3 = new javax.swing.JPanel();
        lbVolverCargarHabN3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btDejarHab = new javax.swing.JButton();
        txNumHab = new javax.swing.JTextField();
        txTipoHab = new javax.swing.JTextField();
        txPrecioHab = new javax.swing.JTextField();
        txTotalHab = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txDniClienteHab = new javax.swing.JTextField();
        txNombreClienteHab = new javax.swing.JTextField();
        txLugarClienteHab = new javax.swing.JTextField();
        txEmpresaClienteHab = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        sliderFechas = new javax.swing.JSlider();
        lbFechaEntrada = new javax.swing.JLabel();
        lbFechaSalida = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbServicosHab = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        txTotalServiciosHab = new javax.swing.JTextField();
        pnReserva = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txDniClienteReserva = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txApePaternoCliReserva = new javax.swing.JTextField();
        txApeMaternoCliReserva = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txNombresCliReserva = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txCorreoCliReserva = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btRegistrarEmpleado1 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btElegirEmpresa = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        dcSalida = new com.toedter.calendar.JDateChooser();
        dcEntradaReserva = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnAlojamiento = new javax.swing.JPanel();
        pnServicio = new javax.swing.JPanel();
        pnEmpleado = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txDniEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txApePaterno = new javax.swing.JTextField();
        txApeMaterno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txNombresEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txTelefonoEmpleado = new javax.swing.JTextField();
        txCorreoEmpleado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbCargoEmpleado = new javax.swing.JComboBox<>();
        btRegistrarEmpleado = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txBuscarEmpleadoActivo = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbEmpleadosActivos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txBuscarEmpleadoDespedido = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbEmpleadosDespedidos = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        pnComprobante = new javax.swing.JPanel();
        pnCliente = new javax.swing.JPanel();
        pnConfiguracion = new javax.swing.JPanel();

        miLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_limpiar.png"))); // NOI18N
        miLimpiarCampos.setText("Limpiar campos");
        miLimpiarCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pmEmpleados.add(miLimpiarCampos);

        miVolverCargarHabs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_cargar.png"))); // NOI18N
        miVolverCargarHabs.setText("Volver a cargar");
        pmHabitaciones.add(miVolverCargarHabs);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBackground(new java.awt.Color(246, 250, 253));
        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(150, 150));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(150, 730));

        jScrollPane1.setBorder(null);

        pnSidebar.setBackground(new java.awt.Color(246, 250, 253));
        pnSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/logo.png"))); // NOI18N
        lbLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoMouseClicked(evt);
            }
        });
        pnSidebar.add(lbLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 130));

        lbHabitacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHabitacion.setForeground(new java.awt.Color(92, 108, 133));
        lbHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbHabitacion.setText("Habitaciones");
        lbHabitacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHabitacionMouseClicked(evt);
            }
        });
        pnSidebar.add(lbHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, 30));

        lbReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbReserva.setForeground(new java.awt.Color(92, 108, 133));
        lbReserva.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbReserva.setText("Reservas");
        lbReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbReservaMouseClicked(evt);
            }
        });
        pnSidebar.add(lbReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 30));

        lbAlojamiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAlojamiento.setForeground(new java.awt.Color(92, 108, 133));
        lbAlojamiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAlojamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbAlojamiento.setText("Alojamientos");
        lbAlojamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAlojamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAlojamientoMouseClicked(evt);
            }
        });
        pnSidebar.add(lbAlojamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 130, 30));

        lbServicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbServicio.setForeground(new java.awt.Color(92, 108, 133));
        lbServicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbServicio.setText("Servicios");
        lbServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbServicioMouseClicked(evt);
            }
        });
        pnSidebar.add(lbServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 130, 30));

        lbCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCliente.setForeground(new java.awt.Color(92, 108, 133));
        lbCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbCliente.setText("Clientes");
        lbCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClienteMouseClicked(evt);
            }
        });
        pnSidebar.add(lbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, 30));

        pnAdministrador.setBackground(new java.awt.Color(246, 250, 253));
        pnAdministrador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEmpleado.setForeground(new java.awt.Color(92, 108, 133));
        lbEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbEmpleado.setText("Empleados");
        lbEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEmpleadoMouseClicked(evt);
            }
        });
        pnAdministrador.add(lbEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        lbComprobante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbComprobante.setForeground(new java.awt.Color(92, 108, 133));
        lbComprobante.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbComprobante.setText("Comprobantes");
        lbComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbComprobanteMouseClicked(evt);
            }
        });
        pnAdministrador.add(lbComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 30));

        lbConfiguracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbConfiguracion.setForeground(new java.awt.Color(92, 108, 133));
        lbConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_habitacion2.png"))); // NOI18N
        lbConfiguracion.setText("Configuracion");
        lbConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConfiguracionMouseClicked(evt);
            }
        });
        pnAdministrador.add(lbConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, 30));

        pnSidebar.add(pnAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, -1, 130));

        jScrollPane1.setViewportView(pnSidebar);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jScrollPane2.setBorder(null);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1211, 710));

        pnInterfaces.setBackground(new java.awt.Color(255, 255, 255));
        pnInterfaces.setPreferredSize(new java.awt.Dimension(1211, 710));
        pnInterfaces.setLayout(new java.awt.CardLayout());

        pnDashboard.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setText("soy el dash");

        javax.swing.GroupLayout pnDashboardLayout = new javax.swing.GroupLayout(pnDashboard);
        pnDashboard.setLayout(pnDashboardLayout);
        pnDashboardLayout.setHorizontalGroup(
            pnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDashboardLayout.createSequentialGroup()
                .addContainerGap(924, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(373, 373, 373))
        );
        pnDashboardLayout.setVerticalGroup(
            pnDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDashboardLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(603, Short.MAX_VALUE))
        );

        pnInterfaces.add(pnDashboard, "pnDashboard");

        pnHabitacion.setBackground(new java.awt.Color(255, 255, 255));
        pnHabitacion.setLayout(new javax.swing.BoxLayout(pnHabitacion, javax.swing.BoxLayout.PAGE_AXIS));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(191, 191, 191)));
        jTabbedPane2.setForeground(new java.awt.Color(92, 108, 133));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setComponentPopupMenu(pmHabitaciones);
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTabbedPane2.setMinimumSize(new java.awt.Dimension(669, 340));
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1144, 340));

        pnNivel2.setBackground(new java.awt.Color(255, 255, 255));
        pnNivel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 147, 168));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(8, 37, 69));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("201");
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 50));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(53, 75, 99));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Individual");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        pnNivel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 50, -1, 100));

        jPanel14.setBackground(new java.awt.Color(165, 235, 177));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(8, 37, 69));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("201");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 50));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(53, 75, 99));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Individual");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        pnNivel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 190, -1, 100));

        jPanel15.setBackground(new java.awt.Color(252, 219, 162));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(8, 37, 69));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("201");
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(53, 75, 99));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Individual");
        jPanel15.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        pnNivel2.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, 100));

        jPanel16.setBackground(new java.awt.Color(127, 188, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(8, 37, 69));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("201");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 50));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(53, 75, 99));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Individual");
        jPanel16.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 30));

        pnNivel2.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, 100));

        lbVolverCargarHabN2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbVolverCargarHabN2.setForeground(new java.awt.Color(92, 108, 133));
        lbVolverCargarHabN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_actualizar.png"))); // NOI18N
        lbVolverCargarHabN2.setText("Volver a cargar");
        lbVolverCargarHabN2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbVolverCargarHabN2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnNivel2.add(lbVolverCargarHabN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTabbedPane2.addTab("Nivel 2", pnNivel2);

        pnNivel3.setBackground(new java.awt.Color(255, 255, 255));
        pnNivel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbVolverCargarHabN3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lbVolverCargarHabN3.setForeground(new java.awt.Color(92, 108, 133));
        lbVolverCargarHabN3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_actualizar.png"))); // NOI18N
        lbVolverCargarHabN3.setText("Volver a cargar");
        lbVolverCargarHabN3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbVolverCargarHabN3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnNivel3.add(lbVolverCargarHabN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jTabbedPane2.addTab("Nivel 3", pnNivel3);

        pnHabitacion.add(jTabbedPane2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(3, 32, 65));
        jLabel14.setText("Datos de la habitación");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 25));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(53, 75, 99));
        jLabel16.setText("N° de habitación");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 150, 25));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(53, 75, 99));
        jLabel17.setText("Tipo de habitación");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, 25));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(53, 75, 99));
        jLabel18.setText("Precio por dia");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 155, 150, 25));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(53, 75, 99));
        jLabel19.setText("Total por uso de habitación");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 25));

        btDejarHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btDejarHab.setText("Dejar habitación");
        jPanel3.add(btDejarHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 290, 125, 30));

        txNumHab.setEditable(false);
        jPanel3.add(txNumHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 65, 220, 25));

        txTipoHab.setEditable(false);
        jPanel3.add(txTipoHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 110, 220, 25));

        txPrecioHab.setEditable(false);
        jPanel3.add(txPrecioHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 155, 220, 25));

        txTotalHab.setEditable(false);
        jPanel3.add(txTotalHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 200, 220, 25));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(3, 32, 65));
        jLabel29.setText("Datos del cliente");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 25));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(53, 75, 99));
        jLabel30.setText("DNI");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 130, 25));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(53, 75, 99));
        jLabel31.setText("Nombre del cliente");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 25));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(53, 75, 99));
        jLabel32.setText("Lugar de procedencia");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 155, 130, 25));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(53, 75, 99));
        jLabel33.setText("Empresa");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 25));

        txDniClienteHab.setEditable(false);
        txDniClienteHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel8.add(txDniClienteHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 65, 220, 25));

        txNombreClienteHab.setEditable(false);
        txNombreClienteHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel8.add(txNombreClienteHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 220, 25));

        txLugarClienteHab.setEditable(false);
        txLugarClienteHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel8.add(txLugarClienteHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 155, 220, 25));

        txEmpresaClienteHab.setEditable(false);
        txEmpresaClienteHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel8.add(txEmpresaClienteHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 220, 25));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(3, 32, 65));
        jLabel34.setText("Tiempo de uso");
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, -1, -1));

        sliderFechas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        sliderFechas.setForeground(new java.awt.Color(53, 75, 99));
        sliderFechas.setMajorTickSpacing(2);
        sliderFechas.setMaximum(20);
        sliderFechas.setPaintLabels(true);
        sliderFechas.setPaintTicks(true);
        sliderFechas.setSnapToTicks(true);
        sliderFechas.setValue(7);
        sliderFechas.setOpaque(false);
        jPanel8.add(sliderFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 360, -1));

        lbFechaEntrada.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbFechaEntrada.setForeground(new java.awt.Color(53, 75, 99));
        lbFechaEntrada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbFechaEntrada.setText("jLabel35");
        jPanel8.add(lbFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, -1));

        lbFechaSalida.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbFechaSalida.setForeground(new java.awt.Color(53, 75, 99));
        lbFechaSalida.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFechaSalida.setText("jLabel36");
        jPanel8.add(lbFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 340, 100, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(3, 32, 65));
        jLabel35.setText("Servicios recibidos");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 25));

        tbServicosHab.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tbServicosHab);

        jPanel9.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 65, 370, 260));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(53, 75, 99));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("Total:     S/.");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 70, 20));

        txTotalServiciosHab.setEditable(false);
        txTotalServiciosHab.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel9.add(txTotalServiciosHab, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 340, 250, -1));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnHabitacion.add(jPanel5);

        pnInterfaces.add(pnHabitacion, "pnHabitacion");

        pnReserva.setBackground(new java.awt.Color(255, 255, 255));
        pnReserva.setLayout(new javax.swing.BoxLayout(pnReserva, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane7.setBorder(null);
        jScrollPane7.setMaximumSize(new java.awt.Dimension(370, 32767));
        jScrollPane7.setMinimumSize(new java.awt.Dimension(370, 22));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(370, 100));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(370, 685));
        jPanel6.setPreferredSize(new java.awt.Dimension(370, 607));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(8, 37, 69));
        jLabel10.setText("Reservas");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, 35));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(3, 32, 65));
        jLabel38.setText("Datos personales");
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 290, 20));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(3, 32, 65));
        jLabel39.setText("Fechas");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, 20));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(53, 75, 99));
        jLabel41.setText("DNI");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        txDniClienteReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txDniClienteReserva.setForeground(new java.awt.Color(60, 80, 102));
        jPanel6.add(txDniClienteReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 25));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(53, 75, 99));
        jLabel42.setText("Apellidos");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        txApePaternoCliReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApePaternoCliReserva.setForeground(new java.awt.Color(60, 80, 102));
        jPanel6.add(txApePaternoCliReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 125, 25));

        txApeMaternoCliReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApeMaternoCliReserva.setForeground(new java.awt.Color(60, 80, 102));
        jPanel6.add(txApeMaternoCliReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 220, 125, 25));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(53, 75, 99));
        jLabel43.setText("Nombres");
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 20));

        txNombresCliReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txNombresCliReserva.setForeground(new java.awt.Color(60, 80, 102));
        jPanel6.add(txNombresCliReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 270, 25));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(53, 75, 99));
        jLabel45.setText("Correo Electronico");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 20));

        txCorreoCliReserva.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txCorreoCliReserva.setForeground(new java.awt.Color(60, 80, 102));
        jPanel6.add(txCorreoCliReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 270, 25));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(53, 75, 99));
        jLabel46.setText("Fecha de Salida");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, 25));

        btRegistrarEmpleado1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btRegistrarEmpleado1.setForeground(new java.awt.Color(33, 29, 37));
        btRegistrarEmpleado1.setText("Registrar reserva");
        jPanel6.add(btRegistrarEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 140, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(92, 108, 133));
        jLabel47.setText("Apellido Paterno");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, 20));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(92, 108, 133));
        jLabel48.setText("Apellido Materno");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 200, 120, 20));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(53, 75, 99));
        jLabel49.setText("Ninguna");
        jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 415, 200, 20));

        btElegirEmpresa.setForeground(new java.awt.Color(33, 29, 37));
        btElegirEmpresa.setText("Elegir");
        btElegirEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btElegirEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btElegirEmpresaActionPerformed(evt);
            }
        });
        jPanel6.add(btElegirEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 415, -1, 20));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(3, 32, 65));
        jLabel40.setText("Representacion de empresa");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 20));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(53, 75, 99));
        jLabel50.setText("Fecha de Entrada");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, 25));
        jPanel6.add(dcSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 150, 25));
        jPanel6.add(dcEntradaReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 150, 25));

        jScrollPane7.setViewportView(jPanel6);

        pnReserva.add(jScrollPane7);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel44.setForeground(new java.awt.Color(92, 108, 133));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel44.setText("Buscar");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(60, 80, 102));
        jTextField1.setText("jTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addGap(21, 21, 21)
                        .addComponent(jTextField1)))
                .addGap(30, 30, 30))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pnReserva.add(jPanel7);

        pnInterfaces.add(pnReserva, "pnReserva");

        pnAlojamiento.setBackground(new java.awt.Color(51, 255, 153));

        javax.swing.GroupLayout pnAlojamientoLayout = new javax.swing.GroupLayout(pnAlojamiento);
        pnAlojamiento.setLayout(pnAlojamientoLayout);
        pnAlojamientoLayout.setHorizontalGroup(
            pnAlojamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
        );
        pnAlojamientoLayout.setVerticalGroup(
            pnAlojamientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        pnInterfaces.add(pnAlojamiento, "pnAlojamiento");

        javax.swing.GroupLayout pnServicioLayout = new javax.swing.GroupLayout(pnServicio);
        pnServicio.setLayout(pnServicioLayout);
        pnServicioLayout.setHorizontalGroup(
            pnServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
        );
        pnServicioLayout.setVerticalGroup(
            pnServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        pnInterfaces.add(pnServicio, "pnServicio");

        pnEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        pnEmpleado.setLayout(new javax.swing.BoxLayout(pnEmpleado, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane3.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setComponentPopupMenu(pmEmpleados);
        jPanel4.setPreferredSize(new java.awt.Dimension(370, 607));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(8, 37, 69));
        jLabel2.setText("Empleados");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, 35));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(3, 32, 65));
        jLabel3.setText("Datos personales");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 290, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(3, 32, 65));
        jLabel4.setText("Datos del empleo");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(3, 32, 65));
        jLabel5.setText("Datos de contacto");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 75, 99));
        jLabel6.setText("DNI");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        txDniEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txDniEmpleado.setForeground(new java.awt.Color(60, 80, 102));
        txDniEmpleado.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txDniEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 25));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(53, 75, 99));
        jLabel7.setText("Apellidos");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        txApePaterno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApePaterno.setForeground(new java.awt.Color(60, 80, 102));
        txApePaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txApePaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 125, 25));

        txApeMaterno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txApeMaterno.setForeground(new java.awt.Color(60, 80, 102));
        txApeMaterno.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txApeMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 220, 125, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(53, 75, 99));
        jLabel8.setText("Nombres");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, 20));

        txNombresEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txNombresEmpleado.setForeground(new java.awt.Color(60, 80, 102));
        txNombresEmpleado.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txNombresEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 270, 25));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(53, 75, 99));
        jLabel9.setText("Telefono");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(53, 75, 99));
        jLabel11.setText("Correo Electronico");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, 20));

        txTelefonoEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txTelefonoEmpleado.setForeground(new java.awt.Color(60, 80, 102));
        txTelefonoEmpleado.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txTelefonoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 125, 25));

        txCorreoEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txCorreoEmpleado.setForeground(new java.awt.Color(60, 80, 102));
        txCorreoEmpleado.setSelectionColor(new java.awt.Color(0, 122, 255));
        jPanel4.add(txCorreoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 270, 25));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(53, 75, 99));
        jLabel12.setText("Cargo");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, -1, 20));

        cbCargoEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cbCargoEmpleado.setForeground(new java.awt.Color(60, 80, 102));
        cbCargoEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(cbCargoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 270, 25));

        btRegistrarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btRegistrarEmpleado.setForeground(new java.awt.Color(33, 29, 37));
        btRegistrarEmpleado.setText("jButton1");
        jPanel4.add(btRegistrarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(92, 108, 133));
        jLabel28.setText("Apellido Paterno");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, 20));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(92, 108, 133));
        jLabel37.setText("Apellido Materno");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 200, 120, 20));

        jScrollPane3.setViewportView(jPanel4);

        pnEmpleado.add(jScrollPane3);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(92, 108, 133));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(92, 108, 133));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel13.setText("Buscar");

        txBuscarEmpleadoActivo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txBuscarEmpleadoActivo.setForeground(new java.awt.Color(60, 80, 102));
        txBuscarEmpleadoActivo.setText("jTextField1");
        txBuscarEmpleadoActivo.setSelectionColor(new java.awt.Color(0, 122, 255));

        tbEmpleadosActivos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tbEmpleadosActivos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txBuscarEmpleadoActivo)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txBuscarEmpleadoActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Empleados Activos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txBuscarEmpleadoDespedido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txBuscarEmpleadoDespedido.setForeground(new java.awt.Color(60, 80, 102));
        txBuscarEmpleadoDespedido.setText("jTextField2");

        tbEmpleadosDespedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tbEmpleadosDespedidos);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(92, 108, 133));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/public/imagenes/iconos/ic_buscar.png"))); // NOI18N
        jLabel15.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txBuscarEmpleadoDespedido)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txBuscarEmpleadoDespedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Empleados Despedidos", jPanel2);

        pnEmpleado.add(jTabbedPane1);

        pnInterfaces.add(pnEmpleado, "pnEmpleado");

        javax.swing.GroupLayout pnComprobanteLayout = new javax.swing.GroupLayout(pnComprobante);
        pnComprobante.setLayout(pnComprobanteLayout);
        pnComprobanteLayout.setHorizontalGroup(
            pnComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
        );
        pnComprobanteLayout.setVerticalGroup(
            pnComprobanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        pnInterfaces.add(pnComprobante, "pnComprobante");

        javax.swing.GroupLayout pnClienteLayout = new javax.swing.GroupLayout(pnCliente);
        pnCliente.setLayout(pnClienteLayout);
        pnClienteLayout.setHorizontalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
        );
        pnClienteLayout.setVerticalGroup(
            pnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        pnInterfaces.add(pnCliente, "pnCliente");

        pnConfiguracion.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnConfiguracionLayout = new javax.swing.GroupLayout(pnConfiguracion);
        pnConfiguracion.setLayout(pnConfiguracionLayout);
        pnConfiguracionLayout.setHorizontalGroup(
            pnConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1351, Short.MAX_VALUE)
        );
        pnConfiguracionLayout.setVerticalGroup(
            pnConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        pnInterfaces.add(pnConfiguracion, "pnConfiguracion");

        jScrollPane2.setViewportView(pnInterfaces);

        jSplitPane1.setRightComponent(jScrollPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /******************** Inicio del evento de clicks de los labels ********************************/
    private void lbReservaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbReservaMouseClicked
        cardLayout.show(pnInterfaces, "pnReserva");
    }//GEN-LAST:event_lbReservaMouseClicked
    private void lbHabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHabitacionMouseClicked
        cardLayout.show(pnInterfaces, "pnHabitacion");
    }//GEN-LAST:event_lbHabitacionMouseClicked
    private void lbAlojamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAlojamientoMouseClicked
        cardLayout.show(pnInterfaces, "pnAlojamiento");
    }//GEN-LAST:event_lbAlojamientoMouseClicked
    private void lbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClienteMouseClicked
        cardLayout.show(pnInterfaces, "pnCliente");
    }//GEN-LAST:event_lbClienteMouseClicked
    private void lbServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbServicioMouseClicked
        cardLayout.show(pnInterfaces, "pnServicio");
    }//GEN-LAST:event_lbServicioMouseClicked
    private void lbEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEmpleadoMouseClicked
        cardLayout.show(pnInterfaces, "pnEmpleado");
    }//GEN-LAST:event_lbEmpleadoMouseClicked
    private void lbComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbComprobanteMouseClicked
        cardLayout.show(pnInterfaces, "pnComprobante");
    }//GEN-LAST:event_lbComprobanteMouseClicked
    private void lbConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfiguracionMouseClicked
        //cardLayout.show(pnInterfaces, "pnConfiguracion");
        new Configuraciones(this, true).setVisible(true);
    }//GEN-LAST:event_lbConfiguracionMouseClicked
    private void lbLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoMouseClicked
        cardLayout.show(pnInterfaces, "pnDashboard");
    }//GEN-LAST:event_lbLogoMouseClicked

    private void btElegirEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btElegirEmpresaActionPerformed
        try {
            new EmpresasRegistradas(this, true).setVisible(true);
        } catch (SQLException ex) {
            System.out.println("No se puede abrir la interfaz Empresas");
        }
    }//GEN-LAST:event_btElegirEmpresaActionPerformed
    /******************** Fin del evento de clicks de los labels ********************************/
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Principal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDejarHab;
    private javax.swing.JButton btElegirEmpresa;
    private javax.swing.JButton btRegistrarEmpleado;
    private javax.swing.JButton btRegistrarEmpleado1;
    private javax.swing.JComboBox<String> cbCargoEmpleado;
    private com.toedter.calendar.JDateChooser dcEntradaReserva;
    private com.toedter.calendar.JDateChooser dcSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    public static javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbAlojamiento;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbComprobante;
    private javax.swing.JLabel lbConfiguracion;
    private javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbFechaEntrada;
    private javax.swing.JLabel lbFechaSalida;
    private javax.swing.JLabel lbHabitacion;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbReserva;
    private javax.swing.JLabel lbServicio;
    private javax.swing.JLabel lbVolverCargarHabN2;
    private javax.swing.JLabel lbVolverCargarHabN3;
    private javax.swing.JMenuItem miLimpiarCampos;
    private javax.swing.JMenuItem miVolverCargarHabs;
    private javax.swing.JPopupMenu pmEmpleados;
    private javax.swing.JPopupMenu pmHabitaciones;
    private javax.swing.JPanel pnAdministrador;
    private javax.swing.JPanel pnAlojamiento;
    private javax.swing.JPanel pnCliente;
    private javax.swing.JPanel pnComprobante;
    private javax.swing.JPanel pnConfiguracion;
    private javax.swing.JPanel pnDashboard;
    private javax.swing.JPanel pnEmpleado;
    private javax.swing.JPanel pnHabitacion;
    private javax.swing.JPanel pnInterfaces;
    private javax.swing.JPanel pnNivel2;
    private javax.swing.JPanel pnNivel3;
    private javax.swing.JPanel pnReserva;
    private javax.swing.JPanel pnServicio;
    private javax.swing.JPanel pnSidebar;
    private javax.swing.JSlider sliderFechas;
    private javax.swing.JTable tbEmpleadosActivos;
    private javax.swing.JTable tbEmpleadosDespedidos;
    private javax.swing.JTable tbServicosHab;
    private javax.swing.JTextField txApeMaterno;
    private javax.swing.JTextField txApeMaternoCliReserva;
    private javax.swing.JTextField txApePaterno;
    private javax.swing.JTextField txApePaternoCliReserva;
    private javax.swing.JTextField txBuscarEmpleadoActivo;
    private javax.swing.JTextField txBuscarEmpleadoDespedido;
    private javax.swing.JTextField txCorreoCliReserva;
    private javax.swing.JTextField txCorreoEmpleado;
    private javax.swing.JTextField txDniClienteHab;
    private javax.swing.JTextField txDniClienteReserva;
    private javax.swing.JTextField txDniEmpleado;
    private javax.swing.JTextField txEmpresaClienteHab;
    private javax.swing.JTextField txLugarClienteHab;
    private javax.swing.JTextField txNombreClienteHab;
    private javax.swing.JTextField txNombresCliReserva;
    private javax.swing.JTextField txNombresEmpleado;
    private javax.swing.JTextField txNumHab;
    private javax.swing.JTextField txPrecioHab;
    private javax.swing.JTextField txTelefonoEmpleado;
    private javax.swing.JTextField txTipoHab;
    private javax.swing.JTextField txTotalHab;
    private javax.swing.JTextField txTotalServiciosHab;
    // End of variables declaration//GEN-END:variables
}
