public class FiguraTest {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado(4);
        Rectangulo rectangulo = new Rectangulo(5, 3);
        Circulo circulo = new Circulo(2.5);

        System.out.println("Cuadrado área: " + cuadrado.calcularArea());
        System.out.println("Cuadrado perímetro: " + cuadrado.calcularPerimetro());

        System.out.println("Rectángulo área: " + rectangulo.calcularArea());
        System.out.println("Rectángulo perímetro: " + rectangulo.calcularPerimetro());

        System.out.println("Círculo área: " + circulo.calcularArea());
        System.out.println("Círculo perímetro: " + circulo.calcularPerimetro());
    }
}