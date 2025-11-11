import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
 
public class LeerArchivoTexto{ 
    FileReader fr = null; 
    BufferedReader br = null; 
     
    public LeerArchivoTexto(){ 
        try { 
            fr = new FileReader("C:\\Users\\Labor\\Pictures\\Saved Pictures");
            br = new BufferedReader(fr); 
             
            String contenido = br.readLine(); 
            while(contenido != null){ 
                System.out.println(contenido); 
                contenido = br.readLine(); 
 
            /* para la segunda ejecución se puede cambiar a la lectura de caracter 
            por caracter 
 
            int caracter = br.read(); 
            while(caracter != -1) { 
                System.out.println((char) caracter); 
                caracter = br.read(); 
            }  
             
            */ 
            } 
             
        }  
        catch (FileNotFoundException ex) { 
            ex.printStackTrace(); 
        }  
        catch (IOException ex) { 
            ex.printStackTrace(); 
        }  
        finally { 
            try { 
                if(fr != null) { 
                    fr.close(); 
                } 
            } 
            catch (IOException e) { 
                System.out.println(e.getMessage()); 
            } 
        } 
    } 
     
    public static void main(String[] args) { 
        LeerArchivoTexto archivo = new LeerArchivoTexto(); 
    } 
} 
