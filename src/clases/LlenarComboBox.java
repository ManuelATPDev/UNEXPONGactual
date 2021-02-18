package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class LlenarComboBox {

    public static void ComboBoxNombre(JComboBox jComboBox1, String especialidad_update) {

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT asignatura FROM materias WHERE especialidad = '"+ especialidad_update+"'");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("asignatura"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error al obtener las especialidades " + e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener los especialidades de las materias");
        }
    }

    public static String[] ComboBoxSeccion(String materia_nombre) {
        String[] seccion = new String[]{};
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT secciones from materias where asignatura = '" + materia_nombre + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                seccion = rs.getString("secciones").split(",");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error con las secciones " + e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener las secciones de las materias");
        }
        return seccion;
    }

}
