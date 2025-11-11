// la clase EmpleadoAsalariado que implementa la interfaz PorPagar.
// método obtenerMontoPago

public class EmpleadoAsalariado extends Empleado
{
    private double salarioSemanal;

    // constructor
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno,
        String numeroSeguroSocial, double salarioSemanal)
    {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException(
                "El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    // establece el salario
    public void establecerSalarioSemanal(double salarioSemanal)
    {
        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException(
                "El salario semanal debe ser >= 0.0");

        this.salarioSemanal = salarioSemanal;
    }

    // devuelve el salario
    public double obtenerSalarioSemanal()
    {
        return salarioSemanal;
    }

    // calcula los ingresos; implementa el método de la interfaz PorPagar
    // que era abstracto en la superclase Empleado
    @Override
    public double obtenerMontoPago()
    {
        return obtenerSalarioSemanal();
    }

    // devuelve representación String de un objeto EmpleadoAsalariado
    @Override
    public String toString()
    {
        return String.format("Empleado asalariado: %s%n%s: $%,.2f",
            super.toString(), "salario semanal", obtenerSalarioSemanal());
    }
}//fin de la clase empleado asalariado
