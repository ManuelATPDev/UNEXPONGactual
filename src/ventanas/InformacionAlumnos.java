/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Validador;
import clases.TablaMaterias;
import clases.Render;
import clases.EncriptarPassword;
import clases.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarAdministradores.ID_update;
import static ventanas.GestionarAdministradores.user_update;

/**
 *
 * @author Manuel
 */
public class InformacionAlumnos extends javax.swing.JFrame {

    public static String materia_codigo = "", materia_nombre = "", materia_seccion = "", materias;
    String user, user_update;
    int ID_update, actualizar_pestaña2;
    String[] user2, user3, materia2, materia;
    DefaultTableModel model = new DefaultTableModel() {  //Acceso a los métodos necesarios para modificar una tabla
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form RegistrarAdministradores
     */
    public InformacionAlumnos() {
        initComponents();
        user = Administrador.nombre_usuario;
        user2 = user.split(" ");
        user_update = GestionarAlumnos.user_update;
        user3 = user_update.split(" ");
        ID_update = GestionarAlumnos.ID_update;

        setTitle("Información del alumno(a): " + user3[0] + " - Sesión de " + user2[0]);
        jLabel_Titulo.setText("Información del alumno(a): " + user3[0]);

        setSize(690, 720);
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
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombres, apellidos, cedula, expediente, especialidad, email, materias_inscritas, estatus, registrado_por from alumnos where id = " + ID_update);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                materias = rs.getString("materias_inscritas");
                materia = rs.getString("materias_inscritas").split("-");

                Tabla(jTable_materias);
                txt_nombre.setText(rs.getString("nombres"));
                txt_apellido.setText(rs.getString("apellidos"));
                txt_email.setText(rs.getString("email"));
                txt_cedula.setText(rs.getString("cedula"));
                txt_expediente.setText(rs.getString("expediente"));
                switch (rs.getString("especialidad")) {
                    case "Mecatronica":
                        cmb_especialidad.setSelectedIndex(0);
                        break;
                    case "Sistemas":
                        cmb_especialidad.setSelectedIndex(1);
                        break;
                    case "Mecanica":
                        cmb_especialidad.setSelectedIndex(2);
                        break;
                    case "TSU Mecanica":
                        cmb_especialidad.setSelectedIndex(3);
                        break;
                    case "Industrial":
                        cmb_especialidad.setSelectedIndex(4);
                        break;
                }
                if (rs.getString("estatus").equals("Activo")) {
                    cmb_estatus.setSelectedIndex(0);
                } else {
                    cmb_estatus.setSelectedIndex(1);
                }
                txt_registrado_por.setText(rs.getString("registrado_por"));

            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error al consultar el alumno. Contacte con un administrador " + e);
            JOptionPane.showMessageDialog(null, "Ha acurrido un error al consultar");
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

        jLabel_Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_expediente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmb_especialidad = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_registrado_por = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_materias = new javax.swing.JTable();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_materias = new javax.swing.JButton();
        jButton_Password = new javax.swing.JButton();
        jButton_imprimir = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Titulo.setText("Información del alumno: ");
        getContentPane().add(jLabel_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Materias Inscritas:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(5, 125, 203));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 190, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Apellidos:");
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
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        txt_email.setBackground(new java.awt.Color(5, 125, 203));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 220, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cédula:");
        jLabel5.setToolTipText("");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        txt_cedula.setBackground(new java.awt.Color(5, 125, 203));
        txt_cedula.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_cedula.setForeground(new java.awt.Color(255, 255, 255));
        txt_cedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_cedula.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 190, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Expediente:");
        jLabel8.setToolTipText("");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        txt_expediente.setBackground(new java.awt.Color(5, 125, 203));
        txt_expediente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_expediente.setForeground(new java.awt.Color(255, 255, 255));
        txt_expediente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_expediente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_expediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 190, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Estatus:");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        cmb_estatus.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmb_estatus.setForeground(new java.awt.Color(255, 255, 255));
        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cmb_estatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 150, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registrado por:");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        cmb_especialidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmb_especialidad.setForeground(new java.awt.Color(255, 255, 255));
        cmb_especialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mecatronica", "Sistemas", "Mecanica", "Tsu Mecanica", "Industrial" }));
        cmb_especialidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmb_especialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_especialidadActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 150, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Especialidad:");
        jLabel9.setToolTipText("");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        txt_registrado_por.setEditable(false);
        txt_registrado_por.setBackground(new java.awt.Color(5, 125, 203));
        txt_registrado_por.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_registrado_por.setForeground(new java.awt.Color(255, 255, 255));
        txt_registrado_por.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registrado_por.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_registrado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 170, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Nombres:");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jTable_materias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_materias.setRowHeight(30);
        jTable_materias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_materiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_materias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 430, 190));

        jButton_Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizaradministradores-Icon made by Freepik Icons from www.flaticon.com.png"))); // NOI18N
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 90, 80));

        jButton_materias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/materias2.png"))); // NOI18N
        jButton_materias.setBorder(null);
        jButton_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_materiasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 90, 80));

        jButton_Password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizarcontraseña-Icon made by Freepik Icons from www.flaticon.com.png"))); // NOI18N
        jButton_Password.setBorder(null);
        jButton_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 90, 80));

        jButton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora-Icon made by Freepik Icons from www.flaticon.com.png"))); // NOI18N
        jButton_imprimir.setBorder(null);
        getContentPane().add(jButton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 130, 120));

        jLabel_footer.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_footer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_footer.setText("Creado por Manuel Torrealba y Stefany Villamizar");
        jLabel_footer.setToolTipText("");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 670, -1, -1));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed
        int estatusInt, especialidadInt;
        int validacion = 0;
        String nombre, apellido, cedula, expediente, email, estatusString = "", especialidadString = "";

        nombre = txt_nombre.getText().trim();
        apellido = txt_apellido.getText().trim();
        cedula = txt_cedula.getText().trim();
        expediente = txt_expediente.getText().trim();
        email = txt_email.getText().trim();
        estatusInt = cmb_estatus.getSelectedIndex() + 1;
        especialidadInt = cmb_especialidad.getSelectedIndex() + 1;

        //Validacion NOMBRE
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        } else {
            Validador validar = new Validador(nombre);
            validar.ValidarNombre();
            if (validar.verificado == true) {
                txt_nombre.setBackground(new Color(5, 125, 203));
            } else {
                validacion++;
                JOptionPane.showMessageDialog(null, "No");
            }
        }

        //Validacion APELLIDO
        if (apellido.equals("")) {
            txt_apellido.setBackground(Color.red);
            validacion++;
        } else {
            Validador validar = new Validador(apellido);
            validar.ValidarNombre();
            if (validar.verificado == true) {
                txt_apellido.setBackground(new Color(5, 125, 203));
            } else {
                validacion++;
                JOptionPane.showMessageDialog(null, "No");
            }
        }

        //Validacion EMAIL
        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        } else if (email.contains(" ")) {
            txt_email.setBackground(Color.red);
            validacion++;
        } else {
            Validador validar = new Validador(email);
            validar.ValidarEmail();
            if (validar.verificado == true) {
                txt_email.setBackground(new Color(5, 125, 203));
            } else {
                validacion++;
                JOptionPane.showMessageDialog(null, "No");
            }
        }

        //Validacion CEDULA
        if (cedula.equals("")) {
            txt_cedula.setBackground(Color.red);
            validacion++;
        } else if (cedula.contains(" ")) {
            txt_cedula.setBackground(Color.red);
            validacion++;
        } else {
            Validador validar = new Validador(cedula);
            validar.ValidarCedula();
            if (validar.verificado == true) {
                txt_cedula.setBackground(new Color(5, 125, 203));
            } else {
                validacion++;
                JOptionPane.showMessageDialog(null, "No");
            }
        }

        //Validación EXPEDIENTE
        if (expediente.equals("")) {
            txt_expediente.setBackground(Color.red);
            validacion++;
        } else if (expediente.contains(" ")) {
            txt_expediente.setBackground(Color.red);
            validacion++;
        } else {
            Validador validar = new Validador(expediente);
            validar.ValidarExpediente();
            if (validar.verificado == true) {
                txt_expediente.setBackground(new Color(5, 125, 203));
            } else {
                validacion++;
                JOptionPane.showMessageDialog(null, "Debe ingresar un expediente valido");
            }
        }

        //Validacion ESTATUS
        if (estatusInt == 1) {
            estatusString = "Activo";
        } else if (estatusInt == 2) {
            estatusString = "Inactivo";
        }

        //Validacion Especialidad
        switch (especialidadInt) {
            case 1:
                especialidadString = "Mecatronica";
                break;
            case 2:
                especialidadString = "Sistemas";
                break;
            case 3:
                especialidadString = "Mecanica";
                break;
            case 4:
                especialidadString = "TSU Mecanica";
                break;
            case 5:
                especialidadString = "Industrial";
                break;
        }

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select cedula from alumnos where cedula = '" + cedula + "' and not id = " + ID_update);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_cedula.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "El número de cedula ya pertenece a un alumno");
                cn.close();
            } else {
                cn.close();

                if (validacion == 0) {
                    try {

                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "update alumnos set nombres=?, apellidos=?, cedula=?, expediente=?, especialidad=?, email=?, estatus=? where id = " + ID_update);
                        pst2.setInt(1, 0); //Columna ID
                        pst2.setString(1, nombre);
                        pst2.setString(2, apellido);
                        pst2.setString(3, cedula);
                        pst2.setString(4, expediente);
                        pst2.setString(5, especialidadString);
                        pst2.setString(6, email);
                        pst2.setString(7, estatusString);

                        pst2.executeUpdate();
                        cn2.close();

                        Limpiar();
                        Verificado();

                        JOptionPane.showMessageDialog(null, "La actualización del alumno(a) fue realizada correctamente");
                        this.dispose(); //Sirve para liberar recursos cerrando la pestaña de vista

                    } catch (Exception e) {
                        System.err.println("Error al actualizar alumno " + e);
                        JOptionPane.showMessageDialog(null, "!ERROR al actualizar alumno!, contacte con un administrador.!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar la cedula del alumno" + e);
            JOptionPane.showMessageDialog(null, "Error al comparar cédula, por favor contacte con un administrador");
        }
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_materiasActionPerformed

    }//GEN-LAST:event_jButton_materiasActionPerformed

    private void jButton_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PasswordActionPerformed
        ModificarPassword modificarpassword = new ModificarPassword();
        modificarpassword.setVisible(true);
    }//GEN-LAST:event_jButton_PasswordActionPerformed

    private void cmb_especialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_especialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_especialidadActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void jTable_materiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_materiasMouseClicked

    }//GEN-LAST:event_jTable_materiasMouseClicked

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
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_especialidad;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Password;
    private javax.swing.JButton jButton_imprimir;
    private javax.swing.JButton jButton_materias;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Titulo;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_materias;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_expediente;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_registrado_por;
    // End of variables declaration//GEN-END:variables

    private void Tabla(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new Render());
        JButton jButton_modificar = new JButton("Modificar");
        jButton_modificar.setName("modificar");
        JButton jButton_eliminar = new JButton("Eliminar");
        jButton_eliminar.setName("eliminar");

        model.addColumn("Código");
        model.addColumn("Nombre de Materia");
        model.addColumn("Sección");
        model.addColumn("Modificar");
        model.addColumn("Eliminar");

        Object[] fila = new Object[5];

        if (materia.length >= 1 && !materia[0].equals("")) {
            for (int i = 0; i < materia.length; i++) {
                materia2 = materia[i].split(",");
                fila[0] = materia2[0];
                fila[1] = materia2[1];
                fila[2] = materia2[2];
                fila[3] = jButton_modificar;
                fila[4] = jButton_eliminar;
                model.addRow(fila);
            }

            jTable_materias.setModel(model);
        }

        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla.rowAtPoint(e.getPoint());
                int columna_point = tabla.columnAtPoint(e.getPoint());

                if (fila_point >= 0 && columna_point >= 0) {
                    Object value = jTable_materias.getValueAt(fila_point, columna_point);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("modificar")) {
                            materia_codigo = (String) jTable_materias.getValueAt(fila_point, 0);
                            materia_nombre = (String) jTable_materias.getValueAt(fila_point, 1);
                            materia_seccion = (String) jTable_materias.getValueAt(fila_point, 2);

                            ModificarMaterias modificarmaterias = new ModificarMaterias();
                            modificarmaterias.setVisible(true);
                            if (modificarmaterias.isShowing()) {
                                InformacionAlumnos.this.dispose();
                            }
                        } else if (boton.getName().equals("eliminar")) {
                            materia_codigo = (String) jTable_materias.getValueAt(fila_point, 0);

                            System.out.println(materias);
                            if (materias.contains(materia_codigo)) {
                                materias = materias.replaceAll(materia_codigo, "");
                            }
                            if (!materias.equals("")) {
                                materias += "-";
                            }
                            System.out.println(materias);
                            

                            //IDEA PARA ELIMINAR
                            /**
                             * String palabra = "AAABBB, HOLA, 12";
                             * if(palabra.contains("AAABBB")){ palabra = ""; }
                             * System.out.println(palabra);
                             */
                        }
                    }
                }
            }

        });

    }

    private void Limpiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_cedula.setText("");
        txt_email.setText("");
        cmb_estatus.setSelectedIndex(0);
    }

    private void Verificado() {
        txt_nombre.setBackground(Color.green);
        txt_apellido.setBackground(Color.green);
        txt_cedula.setBackground(Color.green);
        txt_email.setBackground(Color.green);
    }
}
