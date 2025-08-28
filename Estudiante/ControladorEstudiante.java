
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class ControladorEstudiante{
    public static void main(String[] args){
        //Nuestro scanner
        Scanner ska = new Scanner(System.in);

        //Comienza la captura de datos
        System.out.print("Nombre: ");
        String nombre = ska.nextLine();
        
        System.out.print("Apellido P: ");
        String apellidoPaterno = ska.nextLine();
        
        System.out.print("Apellido M: ");
        String apellidoMaterno = ska.nextLine();

        //Aqui comienza lo de la Fecha
        System.out.println("Fecha de Nacimiento dia/mes/año");
        String fechaStr = ska.nextLine();

        DateTimeFormatter forma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //try {
            LocalDate fechaNacimiento = LocalDate.parse(fechaStr, forma);
            System.out.println("Fecha convertida: " + fechaNacimiento);
            
             System.out.println("ID:");
             int ID = ska.nextInt();

        //} catch (DateTimeParseException e) {
            //System.out.println("Formato de fecha inválido, por favor use dd/MM/yyyy");

        System.out.println("Carrera:");
        String carrera = ska.next();
        
        System.out.println("Titulo:");
        String titulo = ska.next();

        System.out.println("Año esperado de Graduacion:");
        int añoGraduacion = ska.nextInt();
        Estudiante alumno1 = new Estudiante(nombre, apellidoPaterno, apellidoMaterno, null, añoGraduacion, ID, carrera, titulo, añoGraduacion);


	alumno1.imprimirDatos();
    alumno1.calcularPromedio();
	alumno1.imprimirPromedio();
	alumno1.cambiarCarrera();

        ska.close();
    }
}
