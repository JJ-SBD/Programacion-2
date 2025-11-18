import java.util.Scanner;

public class PruebaInsertar {
    public static void main(String[] args) {

        Alumno alumno = new Alumno();
        ProcesosBD procesoInsertar = new ProcesosBD();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese los datos del alumno a registrar en la base de datos");
        
        System.out.print("Número de cuenta: ");
        alumno.setCuenta(entrada.nextInt());
        entrada.nextLine(); // limpiar buffer
        // se limpia el buffer con nextLine() justo después de usar métodos numéricos.

        System.out.print("Nombre: ");
        alumno.setNombre(entrada.nextLine());

        System.out.print("Apellido paterno: ");
        alumno.setApellidoP(entrada.nextLine());

        System.out.print("Apellido materno: ");
        alumno.setApellidoM(entrada.nextLine());

        System.out.print("Edad: ");
        alumno.setEdad(entrada.nextInt());
        entrada.nextLine(); // limpiar buffer

        System.out.print("Dirección: ");
        alumno.setDireccion(entrada.nextLine());

        System.out.print("Ciudad: ");
        alumno.setCiudad(entrada.nextLine());

        System.out.print("Teléfono: ");
        alumno.setTelefono(entrada.nextLine());

        System.out.print("Email: ");
        alumno.setEmail(entrada.nextLine());

        System.out.print("Nacionalidad: ");
        alumno.setNacionalidad(entrada.nextLine());

        System.out.print("Licenciatura: ");
        alumno.setLicenciatura(entrada.nextLine());

        System.out.print("Semestre: ");
        alumno.setSemestre(entrada.nextInt());

        try {
            procesoInsertar.setAlumno(alumno);
            procesoInsertar.insertarRegistro();
            System.out.println("Datos guardados con éxito.");
        } catch (Exception exc) {
            System.out.println("No se pudieron guardar los datos.");
        }
    }
}