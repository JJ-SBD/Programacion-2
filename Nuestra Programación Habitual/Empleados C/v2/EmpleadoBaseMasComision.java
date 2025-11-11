public class EmpleadoBaseMasComision extends EmpleadoPorComision
{
	private double salarioBase;

	public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, 
		String numeroSeguroSocial, double ventasBrutas, double tarifaComision, 
		double salarioBase)
	{
		// llamada explícita al constructor de la superclase EmpleadoPorComision
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

	@Override
	public double ingresos(){
		// no está permitido tarifaComision y ventasBrutas son private en la superclase
		return salarioBase + (tarifaComision * ventasBrutas);
	}

	// devuelve representacion String de EmpleadoBaseMasComision
	@Override
  	public String toString()
  	{
  		// no está permitido: intentos por acceder a los miembros private de la superclase
  		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n",
  			"empleado por comisión", primerNombre, apellidoPaterno, 
  			"numero de seguro social", numeroSeguroSocial, 
  			"ventas brutas", ventasBrutas,
  			"tarifa por comisión", tarifaComision,
  			"salario base", salarioBase);
  	}
}