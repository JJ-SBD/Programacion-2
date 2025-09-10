public class Factura implements PorPagar { // se cambia extends por implements
    private final String numeroPieza;
    private final String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    // Constructor
    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        if (cantidad < 0) // Valida la cantidad
            throw new IllegalArgumentException("Cantidad debe ser >=0");

        if (precioPorArticulo < 0.0) // Valida el precio por artículo
            throw new IllegalArgumentException("El precio por artículo debe ser >=0");

        this.cantidad = cantidad;
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        this.precioPorArticulo = precioPorArticulo;
    }

    // Obtiene el número de pieza
    public String obtenerNumeroPieza() {
        return numeroPieza;
    }

    // Obtiene la descripción
    public String obtenerDescripcionPieza() {
        return descripcionPieza;
    }

    // Establece la cantidad
    public void establecerCantidad(int cantidad) {
        if (cantidad < 0)
            throw new IllegalArgumentException("Cantidad debe ser >= 0");

        this.cantidad = cantidad;
    }

    // Obtener cantidad
    public int obtenerCantidad() {
        return cantidad;
    }

    // Establece el precio del artículo
    public void establecerPrecioArticulo(double precioPorArticulo) {
        if (precioPorArticulo < 0.0)
            throw new IllegalArgumentException("El precio por artículo debe ser >=0");

        this.precioPorArticulo = precioPorArticulo;
    }

    // Obtiene el precio por artículo
    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    // Devuelve representación String de un objeto Factura
    @Override
    public String toString() {
        return String.format("%s: %n%s %s (%s) %n%s: %d %n%s: $%,.2f",
                "factura", "numero de pieza", obtenerNumeroPieza(), obtenerDescripcionPieza(),
                "cantidad", obtenerCantidad(), "precio por articulo", obtenerPrecioPorArticulo());
    }

    @Override
    public double obtenerMontoPago() {
        return obtenerCantidad() * obtenerPrecioPorArticulo();
    }
}
