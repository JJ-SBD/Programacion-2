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
        sql = "INSERT INTO alumno (cuenta, paterno, materno, nombre, direccion, telefono, licenciatura, semestre)"
            + "VALUES ( ? , ? , ? , ? , ? , ? , ? , ? )";
        //esto se llama codigo embeido y se distingue con comillas dobles un bloque de "" para java y un bloque de "" para sql
        //un ? por cada campo

        try{
            conn = obtenerConexion();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, alumno.getCuenta());
            pstm.setString(2, alumno.getPaterno());
            pstm.setString(3, alumno.getMaterno());
            pstm.setString(4, alumno.getNombre());
            pstm.setString(5, alumno.getDireccion());
            pstm.setString(6, alumno.getTelefono());
            pstm.setString(7, alumno.getLicenciatura());
            pstm.setString(8, alumno.getSemestre());

            pstm.executeUpdate(); // se usa para inserciones de datos
        }catch(SQLException sqle){
            System.out.println("Algo salio mal");
            sqle.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(SQLException sqle){
                System.out.println("Error al cerrar conexion");
                sqle.printStackTrace();
            }
        }
        }
    }

