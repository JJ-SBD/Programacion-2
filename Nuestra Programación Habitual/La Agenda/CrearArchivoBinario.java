import java.io.*;

public class CrearArchivoBinario {

    private static final String ruta = "Personas.bin";

    public static boolean guardarPersona(Persona objetoPersona) {
        File archivo = new File(ruta);
        boolean combinado = archivo.exists() && archivo.length() > 0;//el archivo ya existe y tiene contenido?

        ObjectOutputStream oos = null;
        try (FileOutputStream fos = new FileOutputStream(archivo, true)) {
            if (combinado) {
                //crea una versión modificada de ObjectOutputStream que no escriba cabecera al anexar
                oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() throws IOException { /* sin header */ }
                };
            } else {
                //usa el ObjectOutputStream normal, porque el archivo está vacío y se necesita escribir la cabecera al principio
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(objetoPersona);
            oos.flush();// escribe datos al búfer
            return true;// vacía el búfer: los datos se guardan realmente en el archivo
        } catch (IOException ex) { //cualquier tipo de excepcion de entrada o salida
            ex.printStackTrace();
            return false; //Si ocurre un error, devuelve false para avisar al programa que no se guardó la persona correctamente
        } finally {
            if (oos != null)//Verifica si oos existe
            try { oos.close();//Intenta cerrar el flujo oos
            } catch (IOException ex) {}//Atrapa cualquier error al cerrarlo
        }
    }
}
