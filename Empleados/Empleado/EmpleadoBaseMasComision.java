public class EmpleadoBaseMasComision extends EmpleadoPorComision {

    private double salarioBase;

    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno,
        String numeroSeguroSocial, double ventasBrutas,
        double tarifaComision, double salarioBase)
        {
        // todo lo que hay aqui viene de otras clases superiores
        super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
        //hace su validacion
        if (salarioBase < 0.0)
            //esto se usa para indicarle al usuario que la cago xd, si es que lo hace
            //el programa se seguira ejecutando y en algun momento valdra pija
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");

        this.salarioBase = salarioBase;
        }

    public void establecerSalarioBase(double salarioBase) {
        if (salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");

        this.salarioBase = salarioBase;
    }

    public double obtenerSalarioBase() {
        return salarioBase;
    }

    @Override
    public double ingresos() {
        return obtenerSalarioBase() + super.ingresos();//esto llama al metodo ingresos de la superclase, si no lo haces, es recursividad(el metodo se llama a si mismo)
    }

    @Override
    public String toString() {
        return String.format("%s %s: $%,.2f",
                "Con salario base", super.toString(),
                "Salario base", obtenerSalarioBase());
    }
}
