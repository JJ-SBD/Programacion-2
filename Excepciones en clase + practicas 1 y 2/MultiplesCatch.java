public class MultiplesCatch { //cuando ejecutamos la clase

public static void main (String [] args) { //mandamos llamar al metodo main que pide una cadena de caracteres en forma de array llamada args
    //si no le pones argumento vale 0
    int a;
    int [] b;
    int c = args.length; // quiero que valga la longitud del array args

    try {
        a = 10 / c;

        System.out.println("El valor de a = " + a);

        b = new int[5];
        
        for(int i = 0; i < a; i++)
        {
            b [i] = i;
        }
    }
    catch(ArithmeticException elchecker){ // el error PUEDE ser de tipo ArithmeticException y quiero que se llame elchecker
       
        System.out.print("Primera Excepcion. Division por cero" + elchecker);
    }
    catch(ArrayIndexOutOfBoundsException err) // el error PUEDE ser de tipo ArithmeticException y quiero que se llame elchecker
    {
        System.out.print("Segunda Excepcion. El indice del array se paso de la raya" + err);
    }
    

}
}