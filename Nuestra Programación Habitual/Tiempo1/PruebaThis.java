// Uso implícito y explícito de this para hacer referencia a los miembros de un objeto
public class PruebaThis {
    public static void main(String[] args) {
        TiempoSimple tiempo = new TiempoSimple(15, 30, 19);
        System.out.println(tiempo.crearString());
    }
}

// La clase TiempoSimple demuestra la referencia "this"
class TiempoSimple {
    private int hora;
    private int minuto;
    private int segundo;

    public TiempoSimple(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public String crearString() {
        return String.format("%24s: %s%n%24s: %s",
            "this.aStringUniversal()", this.aStringUniversal(),
            "aStringUniversal()", aStringUniversal());
    }

    public String aStringUniversal() {
        return String.format("%02d:%02d:%02d",
            this.hora, this.minuto, this.segundo);
    }
}