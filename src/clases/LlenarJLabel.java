package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class LlenarJLabel {
    public static void LabelCodigo(JLabel jLabel_codigo_materia, String materia_nombre) {
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT codigo from materias where asignatura = '" + materia_nombre + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                jLabel_codigo_materia.setText(rs.getString("codigo"));
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error con los códigos " + e);
            JOptionPane.showMessageDialog(null, "No se ha podio obtener los códigos de las materias");
        }
    }
}
