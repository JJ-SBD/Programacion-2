// La declaración de la clase Tiempo1 mantiene la hora en formato de 24 horas.

//Nombre de la clase
public class Tiempo1 {

    //atributos de la clase
    private int hora; //atributo privado de tipo entero llamado "hora"
    private int minuto;
    private int segundo;

    //Constructor de la clase con los 3 atributos
    public void establecerTiempo(int hora, int minuto, int segundo) {
        
        //metodo if con condiciones OR, si alguna de ellas se cumple se procedera con la funcion del metodo
        if (hora < 0 || hora >= 24 || minuto < 0 || minuto >= 60 || segundo < 0 || segundo >= 60) {

            //Si cualquiera de los valores de los atributos esta fuera de rango se imprime este mensaje
            throw new IllegalArgumentException("hora, minuto y/o segundo estaban fuera de rango");
        }
        this.hora = hora; //el atributo de la clase "hora" tomara el valor de la variable local "hora"
        this.minuto = minuto;
        this.segundo = segundo;
    }

    //Metodo publico de tipo String llamado "aStringUniversal"
    public String aStringUniversal() {
        //Devuelve un String formateado usando el formato especificado y argumentos
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s", 
            ((hora == 0 || hora == 12) ? 12 : hora % 12), 
            minuto, segundo, (hora < 12 ? "AM" : "PM"));
    }
}