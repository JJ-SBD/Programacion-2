import java.util.Date;
import java.util.Scanner;

public class Estudiante extends Persona{
     Scanner ska = new Scanner(System.in);

    private double PromCalif;
    public int ID;
    private String carrera;
    private String titulo;
    public int añoGraduacion;
    
    public Estudiante(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
            double promCalif, int iD, String carrera, String titulo, int añoGraduacion) {
        super(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        PromCalif = promCalif;
        ID = iD;
        this.carrera = carrera;
        this.titulo = titulo;
        this.añoGraduacion = añoGraduacion;
    }

    public double getPromCalif() {
        return PromCalif;
    }

    public void setPromCalif(double promCalif) {
        PromCalif = promCalif;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoGraduacion() {
        return añoGraduacion;
    }

    public void setAñoGraduacion(int añoGraduacion) {
        this.añoGraduacion = añoGraduacion;
    }


	public void imprimirDatos()
	{
        System.out.println("\nDatos ingresados");
        System.out.println("Nombre: " + this.obtenerNombre());
        System.out.println("Apellido P: " + this.obtenerApellidoPaterno());
        System.out.println("Apellido M: " + this.obtenerApellidoMaterno());
        System.out.println("Fecha de Nacimiento: ");
        System.out.println("ID: " + this.getID());
        System.out.println("Carrera: " + this.getCarrera());
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Año esperado de Graduacion: " + this.getAñoGraduacion());
    }

	@Override
	public String toString()
  	{
  		return String.format("%s: %s %s%n%s: %s%n%s:",
  			"nombre", "apellidoPaterno", "apellidoMaterno", 
  			"fecha", "carrera", "titulo");
	}


    //Metodo para cambiar carrera

    public void cambiarCarrera()
    {
        String respuesta;
        

        System.out.println("¿Quiere cambiarle la carrera al estudiante?");

        respuesta = ska.nextLine();

        if(respuesta.equals("si"))
        {

        System.out.println("¿Que va a estudiar ahora?");

        String carreraNueva = ska.next();

        System.out.println("La nueva carrera es: " + carreraNueva + "Fin del programa");
        }

	    else if(respuesta.equals("no"))
	
	System.out.println("La carrera no cambiara" + "Fin del programa");
    }
	//modificar con letras
    public int calcularPromedio()
    {
        int suma = 0;
        int promedio;

        System.out.println("¿Cuántas calificaciones quieres ingresar?");
        
        int nCalifs = ska.nextInt();

        int[] calificaciones = new int[nCalifs]; //Creamos Array

        

        for (int i = 0; i < nCalifs; i++)
        {

            System.out.print("Ingresa la calificación #" + (i + 1) + ": ");

            calificaciones[i] = ska.nextInt();

        }
        
        //imprimimos calificaciones

        for(int j = 0; j < nCalifs; j ++)
        {
            System.out.println("La Calificacion Numero: " + ( j + 1) + "=" + calificaciones[j]);
        }
        
        //calculamos el promedio
	{

        for (int i = 0; i < nCalifs; i++)

        {
            suma = suma + calificaciones[i];
        }

        promedio = suma/nCalifs;

        return promedio; //el metodo devuelve el promedio para poder usarlo en otros metodos
	}
    //imprimimos el promedio
    }
    public void imprimirPromedio()
    {
        int pro = calcularPromedio(); //lamamos al metodo que contiene el promedio
        System.out.println("Promedio:" + pro);
    }
}