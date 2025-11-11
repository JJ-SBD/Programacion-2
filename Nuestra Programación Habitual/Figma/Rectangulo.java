public class Rectangulo extends Figura {
    double altura;

    Rectangulo(double base, double altura) {
        super(base);
        this.altura = altura;
    }

    double calcularArea() {
        return lado * altura;
    }

    double calcularPerimetro() {
        return 2 * (lado + altura);
    }
}