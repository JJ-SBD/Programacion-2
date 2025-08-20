public class Circulo extends Figura {
    double radio;

    Circulo(double lado, double radio) {
        super(lado);
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return Math.PI * (radio * 2);
    }
}