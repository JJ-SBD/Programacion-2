public class Cuadrado extends Figura {

    Cuadrado(double lado) {
        super(lado);
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }
}
