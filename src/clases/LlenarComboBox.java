package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class LlenarComboBox {
    
    public static void ComboBoxNombre(JComboBox jComboBox1, JLabel jLabel_codigo_materia,String materia_codigo, String especialidad_update, String materia_nombre){
        String[] especialidad;
        int validar_especialidad = 0;
        jLabel_codigo_materia.setText(materia_codigo);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT especialidad FROM materias");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                if (rs.getString("especialidad").equalsIgnoreCase(especialidad_update)) {
                    try {
                        Connection cn2 = Conexion.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement(
                                "SELECT codigo, asignatura FROM materias WHERE especialidad = '" + especialidad_update + "' ORDER BY asignatura ASC");

                        ResultSet rs2 = pst2.executeQuery();

                        while (rs2.next()) {
                            jComboBox1.addItem(rs2.getString("asignatura"));
                            jLabel_codigo_materia.setText(rs2.getString("codigo"));
                        }
                        jComboBox1.setSelectedItem(materia_nombre);

                        cn2.close();
                    } catch (SQLException e) {
                        System.err.println("Ha ocurrido un error al rellenar el JComboBox " + e);
                        JOptionPane.showMessageDialog(null, "No se ha podio obtener los códigos de las materias");
                    }
                } else {
                    especialidad = rs.getString("especialidad").split(",");
                    for (int i = 0; i < especialidad.length; i++) {
                        if (especialidad[i].equals(especialidad_update)) {
                            validar_especialidad++;
                        }
                    }
                    if (validar_especialidad == 1 && rs.getString("especialidad").contains(",")) {
                        try {
                            Connection cn2 = Conexion.conectar();
                            PreparedStatement pst2 = cn2.prepareStatement(
                                    "SELECT codigo, asignatura FROM materias WHERE especialidad = '" + rs.getString("especialidad") + "' ORDER BY asignatura ASC");

                            ResultSet rs2 = pst2.executeQuery();

                            while (rs2.next()) {
                                jComboBox1.addItem(rs2.getString("asignatura"));
                                jLabel_codigo_materia.setText(rs2.getString("codigo"));
                            }
                            jComboBox1.setSelectedItem(materia_nombre);

                            cn2.close();
                        } catch (SQLException e) {
                            System.err.println("Ha ocurrido un error al rellenar el JComboBox " + e);
                            JOptionPane.showMessageDialog(null, "No se ha podio obtener los códigos de las materias");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error al obtener las especialidades " + e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener los especialidades de las materias");
        }
    }
    
    public static String[] ComboBoxSeccion(String materia_nombre){
        String[] seccion = new String[]{};
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT secciones from materias where asignatura = '"+materia_nombre+"'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                seccion = rs.getString("secciones").split(",");
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error con las secciones "+e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener las secciones de las materias");
        }
        return seccion;
    }
    
    public static void LabelCodigo(JLabel jLabel_codigo_materia, String materia_nombre) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "SELECT codigo from materias where asignatura = '"+materia_nombre+"'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                jLabel_codigo_materia.setText(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error con los códigos "+e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener los códigos de las materias");
        }
    }
    
}
