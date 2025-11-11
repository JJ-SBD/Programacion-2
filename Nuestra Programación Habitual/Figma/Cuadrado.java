public class Cuadrado extends Figura {

    Cuadrado(double lado) {
        super(lado);
    }

    double calcularArea() {
        return lado * lado;
    }

    double calcularPerimetro() {
        return 4 * lado;
    }
}
