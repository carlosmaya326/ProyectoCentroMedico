package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private  Connection conexion;

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }
    public Conexion() throws InstantiationException, IllegalAccessException, SQLException{
       
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost/centromedico";
            String usuario="root";
            String password="";
            conexion = DriverManager.getConnection(url,usuario,password);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
