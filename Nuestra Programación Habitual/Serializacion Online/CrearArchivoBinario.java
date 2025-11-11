import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CrearArchivoBinario {
    private ObjectOutputStream salida;

    public void abrirArchivo() {
        try {
            salida = new ObjectOutputStream(new FileOutputStream("D:\\La Asombrosa Chamba Digital\\Nuestra programacion habitual\\Serializacion Online\\Personas.txt")); //aqui le podriamos poner la ruta si queremos
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void agregarRegistros() {

        Persona ObjPersona;
        String nombre;
        int edad;
        String direccion;
        String nacionalidad;
        double salario;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los datos de la persona. Escriba el indicador" + "de fin de archivo para terminar");

        System.out.println("Hagalo en orden: nombre edad direccion nacionalidad salario");

        while(entrada.hasNextLine()){
            try {
                nombre = entrada.nextLine();
                edad = Integer.parseInt(entrada.nextLine());
                direccion = entrada.nextLine();
                nacionalidad = entrada.nextLine();
                salario = Double.parseDouble(entrada.nextLine());

                ObjPersona = new Persona(nombre, edad, direccion, nacionalidad, salario);//creamos el objeto a seriaizar
                salida.writeObject(ObjPersona);
                
            } catch (IOException ex) { //puede generar excepciones por culpa de que la ruta no exista o no pueda acceder
                ex.printStackTrace();
            }
            System.out.println("Ingrese los datos de la siguiente persona en el mismo orden");
        }
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) { //checa si salida todavia tiene algo
                salida.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CrearArchivoBinario app = new CrearArchivoBinario();
        app.abrirArchivo();
        app.agregarRegistros();
        app.cerrarArchivo();
    }
}