package clases;
import java.sql.*;
/**
 *
 * @author Manuel & Stefany
 */
public class Conexion {
    //Conexion Local
    public static Connection conectar(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_proyecto_unexpoactual", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion local "+e);
        }
        return (null);
    }
}
