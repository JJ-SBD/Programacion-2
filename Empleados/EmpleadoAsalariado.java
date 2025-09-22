// Un empleado que cobra un salario fijo semanal
public class EmpleadoAsalariado extends Empleado {
    private double salarioSemanal;

    // Constructor: inicializa los datos básicos y además el salario
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno,
            String numeroSeguroSocial, double salarioSemanal) {
        // Llamada al constructor de la superclase Empleado
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        // Validación: el salario no puede ser negativo
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    // Setter para cambiar el salario semanal
    public void establecerSalarioSemanal(double salarioSemanal) {
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");
        this.salarioSemanal = salarioSemanal;
    }

    // Getter
    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }

    // Implementación del método abstracto de Empleado
    @Override
    public double ingresos() {
        return obtenerSalarioSemanal();
    }

    // Representación de texto del objeto
    @Override
    public String toString() {
        return String.format("Empleado asalariado: %s%n%s: $%,.2f",
                super.toString(), "salario semanal", obtenerSalarioSemanal());
    }
}