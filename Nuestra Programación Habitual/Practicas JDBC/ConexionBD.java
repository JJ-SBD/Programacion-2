import java.sql.Connection;
import java.sql.*;
public class ConexionBD{ 
final String driver="com.mysql.jdbc.Driver";
final String usr="root";
final String pwd="admin";
final String dburl="jdbc:mysql://localhost/alumnos";

protected Connection con=null;
protected PreparedStatement pstm=null;
protected ResultSet rst=null;
protected String sql="";

public Connection getConexion()throws Exception{
try{
Class.forName (driver);
con=DriverManager.getConnection(dburl, usr, pwd);
}
catch (ClassNotFoundException cnfe){
con=null;
System.out.println("Error al cargar el driver");
}
catch (SQLException sqe){
con=null;
System.out.println ("Error al obtener la conexion");
}
return con;
}
}