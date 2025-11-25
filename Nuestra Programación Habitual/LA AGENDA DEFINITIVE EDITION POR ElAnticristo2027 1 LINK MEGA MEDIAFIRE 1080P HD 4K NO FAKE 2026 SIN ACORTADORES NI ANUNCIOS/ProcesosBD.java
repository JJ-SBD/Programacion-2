import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProcesosBD extends ConexionBD {
    protected PreparedStatement pstm = null;
    protected ResultSet rst = null;
    protected String sql = "";
    protected Alumno alumno;

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void insertarRegistro() throws Exception {
        sql = "INSERT INTO alumno (cuenta, nombre, apellidoP, apellidoM, edad, direccion, ciudad, telefono, email, nacionalidad, licenciatura, semestre)"
                + " VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";

        try {
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

            pstm.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Error al insertar los datos: " + sqle.getMessage());
            sqle.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException sqle) {
                System.out.println("Error cerrando la conexión: " + sqle.getMessage());
                sqle.printStackTrace();
            }
        }
    }

    /**
     * Busca alumnos por apellido paterno o materno (coincidencia exacta).
     * Retorna una lista de objetos Alumno (vacía si no hay coincidencias).
     */
    public List<Alumno> buscarPorApellido(String apellido) throws Exception {
        List<Alumno> lista = new ArrayList<>();
        sql = "SELECT * FROM alumno WHERE apellidoP = ? OR apellidoM = ?";

        try {
            conn = obtenerConexion();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, apellido);
            pstm.setString(2, apellido);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Alumno a = new Alumno();
                a.setCuenta(rst.getInt("cuenta"));
                a.setNombre(rst.getString("nombre"));
                a.setApellidoP(rst.getString("apellidoP"));
                a.setApellidoM(rst.getString("apellidoM"));
                a.setEdad(rst.getInt("edad"));
                a.setDireccion(rst.getString("direccion"));
                a.setCiudad(rst.getString("ciudad"));
                a.setTelefono(rst.getString("telefono"));
                a.setEmail(rst.getString("email"));
                a.setNacionalidad(rst.getString("nacionalidad"));
                a.setLicenciatura(rst.getString("licenciatura"));
                a.setSemestre(rst.getInt("semestre"));

                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Error en buscarPorApellido: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (rst != null) rst.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException sqle) {
                System.out.println("Error cerrando recursos: " + sqle.getMessage());
                sqle.printStackTrace();
            }
        }

        return lista;
    }

    /**
     * Actualiza los campos editables del alumno identificado por cuenta.
     * Retorna true si se actualizó al menos una fila.
     */
    public boolean actualizarRegistro(Alumno a) throws Exception {
        if (a == null) return false;
        sql = "UPDATE alumno SET nombre = ?, apellidoP = ?, apellidoM = ?, direccion = ?, ciudad = ?, telefono = ?, email = ? WHERE cuenta = ?";

        boolean actualizado = false;
        try {
            conn = obtenerConexion();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, a.getNombre());
            pstm.setString(2, a.getApellidoP());
            pstm.setString(3, a.getApellidoM());
            pstm.setString(4, a.getDireccion());
            pstm.setString(5, a.getCiudad());
            pstm.setString(6, a.getTelefono());
            pstm.setString(7, a.getEmail());
            pstm.setInt(8, a.getCuenta());

            int filas = pstm.executeUpdate();
            actualizado = (filas > 0);

        } catch (SQLException e) {
            System.out.println("Error actualizando registro: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException sqle) {
                System.out.println("Error cerrando recursos: " + sqle.getMessage());
                sqle.printStackTrace();
            }
        }
        return actualizado;
    }

    /**
 * Elimina el registro del alumno identificado por la PK 'cuenta'.
 * Retorna true si se eliminó al menos una fila.
 */
public boolean eliminarRegistro(Alumno a) throws Exception {
    if (a == null) return false;
    sql = "DELETE FROM alumno WHERE cuenta = ?";

    boolean eliminado = false;
    try {
        conn = obtenerConexion();
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, a.getCuenta());

        int filas = pstm.executeUpdate();
        eliminado = (filas > 0);

    } catch (SQLException e) {
        System.out.println("Error eliminando registro: " + e.getMessage());
        e.printStackTrace();
        throw e;
    } finally {
        try {
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        } catch (SQLException sqle) {
            System.out.println("Error cerrando recursos: " + sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    return eliminado;
}
}

