// Un empleado que cobra por horas trabajadas
// Incluye pago extra (1.5x) si trabaja más de 40 horas
public class EmpleadoPorHoras extends Empleado {
    private double sueldo; // Pago por hora
    private double horas;  // Horas trabajadas a la semana

    // Constructor
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, 
            String numeroSeguroSocial, double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if (sueldo < 0.0)
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");

        if ((horas < 0.0) || (horas > 168.0)) // 168 = número máximo de horas posibles en una semana
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0.0 y <= 168.0");

        this.sueldo = sueldo;
        this.horas = horas;
    }

    // Setters y getters
    public void establecerSueldo(double sueldo) {
        if (sueldo < 0.0)
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");
        this.sueldo = sueldo;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public void establecerHoras(double horas) {
        if ((horas < 0.0) || (horas > 168.0))
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0.0 y <= 168.0");
        this.horas = horas;
    }

    public double obtenerHoras() {
        return horas;
    }

    // Cálculo de ingresos
    // - Si trabaja hasta 40 horas → sueldo normal
    // - Si trabaja más de 40 → las horas extra se pagan a 1.5x
    @Override
    public double ingresos() {
        if (obtenerHoras() <= 40)
            return obtenerSueldo() * obtenerHoras();
        else
            return 40 * obtenerSueldo() + (obtenerHoras() - 40) * obtenerSueldo() * 1.5;
    }

    @Override
    public String toString() {
        return String.format("Empleado por horas: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "sueldo por hora", obtenerSueldo(),
                "horas trabajadas", obtenerHoras());
    }
}