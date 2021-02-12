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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manuel
 */
public class GestionarAlumnos extends javax.swing.JFrame {

    String user;
    String[] user2;
    public static String user_update = "", especialidad_update = "";
    public static int ID_update;
    DefaultTableModel model = new DefaultTableModel(); //Acceso a los métodos necesarios para modificar una tabla

    /**
     * Creates new form GestionarAdministradores
     */
    public GestionarAlumnos() {
        initComponents();
        user = Administrador.nombre_usuario;
        user2 = user.split(" ");
        setTitle("Gestionar Administradores - Sesión de " + user2[0]);

        setSize(970, 360);
        setResizable(false);
        setLocationRelativeTo(null);
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
                    "select id, nombres, apellidos, cedula, expediente, especialidad, email, estatus, registrado_por from alumnos");

            ResultSet rs = pst.executeQuery();

            jTable_administradores = new JTable(model);
            jScrollPane1.setViewportView(jTable_administradores);

            model.addColumn(" ");
            model.addColumn("Nombres");
            model.addColumn("Apellidos");
            model.addColumn("Cédula");
            model.addColumn("Expediente");
            model.addColumn("Especialidad");
            model.addColumn("Correo Electrónico");
            model.addColumn("Estatus");
            model.addColumn("Registrado por");

            while (rs.next()) {
                Object[] fila = new Object[9];

                for (int i = 0; i < 9; i++) {
                    fila[i] = rs.getObject(i + 1);
                    jTable_administradores.setDefaultEditor(model.getColumnClass(i), null);
                }

                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al llenar tabla" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion. Contacte con un administrador");
        }

        jTable_administradores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_administradores.rowAtPoint(e.getPoint());
                int columna_point = 1, columna_point2 = 0, columna_point3 = 5;

                if (fila_point >= 0 && columna_point >= 0 && e.getClickCount() == 2) {
                    user_update = (String) model.getValueAt(fila_point, columna_point);
                    ID_update = ((Long) model.getValueAt(fila_point, columna_point2)).intValue();
                    especialidad_update = (String)model.getValueAt(fila_point, columna_point3);
                    InformacionAlumnos informacionalum = new InformacionAlumnos();
                    informacionalum.setVisible(true);
                }
            }

        });
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_administradores = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestionar Alumnos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jTable_administradores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_administradores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 970, 180));

        jLabel_footer.setText("Creado por Manuel Torrealba y Stefany Villamizar");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, -1, -1));
        getContentPane().add(jLabel_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_fondo;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_administradores;
    // End of variables declaration//GEN-END:variables
}
