// La clase EmpleadoAsalariado que implementa la interfaz PorPagar
public class EmpleadoAsalariado extends Empleado {
    private double salarioSemanal;

    // Constructor
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno,
                              String numeroSeguroSocial, double salarioSemanal) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    // Establece el salario
    public void establecerSalarioSemanal(double salarioSemanal) {
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    // Devuelve el salario
    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }

    // Calcula los ingresos; implementa el método de la interfaz PorPagar
    @Override
    public double obtenerMontoPago() {
        return obtenerSalarioSemanal();
    }

    // Devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString() {
        return String.format("Empleado asalariado: %s%n%s: $%,.2f",
                super.toString(), "salario semanal", obtenerSalarioSemanal());
    }
}
