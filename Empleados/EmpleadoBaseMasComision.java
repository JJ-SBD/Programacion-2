// Es un empleado que cobra un salario fijo (base) más comisiones
public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;

    // Constructor
    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno,
            String numeroSeguroSocial, double ventasBrutas, double tarifaComision,
            double salarioBase) {
        // Reutiliza el constructor de EmpleadoPorComision
        super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);

        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        this.salarioBase = salarioBase;
    }

    // Setter con validación
    public void establecerSalarioBase(double salarioBase) {
        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        this.salarioBase = salarioBase;
    }

    // Getter
    public double obtenerSalarioBase() {
        return salarioBase;
    }

    // Ingresos = salario base + comisión
    @Override
    public double ingresos() {
        return obtenerSalarioBase() + super.ingresos();
    }

    // Representación de texto
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "Con salario base", super.toString(),
                "salario base", obtenerSalarioBase());
    }
}