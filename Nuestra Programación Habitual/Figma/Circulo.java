public class Circulo extends Figura {
    Circulo(double radio) {
        super(radio);
    }

    double calcularArea() {
        return Math.PI * lado * lado;
    }

    double calcularPerimetro() {
        return 2 * Math.PI * lado;
    }
}