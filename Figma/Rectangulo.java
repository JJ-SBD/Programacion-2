public class Rectangulo extends Figura {
    //consideraremos al atributo heredado "lado" como la base del rectangulo
    double altura;

    Rectangulo(double lado, double altura) {
        super(lado);
        this.altura = altura;
    }

    public double calcularArea() {
        return lado * altura;
    }

    public double calcularPerimetro() {
        return (lado + altura)* 2;
    }
}