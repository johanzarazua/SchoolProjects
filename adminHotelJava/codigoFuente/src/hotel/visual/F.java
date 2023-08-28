/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel.visual;

/**
 *
 * @author Efren
 */
public class F extends javax.swing.JFrame {

    /** Creates new form F */
    public F() {
        initComponents();
        this.setExtendedState(F.MAXIMIZED_BOTH);
        this.setTitle("Hotel-in");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JDesktopPane();
        lbPuesto = new javax.swing.JLabel();
        lbIDPersona = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbAP = new javax.swing.JLabel();
        lbAM = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuSR = new javax.swing.JMenu();
        menuArchivo = new javax.swing.JMenu();
        mnHabitacion = new javax.swing.JMenuItem();
        mnServicios = new javax.swing.JMenuItem();
        menuReservaciones = new javax.swing.JMenu();
        mnRYC = new javax.swing.JMenuItem();
        mnClientes = new javax.swing.JMenuItem();
        mnPagos = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        mnTYA = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principal.setBackground(new java.awt.Color(255, 255, 255));

        lbPuesto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbPuesto.setForeground(new java.awt.Color(0, 0, 0));
        lbPuesto.setText("jLabel1");
        principal.add(lbPuesto);
        lbPuesto.setBounds(20, 180, 440, 16);

        lbIDPersona.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbIDPersona.setForeground(new java.awt.Color(0, 0, 0));
        lbIDPersona.setText("jLabel1");
        principal.add(lbIDPersona);
        lbIDPersona.setBounds(20, 20, 410, 16);

        lbNombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbNombre.setText("jLabel1");
        principal.add(lbNombre);
        lbNombre.setBounds(20, 60, 440, 16);

        lbAP.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbAP.setForeground(new java.awt.Color(0, 0, 0));
        lbAP.setText("jLabel1");
        principal.add(lbAP);
        lbAP.setBounds(20, 100, 430, 16);

        lbAM.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lbAM.setForeground(new java.awt.Color(0, 0, 0));
        lbAM.setText("jLabel1");
        principal.add(lbAM);
        lbAM.setBounds(20, 140, 420, 16);

        menuSR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/boton-home-1.png"))); // NOI18N
        menuSR.setMnemonic('f');
        menuSR.setText("Sistema Reservaciones");
        menuBar.add(menuSR);

        menuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/atras.png"))); // NOI18N
        menuArchivo.setMnemonic('e');
        menuArchivo.setText("Archivos");

        mnHabitacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mnHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/habitacion.png"))); // NOI18N
        mnHabitacion.setMnemonic('t');
        mnHabitacion.setText("Habitaciones");
        mnHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnHabitacionActionPerformed(evt);
            }
        });
        menuArchivo.add(mnHabitacion);

        mnServicios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/servicio.png"))); // NOI18N
        mnServicios.setMnemonic('y');
        mnServicios.setText("Servicios");
        mnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnServiciosActionPerformed(evt);
            }
        });
        menuArchivo.add(mnServicios);

        menuBar.add(menuArchivo);

        menuReservaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/reservation.png"))); // NOI18N
        menuReservaciones.setMnemonic('h');
        menuReservaciones.setText("Reservaciones");

        mnRYC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnRYC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/compra.png"))); // NOI18N
        mnRYC.setMnemonic('c');
        mnRYC.setText("Reservaciones y compras");
        mnRYC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRYCActionPerformed(evt);
            }
        });
        menuReservaciones.add(mnRYC);

        mnClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/clients.png"))); // NOI18N
        mnClientes.setMnemonic('a');
        mnClientes.setText("Clientes");
        mnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnClientesActionPerformed(evt);
            }
        });
        menuReservaciones.add(mnClientes);

        mnPagos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/pago.jpg"))); // NOI18N
        mnPagos.setText("Pagos");
        mnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPagosActionPerformed(evt);
            }
        });
        menuReservaciones.add(mnPagos);

        menuBar.add(menuReservaciones);

        menuConsultas.setText("Consultas");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Reservaciones cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuItem1);

        menuBar.add(menuConsultas);

        menuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/settings.png"))); // NOI18N
        menuConfiguracion.setText("Configuracion");

        mnTYA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mnTYA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/trabajo.png"))); // NOI18N
        mnTYA.setText("Trabajadores y accesos");
        mnTYA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTYAActionPerformed(evt);
            }
        });
        menuConfiguracion.add(mnTYA);

        menuBar.add(menuConfiguracion);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/files/salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnHabitacionActionPerformed
        FHabitacion fh = new FHabitacion();
        principal.add(fh);
        fh.toFront();
        fh.setVisible(true);
    }//GEN-LAST:event_mnHabitacionActionPerformed

    private void mnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnServiciosActionPerformed
        FServicio fs = new FServicio();
        principal.add(fs);
        fs.toFront();
        fs.setVisible(true);
    }//GEN-LAST:event_mnServiciosActionPerformed

    private void mnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnClientesActionPerformed
        FCliente fc = new FCliente();
        principal.add(fc);
        fc.toFront();
        fc.setVisible(true);
    }//GEN-LAST:event_mnClientesActionPerformed

    private void mnTYAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTYAActionPerformed
        FTrabajador ft = new FTrabajador();
        principal.add(ft);
        ft.toFront();
        ft.setVisible(true);
    }//GEN-LAST:event_mnTYAActionPerformed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_menuSalirMouseClicked

    private void mnRYCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRYCActionPerformed
        FReservacion fr = new FReservacion();
        principal.add(fr);
        fr.toFront();
        fr.setVisible(true);
        FReservacion.txtIDTrabajador.setText(lbIDPersona.getText().substring(15));
        FReservacion.txtNTrabajador.setText(lbNombre.getText().substring(8) + " " + lbAP.getText().substring(18));
        FReservacion.idtrabajador = Integer.parseInt(lbIDPersona.getText().substring(15));
    }//GEN-LAST:event_mnRYCActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FRComprobante frc = new FRComprobante();
        principal.add(frc);
        frc.toFront();
        frc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPagosActionPerformed
        FTPago ftp = new FTPago();
        principal.add(ftp);
        ftp.toFront();
        ftp.setVisible(true);
    }//GEN-LAST:event_mnPagosActionPerformed

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
            java.util.logging.Logger.getLogger(F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JLabel lbAM;
    public static javax.swing.JLabel lbAP;
    public static javax.swing.JLabel lbIDPersona;
    public static javax.swing.JLabel lbNombre;
    public static javax.swing.JLabel lbPuesto;
    public static javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuConfiguracion;
    public static javax.swing.JMenu menuConsultas;
    public static javax.swing.JMenu menuReservaciones;
    private javax.swing.JMenu menuSR;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem mnClientes;
    private javax.swing.JMenuItem mnHabitacion;
    private javax.swing.JMenuItem mnPagos;
    private javax.swing.JMenuItem mnRYC;
    private javax.swing.JMenuItem mnServicios;
    private javax.swing.JMenuItem mnTYA;
    public static javax.swing.JDesktopPane principal;
    // End of variables declaration//GEN-END:variables

}
