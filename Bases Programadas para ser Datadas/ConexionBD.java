import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConexionBD
{
    final String driver = "com.mysql.cj.jdbc.Driver"; // en la documentacion del driver debe venir el nombre de la clase que va aqui
    final String usr = "root";
    final String pwd = "123456";
    //con que controlador estoy trabajando // donde esta: puerto por donde escucha
    final String dburl = "jdbc:mysql://localhost:3306/bdalumno?zeroDateTimeBeahvior=CONVERT_TO_NULL";
    //lo del zeroDateTimeBehavior es para que este controlador no tenga pedos con la zona horaria

    protected Connection conn = null;
    protected PreparedStatement pstm = null;
    protected ResultSet rst = null;
    protected String sql = "";

    
    public Connection obtenerConexion() throws Exception
    {
        try{

            Class.forName(driver); //carga el driver a traves de su nombre con la clase Class
            conn = DriverManager.getConnection(dburl, usr, pwd); //uso la clase con el metodo, va a pedir la ubicacion, usuario y pass

        }catch(ClassNotFoundException cnfe){ //por si no encuentra el driver

            conn = null; //vas a poner la conexion en nula
            System.out.println("El driver no carga"); //vas a avisar que no cargo
            cnfe.printStackTrace(); //imprime la traza del error

        }catch(SQLException sqle){ // por si no hya conexion
            conn = null;
            System.out.println("Error al obtener la conexion");
        }

        return conn;
    }

}
