// la clase concreta EmpleadoAsalariado extiende a la clase abstracta Empleado
public class EmpleadoAsalariado extends Empleado {
    private double salarioSemanal;

    // constructor
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno,
        String numeroSeguroSocial, double salarioSemanal) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
    //hace sus validaciones
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    public void establecerSalarioSemanal(double salarioSemanal) {
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    public double obtenerSalarioSemanal() {
        return salarioSemanal;
    }

    @Override
    public double ingresos() {
        return obtenerSalarioSemanal();
    }

    @Override
    public String toString() {
        return String.format("Empleado asalariado: %s%n%s: $%,.2f",
                super.toString(), "Salario semanal", obtenerSalarioSemanal());
    }
}
// fin de la clase EmpleadoAsalariado
