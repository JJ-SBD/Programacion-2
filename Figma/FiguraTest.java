public class FiguraTest {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado(10);
        Rectangulo rectangulo = new Rectangulo(15,6);
        Circulo circulo = new Circulo(0,2.5);

        System.out.println("Area del cuadrado: " + cuadrado.calcularArea());
        System.out.println("Perimetro del cuadrado: " + cuadrado.calcularPerimetro());

        System.out.println("Area del rectangulo: " + rectangulo.calcularArea());
        System.out.println("Perimetro del rectangulo: " + rectangulo.calcularPerimetro());

        System.out.println("Area del circulo: " + circulo.calcularArea());
        System.out.println("Circunferencia del circulo:" + circulo.calcularPerimetro());
    }
}