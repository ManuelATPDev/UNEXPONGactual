/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Manuel
 */
public class Administrador extends javax.swing.JFrame {

    String user;
    String[] user2;
    public static int sesion_usuario;
    public static String nombre_usuario = "";

    /**
     * Creates new form Administrador
     */
    public Administrador() {
        initComponents();
        user = Login.user;
        //variable bandera
        sesion_usuario = 1;

        setSize(650, 500);
        setResizable(false);
        setLocationRelativeTo(null);

        //Cierra los procesos en segundo plano
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Clase ImageIcon que permite asignar una imagen a un jLabel con la ruta en: ("")
        ImageIcon fondo = new ImageIcon("src/images/fondo unexac.jpg");
        //Clase Icon para reescalar la imagen a las coordenadas de la interfaz
        Icon icono_fondo = new ImageIcon(fondo.getImage().getScaledInstance(jLabel_fondo.getWidth(), jLabel_fondo.getHeight(), Image.SCALE_DEFAULT));
        //Se le asigna la imagen de fondo al jLabel_fondo
        jLabel_fondo.setIcon(icono_fondo);
        //Instruccion necesaria para aplicar los cambios
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre from administradores where email = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre_usuario = rs.getString("nombre");
                user2 = nombre_usuario.split(" ");
                setTitle("Administrador - Sesión de " + user2[0]);
                jLabel_NombreUsuario.setText("Bienvenido " + user2[0]);
            } else {

            }
        } catch (SQLException e) {
            System.err.println("Error en conexión desde la interfaz Administrador");
        }

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/iconounex.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_NombreUsuario = new javax.swing.JLabel();
        jButton_RegistrarAdministrador = new javax.swing.JButton();
        jButton_RegistrarAlumno = new javax.swing.JButton();
        jButton_Materias = new javax.swing.JButton();
        jButton_GestionarAdministradores = new javax.swing.JButton();
        jButton_GestionarAlumnos = new javax.swing.JButton();
        jButton_ImprimirReporte = new javax.swing.JButton();
        jButton_AcercaDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_RegistrarAdministrador.setBackground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addAdministrador-Icon made by Eucalyp from www.flaticon.com.png"))); // NOI18N
        jButton_RegistrarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 140, 140));

        jButton_RegistrarAlumno.setBackground(new java.awt.Color(255, 255, 255));
        jButton_RegistrarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addAlumnos.png"))); // NOI18N
        getContentPane().add(jButton_RegistrarAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 140, 140));

        jButton_Materias.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/materias.png"))); // NOI18N
        getContentPane().add(jButton_Materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 140, 140));

        jButton_GestionarAdministradores.setBackground(new java.awt.Color(255, 255, 255));
        jButton_GestionarAdministradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionaradmin.png"))); // NOI18N
        jButton_GestionarAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestionarAdministradoresActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestionarAdministradores, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 140, 140));

        jButton_GestionarAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        jButton_GestionarAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestionAlumnos-Icon made by flat Icons from www.flaticon.com.png"))); // NOI18N
        getContentPane().add(jButton_GestionarAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 140, 140));

        jButton_ImprimirReporte.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ImprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imprimirreporte.png"))); // NOI18N
        getContentPane().add(jButton_ImprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 140, 140));

        jButton_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/acercade.png"))); // NOI18N
        jButton_AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AcercaDeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 40, 40));
        jButton_AcercaDe.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registrar Administrador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 210, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gestionar Administradores");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 400, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Registrar Alumno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gestionar Alumnos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 400, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Imprimir constancia (PDF)");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 400, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Materias");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 210, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Creado por Manuel Torrealba y Stefany Villamizar");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, -1, -1));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AcercaDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_AcercaDeActionPerformed

    private void jButton_RegistrarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarAdministradorActionPerformed
        RegistrarAdministradores registraradmin = new RegistrarAdministradores();
        registraradmin.setVisible(true);
    }//GEN-LAST:event_jButton_RegistrarAdministradorActionPerformed

    private void jButton_GestionarAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestionarAdministradoresActionPerformed
        GestionarAdministradores gestionaradmin = new GestionarAdministradores();
        gestionaradmin.setVisible(true);
    }//GEN-LAST:event_jButton_GestionarAdministradoresActionPerformed

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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AcercaDe;
    private javax.swing.JButton jButton_GestionarAdministradores;
    private javax.swing.JButton jButton_GestionarAlumnos;
    private javax.swing.JButton jButton_ImprimirReporte;
    private javax.swing.JButton jButton_Materias;
    private javax.swing.JButton jButton_RegistrarAdministrador;
    private javax.swing.JButton jButton_RegistrarAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_NombreUsuario;
    private javax.swing.JLabel jLabel_fondo;
    // End of variables declaration//GEN-END:variables
}
