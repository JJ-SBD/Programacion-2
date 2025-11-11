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

        System.out.print("Apellido paterno: ");
        alumno.setPaterno(entrada.nextLine());

        System.out.print("Apellido materno: ");
        alumno.setMaterno(entrada.nextLine());

        System.out.print("Nombre: ");
        alumno.setNombre(entrada.nextLine());

        System.out.print("Dirección: ");
        alumno.setDireccion(entrada.nextLine());

        System.out.print("Teléfono: ");
        alumno.setTelefono(entrada.nextLine());

        System.out.print("Licenciatura: ");
        alumno.setLicenciatura(entrada.nextLine());

        System.out.print("Semestre: ");
        alumno.setSemestre(entrada.nextLine());

        try {
            procesoInsertar.setAlumno(alumno);
            procesoInsertar.insertarRegistro();
            System.out.println("Datos guardados con éxito.");
        } catch (Exception exc) {
            System.out.println("No se pudieron guardar los datos.");
        }
    }
}