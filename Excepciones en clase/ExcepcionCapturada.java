public class ExcepcionCapturada {

public static void main (String [] args) {
    int a, b;

    try {

         a = 0;
         b = 10 /a; //en esta linea exacta es donde ocurre el error
        System.out.println("Esta linea de codigo ya no se lee porque tan pronto el java detecta el error se va con el catch");
    }
    catch(ArithmeticException checker){ // el error es de tipo ArithmeticException y quiero que se llame checker
        System.out.println("ERROR ERROR DIVISION FATAL ENTRE 0" + checker);

    }
    finally{
        System.out.println("El error fue detectado, estamos salvados, ahora sigamos con el programa :)");
    }

    System.out.println("Dadadidadu dadadididdadadu");
    //porque ya no imprime el dadadidadu :(?
    

}
}