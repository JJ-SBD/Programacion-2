import java.io.File;
public class FileDemo
{
    public void analizarArchivo(String ruta)
    {

    File nombre = new File(ruta); //creamos un nuevo objeto de tipo File que va a pedir la ruta
    if(nombre.exists())
    {
        System.out.println(nombre.getName() + "el archivo existe");
        if (nombre.isFile()){
            System.out.println("Es un archivo");
        }
        else if(nombre.isDirectory())
        {
            System.out.println("Es un directorio");
        }
        if (nombre.isAbsolute())
        {
            System.out.println("Tiene una ruta absoluta");
        }
        else
        {
            System.out.println("No tiene una ruta absoluta");
        }
        System.out.println("El valor long de la ultima modificacion: "+ nombre.lastModified());
        System.out.println("Tamaño de archivo: "+ nombre.length());
        System.out.println("Su ruta es: "+ nombre.getPath());
        System.out.println("Su ruta absoluta es: "+ nombre.getAbsolutePath());

        if(nombre.isDirectory()){
            String[] directorio = nombre.list();
            System.out.println("Contenido del directorio: \n");
            for (String nombreDirectorio : directorio) {
                System.out.println("El nombre del directorio es: " + nombreDirectorio);
                
            }
        }
    }
    else
    {
        System.out.println(ruta + "No existe");
    }
    }

    public static void main(String[] args)
    {
        FileDemo demo = new FileDemo();
        demo.analizarArchivo("D:\\La Asombrosa Chamba Digital\\Nuestra programacion habitual");
    }
}