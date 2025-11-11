

public class EmpleadoPorComision extends Object {
	protected final String primerNombre;
	protected  final String apellidoPaterno;
	protected  final String numeroSeguroSocial;
	protected  double ventasBrutas;
	protected  double tarifaComision;

	public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
	String numeroSeguroSocial, double ventasBrutas, double tarifaComision )
	{
		// llamada implicita al constructor predeterminado Object
		if (ventasBrutas < 0.0)
			throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

		if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
			throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
		
		this.primerNombre = primerNombre;
		this.apellidoPaterno = apellidoPaterno;
		this.numeroSeguroSocial = numeroSeguroSocial;
		this.ventasBrutas = ventasBrutas;
		this.tarifaComision = tarifaComision;
	}

	public String obtenerPrimerNombre()
	{
		return primerNombre;
	}
	public String obtenerApellidoPaterno()
	{
		return apellidoPaterno;
	}
	public String obtenerNumeroSeguroSocial()
	{
		return numeroSeguroSocial;
	}

	public void establecerVentasBrutas(double ventasBrutas){
		if (ventasBrutas < 0.0)
			throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
		this.ventasBrutas = ventasBrutas;
	}
	public void establecerTarifaComision(double tarifaComision){
		if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
			throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
		this.tarifaComision = tarifaComision;
	}

	public double obtenerVentasBrutas()
	{
		return ventasBrutas;
	}
	public double obtenerTarifaComision() {
    	return tarifaComision;
	}
 
  	public double ingresos()
  	{
  		return tarifaComision * ventasBrutas;
  	}

  	@Override
  	public String toString()
  	{
  		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
  			"empleado por comisión", primerNombre, apellidoPaterno, 
  			"numero de seguro social", numeroSeguroSocial, 
  			"ventas brutas", ventasBrutas,
  			"tarifa por comisión", tarifaComision);
  	}
}




















