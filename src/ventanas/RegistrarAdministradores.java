/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Validador;
import clases.Conexion;
import java.awt.Color;
import java.sql.*;
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
public class RegistrarAdministradores extends javax.swing.JFrame {
    
    String user,nombre_usuario;
    /**
     * Creates new form RegistrarAdministradores
     */
    public RegistrarAdministradores() {
        initComponents();
        user = Administrador.nombre_usuario;
        setTitle("Registrar Administrador - Sesión de " + user);
        
        setSize(577,428);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //Evita que se cierre todo el programa cuando esta ventana se cierre
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //Clase ImageIcon que permite asignar una imagen a un jLabel con la ruta en: ("")
        ImageIcon fondo = new ImageIcon("src/images/fondo unexac.jpg");
        //Clase Icon para reescalar la imagen a las coordenadas de la interfaz
        Icon icono_fondo = new ImageIcon(fondo.getImage().getScaledInstance(jLabel_fondo.getWidth(), jLabel_fondo.getHeight(), Image.SCALE_DEFAULT));
        //Se le asigna la imagen de fondo al jLabel_fondo
        jLabel_fondo.setIcon(icono_fondo);
        //Instruccion necesaria para aplicar los cambios
        this.repaint();
    }
    
    @Override
    public Image getIconImage(){
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<>();
        jLabel_footer = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Administradores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(5, 125, 203));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Apellido:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txt_apellido.setBackground(new java.awt.Color(5, 125, 203));
        txt_apellido.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 190, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Correo electrónico:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txt_email.setBackground(new java.awt.Color(5, 125, 203));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 220, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cédula:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        txt_cedula.setBackground(new java.awt.Color(5, 125, 203));
        txt_cedula.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_cedula.setForeground(new java.awt.Color(255, 255, 255));
        txt_cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cedula.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 150, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contraseña:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        txt_password.setBackground(new java.awt.Color(5, 125, 203));
        txt_password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 150, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Estatus:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        cmb_estatus.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmb_estatus.setForeground(new java.awt.Color(255, 255, 255));
        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cmb_estatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 150, -1));

        jLabel_footer.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("Creado por Manuel Torrealba y Stefany Villamizar");
        jLabel_footer.setToolTipText("");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/registro-Icon made by dDara from www.flaticon.com.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 90, 80));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int estatusInt,validacion = 0;
        String nombre,apellido,cedula,password,email,estatusString;
        
        nombre = txt_nombre.getText().trim();
        apellido = txt_apellido.getText().trim();
        cedula = txt_cedula.getText().trim();
        password = txt_password.getText().trim();
        email = txt_email.getText().trim();
        estatusInt = cmb_estatus.getSelectedIndex()+1;
         
        //CONTINUAR AQUI 27/01/2021
        if(nombre.equals("")){
            txt_nombre.setBackground(Color.red);
            validacion++;
        }else {
            Validador validar = new Validador(nombre);
            validar.ValidarNombre();
            if(validar.verificado==true){
                txt_nombre.setBackground(new Color(5,125,203));
                JOptionPane.showMessageDialog(null, "Verificado nombre" );
            }else{
                JOptionPane.showMessageDialog(null, "No");
            }
        }
        
        if(email.equals("")){
            txt_email.setBackground(Color.red);
            validacion++;
        }else {
            Validador validar = new Validador(email);
            validar.ValidarEmail();
            if(validar.verificado==true){
                JOptionPane.showMessageDialog(null, "Verificado email" );
            }else{
                JOptionPane.showMessageDialog(null, "No");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministradores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAdministradores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
