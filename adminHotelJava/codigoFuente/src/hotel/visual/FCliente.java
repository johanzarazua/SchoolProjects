/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.visual;
import hotel.datos.Cliente;
import hotel.datos.Habitacion;
import hotel.logico.CCliente;
import hotel.logico.CHabitacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Efren
 */
public class FCliente extends javax.swing.JInternalFrame implements VentanaRegistros{
    String accion = "guardar";
    /**
     * Creates new form FCliente
     */
    public FCliente() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
    
    /**
     * El metodo ocultar columnas nos permite ocultar en la pantalla las columnas con informacion importnate
     * para el inicio de sesion de una persona.
     */
    void ocultar_columnas(){
        tablaClientes.getColumnModel().getColumn(9).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(9).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(9).setPreferredWidth(0);
        tablaClientes.getColumnModel().getColumn(12).setMaxWidth(0);
        tablaClientes.getColumnModel().getColumn(12).setMinWidth(0);
        tablaClientes.getColumnModel().getColumn(12).setPreferredWidth(0);
    }

    /**
     * El metodo inhabilitar nos permite dejar inactivos los campos para realizar un registro
     * excepto el boton nuevo.
     */
    @Override
    public void inhabilitar() {
        txtIDPersona.setEnabled(false);
        txtNombre.setEnabled(false);
        txtAPaterno.setEnabled(false);
        txtAMaterno.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        combTipo.setEnabled(false);
        combDescuentos.setEnabled(false);
        txtUsuario.setEnabled(false);
        psContrasena.setEnabled(false);
        combEstadoLog.setEnabled(false);
        combPS.setEnabled(false);
        psRS.setEnabled(false);
        botonNuevo.setEnabled(true);
        botonGuardar.setEnabled(false);
        botonCancelar.setEnabled(false);
        botonBuscar.setEnabled(true);
        botonEliminar.setEnabled(false);
        botonSalir.setEnabled(true);
        txtIDPersona.setText("");
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtUsuario.setText("");
        psContrasena.setText("");
        psRS.setText("");
    }

    /**
     * El metodo habilitar nos permite activar los campos para generar un registro.
     */
    @Override
    public void habilitar() {
        txtIDPersona.setEnabled(false);
        txtNombre.setEnabled(true);
        txtAPaterno.setEnabled(true);
        txtAMaterno.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        combTipo.setEnabled(true);
        combDescuentos.setEnabled(true);
        txtUsuario.setEnabled(true);
        psContrasena.setEnabled(true);
        combEstadoLog.setEnabled(true);
        combPS.setEnabled(true);
        psRS.setEnabled(true);
        botonNuevo.setEnabled(true);
        botonGuardar.setEnabled(true);
        botonCancelar.setEnabled(true);
        botonBuscar.setEnabled(true);
        botonEliminar.setEnabled(true);
        botonSalir.setEnabled(true);
        txtIDPersona.setText("");
        txtNombre.setText("");
        txtAPaterno.setText("");
        txtAMaterno.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtUsuario.setText("");
        psContrasena.setText("");
        psRS.setText("");
    }

    /**
     * El metodo mostrar nos permite mostrar en la ventana la consulta
     * que se realiza en la base de datos en forma de tabla.
     * @param email. El parametro email se refiere al emial unico por el cual se filtrara la consulta a la base de datos.
     */
    @Override
    public void mostrar(String email) {
        try {
            //se crea una tabla
            DefaultTableModel modelo;
            /*se crea un objeto de la clase CServicio para poder operar en la tabla servicio.
            de la base de datos*/
            CCliente cc = new CCliente();
            // se almacena la tabla retornada al hacer una consulta en la tabla servicio.
            modelo = cc.consulta(email);
            //se muestra en la ventana la tabla recibida por la consulta.
            tablaClientes.setModel(modelo);
            ocultar_columnas();
            //se obtiene el total de registros existentes en la tabla y se muestra en pantalla
            lbRegistros.setText("Total Registros: " + Integer.toString(cc.totalregistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        lbBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        lbRegistros = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtIDPersona = new javax.swing.JTextField();
        lbPiso = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        combTipo = new javax.swing.JComboBox<>();
        lbTipo = new javax.swing.JLabel();
        lbCamas = new javax.swing.JLabel();
        combDescuentos = new javax.swing.JComboBox<>();
        lbEstado = new javax.swing.JLabel();
        combEstadoLog = new javax.swing.JComboBox<>();
        botonNuevo = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        lbIDHabitacion = new javax.swing.JLabel();
        txtAPaterno = new javax.swing.JTextField();
        lbPiso1 = new javax.swing.JLabel();
        txtAMaterno = new javax.swing.JTextField();
        lbPiso2 = new javax.swing.JLabel();
        lbPiso3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbTipo1 = new javax.swing.JLabel();
        lbTipo2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbEstado1 = new javax.swing.JLabel();
        lbEstado2 = new javax.swing.JLabel();
        combPS = new javax.swing.JComboBox<>();
        psContrasena = new javax.swing.JPasswordField();
        psRS = new javax.swing.JPasswordField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Clientes");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(50, 0, 0, 0, new java.awt.Color(102, 0, 0)), "Listado de clientes", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(102, 0, 0))); // NOI18N

        tablaClientes.setBackground(new java.awt.Color(204, 204, 204));
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClientes);

        lbBuscar.setBackground(new java.awt.Color(204, 204, 204));
        lbBuscar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbBuscar.setForeground(new java.awt.Color(0, 0, 0));
        lbBuscar.setText("Buscar por email:");
        lbBuscar.setToolTipText("Buscar");

        txtBuscar.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        botonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        botonBuscar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(0, 0, 0));
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/buscar.png"))); // NOI18N
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(204, 204, 204));
        botonEliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/eliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(204, 204, 204));
        botonSalir.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(0, 0, 0));
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        lbRegistros.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbRegistros.setForeground(new java.awt.Color(0, 0, 0));
        lbRegistros.setText("Registros: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalir)
                        .addGap(12, 12, 12))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbRegistros)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(botonEliminar)
                    .addComponent(botonSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRegistros)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(50, 0, 0, 0, new java.awt.Color(102, 0, 0)), "Registro de cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(102, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtIDPersona.setBackground(new java.awt.Color(204, 204, 204));
        txtIDPersona.setForeground(new java.awt.Color(0, 0, 0));
        txtIDPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPersonaActionPerformed(evt);
            }
        });

        lbPiso.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbPiso.setForeground(new java.awt.Color(0, 0, 0));
        lbPiso.setText("A. Paterno:");

        lbNumero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbNumero.setForeground(new java.awt.Color(0, 0, 0));
        lbNumero.setText("Nombre:");

        combTipo.setBackground(new java.awt.Color(204, 204, 204));
        combTipo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combTipo.setForeground(new java.awt.Color(0, 0, 0));
        combTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ocasional", "Habitual", "VIP" }));
        combTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combTipoActionPerformed(evt);
            }
        });

        lbTipo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbTipo.setForeground(new java.awt.Color(0, 0, 0));
        lbTipo.setText("Tipo:");

        lbCamas.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbCamas.setForeground(new java.awt.Color(0, 0, 0));
        lbCamas.setText("Porcentaje de descuento:");

        combDescuentos.setBackground(new java.awt.Color(204, 204, 204));
        combDescuentos.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combDescuentos.setForeground(new java.awt.Color(0, 0, 0));
        combDescuentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "15", " " }));
        combDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combDescuentosActionPerformed(evt);
            }
        });

        lbEstado.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbEstado.setForeground(new java.awt.Color(0, 0, 0));
        lbEstado.setText("Estado Loggeo:");

        combEstadoLog.setBackground(new java.awt.Color(204, 204, 204));
        combEstadoLog.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combEstadoLog.setForeground(new java.awt.Color(0, 0, 0));
        combEstadoLog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactiva", "Activa", " " }));
        combEstadoLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combEstadoLogActionPerformed(evt);
            }
        });

        botonNuevo.setBackground(new java.awt.Color(204, 204, 204));
        botonNuevo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonNuevo.setForeground(new java.awt.Color(0, 0, 0));
        botonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/nuevo.png"))); // NOI18N
        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoActionPerformed(evt);
            }
        });

        botonGuardar.setBackground(new java.awt.Color(204, 204, 204));
        botonGuardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/guardar.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCancelar.setBackground(new java.awt.Color(204, 204, 204));
        botonCancelar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        botonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/cancelar.png"))); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        lbIDHabitacion.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbIDHabitacion.setForeground(new java.awt.Color(0, 0, 0));
        lbIDHabitacion.setText("ID :");

        txtAPaterno.setBackground(new java.awt.Color(204, 204, 204));
        txtAPaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtAPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPaternoActionPerformed(evt);
            }
        });

        lbPiso1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbPiso1.setForeground(new java.awt.Color(0, 0, 0));
        lbPiso1.setText("A. Materno:");

        txtAMaterno.setBackground(new java.awt.Color(204, 204, 204));
        txtAMaterno.setForeground(new java.awt.Color(0, 0, 0));
        txtAMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAMaternoActionPerformed(evt);
            }
        });

        lbPiso2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbPiso2.setForeground(new java.awt.Color(0, 0, 0));
        lbPiso2.setText("Telefono:");

        lbPiso3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbPiso3.setForeground(new java.awt.Color(0, 0, 0));
        lbPiso3.setText("Email:");

        txtTelefono.setBackground(new java.awt.Color(204, 204, 204));
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lbTipo1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbTipo1.setForeground(new java.awt.Color(0, 0, 0));
        lbTipo1.setText("Usuario:");

        lbTipo2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbTipo2.setForeground(new java.awt.Color(0, 0, 0));
        lbTipo2.setText("Contraseña:");

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lbEstado1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbEstado1.setForeground(new java.awt.Color(0, 0, 0));
        lbEstado1.setText("Pregunta de seguridad:");

        lbEstado2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbEstado2.setForeground(new java.awt.Color(0, 0, 0));
        lbEstado2.setText("Respuesta de seguridad:");

        combPS.setBackground(new java.awt.Color(204, 204, 204));
        combPS.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        combPS.setForeground(new java.awt.Color(0, 0, 0));
        combPS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Cual fue el nombre de tu primer mascota?", "¿Cual es tu comida favorita?", "¿Cual es el nombre de tu madre?", "¿Cual es el apodo de tu mejor amigo?", "¿Cual es tu deporte favorito?", "¿Cual es tu equipo deportivo favorito?" }));
        combPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combPSActionPerformed(evt);
            }
        });

        psContrasena.setBackground(new java.awt.Color(204, 204, 204));
        psContrasena.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        psContrasena.setForeground(new java.awt.Color(0, 0, 0));
        psContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psContrasenaActionPerformed(evt);
            }
        });

        psRS.setBackground(new java.awt.Color(204, 204, 204));
        psRS.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        psRS.setForeground(new java.awt.Color(0, 0, 0));
        psRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psRSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbEstado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combPS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combEstadoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbIDHabitacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbPiso3)
                                    .addComponent(lbPiso1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAMaterno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCamas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPiso)
                                    .addComponent(lbNumero))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTipo1)
                                    .addComponent(lbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(psContrasena))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEstado2)
                            .addComponent(botonNuevo))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCancelar))
                            .addComponent(psRS))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIDHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPiso3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCamas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combEstadoLog, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combPS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonGuardar)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(975, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        botonGuardar.setText("Editar");
        habilitar();
        botonEliminar.setEnabled(true);
        accion = "editar";
        txtUsuario.setEnabled(false);
        combEstadoLog.setEnabled(false);
        combPS.setEnabled(false);
        psRS.setEnabled(false);
        int fila = tablaClientes.rowAtPoint(evt.getPoint());
        txtIDPersona.setText(tablaClientes.getValueAt(fila, 0).toString());
        txtNombre.setText(tablaClientes.getValueAt(fila, 1).toString());
        txtAPaterno.setText(tablaClientes.getValueAt(fila, 2).toString());
        txtAMaterno.setText(tablaClientes.getValueAt(fila, 3).toString());
        txtTelefono.setText(tablaClientes.getValueAt(fila, 4).toString());
        txtEmail.setText(tablaClientes.getValueAt(fila, 5).toString());
        combTipo.setSelectedItem(tablaClientes.getValueAt(fila,6).toString());
        combDescuentos.setSelectedItem(tablaClientes.getValueAt(fila, 7).toString());
        txtUsuario.setText(tablaClientes.getValueAt(fila, 8).toString());
        psContrasena.setText(tablaClientes.getValueAt(fila,9).toString());
        combEstadoLog.setSelectedItem(tablaClientes.getValueAt(fila, 10));
        combPS.setSelectedItem(tablaClientes.getValueAt(fila, 11));
        psRS.setText(tablaClientes.getValueAt(fila, 12).toString());
        
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        mostrar(txtBuscar.getText());
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(!txtIDPersona.getText().equals("")){
            int decision = JOptionPane.showConfirmDialog(rootPane, "Deseas eliminra el cliente?","Confirmar",2);
            if(decision == 0){
                CCliente cc = new CCliente();
                Cliente c = new Cliente();
                c.setIdpersona(Integer.parseInt(txtIDPersona.getText()));
                cc.eliminar(c);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtNombre.transferFocus();
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIDPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPersonaActionPerformed

    private void combTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combTipoActionPerformed
        combTipo.transferFocus();
    }//GEN-LAST:event_combTipoActionPerformed

    private void combEstadoLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combEstadoLogActionPerformed
        combEstadoLog.transferFocus();
    }//GEN-LAST:event_combEstadoLogActionPerformed

    private void botonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoActionPerformed
        habilitar();
        botonGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_botonNuevoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        //validamos que todos los campos de texto tengan un valor
        if(txtNombre.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el nombre del cliente");
            txtNombre.requestFocus();
            return;
        }
        if (txtAPaterno.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el apellido paterno del cliente");
            txtAPaterno.requestFocus();
            return;
        }
        if (txtAMaterno.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el apellido materno del cliente");
            txtAMaterno.requestFocus();
            return;
        }
        if (txtTelefono.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el telefono del cliente");
            txtTelefono.requestFocus();
            return;
        }else if(txtTelefono.getText().length() < 9){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un telefono con almenos 10 digitos");
            txtTelefono.requestFocus();
            return;
        }
        if (txtEmail.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el email del cliente");
            txtEmail.requestFocus();
            return;
        }
        if (txtUsuario.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un usuario");
            txtUsuario.requestFocus();
            return;
        }
        if (psContrasena.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una contrasena");
            psContrasena.requestFocus();
            return;
        }else if(psContrasena.getText().length() < 7){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una contrasena con almenos 8 caracteres");
            psContrasena.requestFocus();
            return;
        }
        if (psRS.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una respuesta a la pregunta de seguridad");
            psRS.requestFocus();
            return;
        }
        
        Cliente c = new Cliente();
        CCliente cc = new CCliente();
        
        c.setNombre(txtNombre.getText());
        c.setaPaterno(txtAPaterno.getText());
        c.setaMaterno(txtAMaterno.getText());
        c.setTelefono(txtTelefono.getText());
        c.setEmail(txtEmail.getText());
        c.setTipo(combTipo.getItemAt(combTipo.getSelectedIndex()));
        c.setDescuento(Integer.parseInt(combDescuentos.getItemAt(combDescuentos.getSelectedIndex())));
        c.setUsuario(txtUsuario.getText());
        c.setContrasena(psContrasena.getText());
        c.setEstado_log(combEstadoLog.getItemAt(combEstadoLog.getSelectedIndex()));
        c.setPreguntaSeguridad(combPS.getItemAt(combPS.getSelectedIndex()));
        c.setRespuestaSeguridad(psRS.getText());
        
         if (accion.equals("guardar")){
            if (cc.insertar(c)){
                JOptionPane.showMessageDialog(rootPane, "El cliente se registro correctamente");
                mostrar("");
                inhabilitar();
            }  
        }else if (accion.equals("editar")){
            c.setIdpersona(Integer.parseInt(txtIDPersona.getText()));
            if (cc.editar(c)){
                JOptionPane.showMessageDialog(rootPane, "El cliente se edito correctamente");
                mostrar("");
                inhabilitar();
            }
        }
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        habilitar();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void combDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combDescuentosActionPerformed
        combDescuentos.transferFocus();
    }//GEN-LAST:event_combDescuentosActionPerformed

    private void txtAPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPaternoActionPerformed
        txtAPaterno.transferFocus();
    }//GEN-LAST:event_txtAPaternoActionPerformed

    private void txtAMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAMaternoActionPerformed
        txtAMaterno.transferFocus();
    }//GEN-LAST:event_txtAMaternoActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        txtTelefono.transferFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        txtEmail.transferFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtUsuario.transferFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void combPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combPSActionPerformed
        combPS.transferFocus();
    }//GEN-LAST:event_combPSActionPerformed

    private void psContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psContrasenaActionPerformed

    private void psRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psRSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psRSActionPerformed

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
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<String> combDescuentos;
    private javax.swing.JComboBox<String> combEstadoLog;
    private javax.swing.JComboBox<String> combPS;
    private javax.swing.JComboBox<String> combTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbCamas;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbEstado1;
    private javax.swing.JLabel lbEstado2;
    private javax.swing.JLabel lbIDHabitacion;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPiso;
    private javax.swing.JLabel lbPiso1;
    private javax.swing.JLabel lbPiso2;
    private javax.swing.JLabel lbPiso3;
    private javax.swing.JLabel lbRegistros;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JLabel lbTipo1;
    private javax.swing.JLabel lbTipo2;
    private javax.swing.JPasswordField psContrasena;
    private javax.swing.JPasswordField psRS;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDPersona;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
