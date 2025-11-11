public class EmpleadoBaseMasComision extends EmpleadoPorComision
{
	private double salarioBase;

	public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, 
		String numeroSeguroSocial, double ventasBrutas, double tarifaComision, 
		double salarioBase)
	{
		// llamada al constructor de la superclase EmpleadoPorComision
		super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);

		if (salarioBase < 0.0)
			throw new IllegalArgumentException ("El salario base debe ser >= 0.0");
		this.salarioBase = salarioBase;
	} 

	public void establecerSalarioBase(double salarioBase)
	{
		if (salarioBase < 0.0)
			throw new IllegalArgumentException ("El salario base debe ser >= 0.0");
		this.salarioBase = salarioBase;
	}

	public double obtenerSalarioBase()
	{
		return salarioBase;
	}

	// modificamos el método sobreescrito ingresos() para tener acceso a la
	// variable de instancia salarioBase mediante el método obtenerSalarioBase() de esta clase
	// y a las variables private tarifaComision y ventasBrutas mediante el método ingresos() de la superclase
	@Override
	public double obtenerMontoPago(){
		return obtenerSalarioBase() + super.ingresos(); // explicar el problema de recursividad infinita,
		// al no poner la palabra clase super.
	}

	// modificamos el método sobreescrito toString() para tener el acceso a la
	// variable de instancia salarioBase mediante el método obtenerSalarioBase() de esta clase
	// y a las variables private de la super clase EmpleadoPorComision 
	// por medio del método toString() de la super clase
	@Override
  	public String toString()
  	{
  		return String.format("%s%n%s%n%s: %.2f", "Con sueldo base",super.toString(), 
  			"salario base", obtenerSalarioBase());
  	}
}
