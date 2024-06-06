package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private String db_nombre = "parcial";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/" + this.db_nombre;

    Connection conexion = null;

    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
                        
            conexion = DriverManager.getConnection(this.url, this.user, this.password);
            
        } catch (SQLException xd) {
            JOptionPane.showMessageDialog(null, "Error: " + xd);
        } catch (ClassNotFoundException noxd) {
            JOptionPane.showMessageDialog(null, "Error: " + noxd);
        }
return conexion;
    }

}
