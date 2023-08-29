/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.visual;

import hotel.datos.Cliente;
import hotel.datos.Trabajador;
import hotel.logico.CCliente;
import hotel.logico.CTrabajador;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Efren
 */
public class FInicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form FInicioSesion
     */
    public FInicioSesion() {
        initComponents();
        this.setTitle("Acceso al sistema");
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        botonRecuperar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        combTipo = new javax.swing.JComboBox<>();
        psContrasena = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        botonIngresar.setBackground(new java.awt.Color(204, 204, 204));
        botonIngresar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botonIngresar.setForeground(new java.awt.Color(0, 0, 0));
        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        botonRecuperar.setBackground(new java.awt.Color(204, 204, 204));
        botonRecuperar.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botonRecuperar.setForeground(new java.awt.Color(0, 0, 0));
        botonRecuperar.setText("Recuperar contraseña");
        botonRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRecuperarActionPerformed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(204, 204, 204));
        botonSalir.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(0, 0, 0));
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/salir.png"))); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        combTipo.setBackground(new java.awt.Color(204, 204, 204));
        combTipo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        combTipo.setForeground(new java.awt.Color(0, 0, 0));
        combTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Trabajador" }));

        psContrasena.setBackground(new java.awt.Color(204, 204, 204));
        psContrasena.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(204, 0, 0));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(psContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonIngresar)
                .addGap(50, 50, 50)
                .addComponent(botonRecuperar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalir)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonIngresar)
                    .addComponent(botonRecuperar)
                    .addComponent(botonSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        if (txtUsuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un usuario");
            txtUsuario.requestFocus();
            return;  
        }
        if(psContrasena.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar una contrasena");
            psContrasena.requestFocus();
            return;
        }
        
        try {
            DefaultTableModel modelo;
            if (combTipo.getItemAt(combTipo.getSelectedIndex()).equals("Cliente")){
                CCliente cc = new CCliente();
                Cliente c = new Cliente();
                c.setUsuario(txtUsuario.getText());
                c.setContrasena(psContrasena.getText());
                
                modelo = cc.consulta(c.getUsuario(), c.getContrasena());
                tabla.setModel(modelo);
                if(cc.totalregistros > 0){
                    this.dispose();
                    F f = new F();
                    f.toFront();
                    f.setVisible(true);
                    F.lbIDPersona.setText("ID Cliente: " + tabla.getValueAt(0,0).toString());
                    F.lbNombre.setText("Nombre: " + tabla.getValueAt(0,1).toString());
                    F.lbAP.setText("Apellido Paterno: " + tabla.getValueAt(0,2).toString());
                    F.lbAM.setText("Apellido Materno: " +tabla.getValueAt(0,3).toString());
                    F.lbPuesto.setText("Cliente: " + tabla.getValueAt(0,4).toString());
                    F.menuArchivo.setEnabled(false);
                    F.menuReservaciones.setEnabled(false);
                    F.menuConfiguracion.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Acceso denegado","Acceso al sistema",JOptionPane.ERROR_MESSAGE);
                }
            }else if(combTipo.getItemAt(combTipo.getSelectedIndex()).equals("Trabajador")){
                CTrabajador ct = new CTrabajador();
                Trabajador t = new Trabajador();
                t.setUsuario(txtUsuario.getText());
                t.setContrasena(psContrasena.getText());
                
                modelo = ct.consulta(t.getUsuario(), t.getContrasena());
                tabla.setModel(modelo);
                if(ct.totalregistros > 0){
                    this.dispose();
                    F f = new F();
                    f.toFront();
                    f.setVisible(true);
                    F.lbIDPersona.setText("ID trabajador: " + tabla.getValueAt(0,0).toString());
                    F.lbNombre.setText("Nombre: " + tabla.getValueAt(0,1).toString());
                    F.lbAP.setText("Apellido Paterno: " + tabla.getValueAt(0,2).toString());
                    F.lbAM.setText("Apellido Materno: " +tabla.getValueAt(0,3).toString());
                    F.lbPuesto.setText("Puesto: " + tabla.getValueAt(0,4).toString());
                    if((F.lbPuesto.getText().equals("Puesto: Director")) || (F.lbPuesto.getText().equals("Puesto: Gerente"))){
                       //no ocultar nada  
                    }else if(F.lbPuesto.getText().equals("Puesto: Sub-Gerente")){
                        F.menuArchivo.setEnabled(false);
                    }else if(F.lbPuesto.getText().equals("Puesto: Recepcionista")){
                        F.menuArchivo.setEnabled(false);
                        F.menuConfiguracion.setEnabled(false);
                    }else{
                        F.menuArchivo.setEnabled(false);
                        F.menuReservaciones.setEnabled(false);
                        F.menuConfiguracion.setEnabled(false);
                        F.menuConsultas.setEnabled(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Acceso denegado","Acceso al sistema",JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException e) {
        }
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRecuperarActionPerformed
        if (txtUsuario.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Por favor ingresa el usuario para recuperar la contraseña");
            txtUsuario.requestFocus();
            return;
        }
        FRecuperar fr  = new FRecuperar();
        fr.toFront();
        fr.setVisible(true);
    }//GEN-LAST:event_botonRecuperarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(FInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FInicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresar;
    private javax.swing.JButton botonRecuperar;
    private javax.swing.JButton botonSalir;
    public static javax.swing.JComboBox<String> combTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField psContrasena;
    public static javax.swing.JTable tabla;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}