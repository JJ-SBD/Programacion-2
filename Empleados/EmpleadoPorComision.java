// Un empleado que cobra en función de sus ventas
public class EmpleadoPorComision extends Empleado {
    private double ventasBrutas; // Ventas totales por semana
    private double tarifaComision; // Porcentaje de comisión

    // Constructor
    public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
            String numeroSeguroSocial, double ventasBrutas, double tarifaComision) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        // Validaciones
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

        if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");

        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    // Setters con validación
    public void establecerVentasBrutas(double ventasBrutas) {
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        this.ventasBrutas = ventasBrutas;
    }

    public void establecerTarifaComision(double tarifaComision) {
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        this.tarifaComision = tarifaComision;
    }

    // Getters
    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    // Cálculo de ingresos = ventas × comisión
    @Override
    public double ingresos() {
        return obtenerTarifaComision() * obtenerVentasBrutas();
    }

    // Representación de texto
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
                "Empleado por comisión", super.toString(),
                "ventas brutas", obtenerVentasBrutas(),
                "tarifa por comisión", obtenerTarifaComision());
    }
}