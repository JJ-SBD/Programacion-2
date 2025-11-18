import java.sql.*;

public class ProcesosBD extends ConexionBD
{
    protected PreparedStatement pstm = null;
    protected ResultSet rst = null;
    protected String sql = "";
    protected Alumno alumno;

    public void setAlumno(Alumno alumno)
    {
        this.alumno = alumno;
    }

    public Alumno getAlumno(){
        return alumno;
    }

    public void insertarRegistro() throws Exception
    {
        sql = "INSERT INTO alumno (cuenta, nombre, apellidoP, apellidoM, edad, direccion, ciudad, telefono, email, nacionalidad, licenciatura, semestre)"
            + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
        //esto se llama codigo embebido y se distingue con comillas dobles un bloque de "" para java y un bloque de "" para sql
        //un ? por cada campo, es cuando Java ejecuta sentencias SQL directamente dentro del programa

        try{
            conn = obtenerConexion();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, alumno.getCuenta());
            pstm.setString(2, alumno.getNombre());
            pstm.setString(3, alumno.getApellidoP());
            pstm.setString(4, alumno.getApellidoM());
            pstm.setInt(5, alumno.getEdad());
            pstm.setString(6, alumno.getDireccion());
            pstm.setString(7, alumno.getCiudad());
            pstm.setString(8, alumno.getTelefono());
            pstm.setString(9, alumno.getEmail());
            pstm.setString(10, alumno.getNacionalidad());
            pstm.setString(11, alumno.getLicenciatura());
            pstm.setInt(12, alumno.getSemestre());

            pstm.executeUpdate(); // se usa para inserciones de datos
        }catch(SQLException sqle){
            System.out.println("Algo valio pija al insertarte tus datos");
            sqle.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(SQLException sqle){
                System.out.println("La conexion quedo mas abierta que tus nalgas");
                sqle.printStackTrace();
            }
        }
        }
    }

