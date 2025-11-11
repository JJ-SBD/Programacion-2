import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import java.util.Scanner; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
 
public class CrearArchivoTexto { 
     
    public static void main(String[] args) { 
         
        FileWriter fw = null; 
        PrintWriter salida = null; 
        try { 
            Scanner sc = new Scanner(System.in); 
            fw = new FileWriter("C:\\Users\\Labor\\Pictures\\Saved Pictures", false);
            // para segunda ejecución usar el constructor sobre cargado 
            // que indica que quiero agregar cadenas de caracteres a lo 
            // que previamente tiene almacenado el archivo 
            //fw = new FileWriter("c:/archivos/datos.txt", true); 
            salida = new PrintWriter(fw); 
            String cadena; 
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:"); 
            cadena = sc.nextLine(); 
            while (!cadena.equalsIgnoreCase("FIN")) { 
                salida.println(cadena); 
                cadena = sc.nextLine(); 
            } 
            salida.flush(); 
             
        } catch (IOException ex) { 
            Logger.getLogger(CrearArchivoTexto.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {     
            salida.close(); 
        } 
    } 
} 
