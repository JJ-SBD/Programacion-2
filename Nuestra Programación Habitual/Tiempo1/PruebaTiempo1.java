// Objeto Tiempo1 utilizado en una aplicación
public class PruebaTiempo1 {

    //Metodo main
    public static void main(String[] args) {

        //creacion de un nuevo objeto llamado tiempo para la clase Tiempo1 usando su cosntrcutor por defecto
        Tiempo1 tiempo = new Tiempo1();
        //Imprime un mensaje en pantalla usando el metodo "mostrarTiempo" junto con el valor de nuestro objeto
        mostrarTiempo("Después de crear el objeto tiempo", tiempo);
        System.out.println();

        //Se le asignan valores al objeto segun los parametros del constructor de su clase
        tiempo.establecerTiempo(13, 27, 6);
        mostrarTiempo("Después de llamar a establecerTiempo", tiempo);
        System.out.println();

        try {
            tiempo.establecerTiempo(99, 99, 99);
        } catch (IllegalArgumentException e) {
            System.out.printf("Excepción: %s%n%n", e.getMessage());
        }
        mostrarTiempo("Después de llamar a establecerTiempo con valores inválidos", tiempo);
    }
    //creacion del metodo "mostrar tiempo"
    private static void mostrarTiempo(String encabezado, Tiempo1 t) {
        System.out.printf("%s%nTiempo universal: %s%nTiempo estándar: %s%n",
            encabezado, t.aStringUniversal(), t.toString());
    }
}
//¿Que va dentro del metodo main y que va fuera de el?