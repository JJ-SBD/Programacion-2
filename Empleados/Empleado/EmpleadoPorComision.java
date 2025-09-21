// La clase EmpleadoPorComision extiende a Empleado
public class EmpleadoPorComision extends Empleado {
    private double ventasBrutas; // ventas totales por semana
    private double tarifaComision; // porcentaje de comisión

    public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
        String numeroSeguroSocial, double ventasBrutas, double tarifaComision)
        {
            //comienza la implementacion del metodo constructor
        super(primerNombre, apellidoPaterno, numeroSeguroSocial); //primero pide esto
            //luego verifica esto
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

        if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
            //si todo va bien, envia los valores a sus atributos de instancia
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

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

    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    // calcula los ingresos; sobrescribe el método abstracto ingresos en Empleado
    @Override
    public double ingresos() {
        return obtenerTarifaComision() * obtenerVentasBrutas();
    }

    // devuelve representación String de un objeto EmpleadoPorComision
    @Override
    public String toString() {
        return String.format("%s: %s: %n %s $%,.2f; %s: %.2f",
                "Empleado por comisión:", super.toString(),
                "Ventas brutas", obtenerVentasBrutas(),
                "Tarifa de comisión", obtenerTarifaComision());
    }
}
// fin de la clase EmpleadoPorComision
