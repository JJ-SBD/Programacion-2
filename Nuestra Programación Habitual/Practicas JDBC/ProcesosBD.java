import java.sql.*;

public class ProcesosBD extends ConexionBD{

protected Alumno alumno;

public void setAlumno (Alumno alumno){
this.alumno=alumno;
}
public Alumno getAlumno (){
return alumno;
}

public void toCrearAlumno() throws Exception{
sql="insert into Alumno (Cuenta, Paterno, Materno, Nombre, Direccion, Telefono, Licenciatura, Semestre) values (?, ?, ?, ?, ?, ?, ?, ?)";
try{
con=getConexion();
pstm=con.prepareStatement(sql);
pstm.setInt(1,alumno.getCuenta());
pstm.setString(2,alumno.getPaterno());
pstm.setString(3,alumno.getMaterno());
pstm.setString(4,alumno.getNombre());
pstm.setString(5,alumno.getDireccion());
pstm.setInt(6,alumno.getTelefono());
pstm.setString(7,alumno.getLicenciatura());
pstm.setInt(8,alumno.getSemestre());
pstm.executeUpdate();
}
catch (SQLException sqle){
System.out.println("Error al insetar los datos");
}
finally{
try{ 
con.close ();
}
catch (SQLException sqle){
System.out.println("Error al cerrar la BD");
}
}
}
}