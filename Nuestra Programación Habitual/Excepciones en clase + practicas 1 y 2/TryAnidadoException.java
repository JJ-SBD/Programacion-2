public class TryAnidadoException { //cuando ejecutamos la clase

public static void main (String [] args) {

    try //tiene 1 catch
    {
        int c = args.length;
        int a = 10 / c;
        System.out.println("El valor de a = " + a);

        try //tiene 2 catchs
        {
            if( c == 1)
            a = a / (c - 1);
            if(c == 2)
            {
                int[] b = {100, 5};
                b [3] = 0;
            }
            
        }
        catch(ArrayIndexOutOfBoundsException error) {

            System.out.print("Segunda Excepcion. El indice del array se paso de la raya" + error);
        }
        catch(Exception erre) {
        System.out.print("Excepcion Generica" + erre);
        }
    }

    catch(ArithmeticException checker){

                System.out.print("Primera Excepcion. Division por cero" + checker);
    }
}
}