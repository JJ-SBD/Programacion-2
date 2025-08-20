// Los miembros de la clase Tiempo1 no son accesibles.
public class PruebaAccesoMiembros {
    public static void main(String[] args) {
        //creacion de un objeto
        Tiempo1 tiempo = new Tiempo1();
        // No se puede acceder porque son atributos privados
        //solo se puede acceder usando metodos publicos
        tiempo.hora = 7;    
        tiempo.minuto = 15;
        tiempo.segundo = 30;
    }
}