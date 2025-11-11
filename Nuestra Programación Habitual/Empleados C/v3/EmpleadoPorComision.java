

public class EmpleadoPorComision extends Object {
	private final String primerNombre;
	private final String apellidoPaterno;
	private final String numeroSeguroSocial;
	private double ventasBrutas;
	private double tarifaComision;

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
 
 // aqui se modifica el método ingresos para acceder a las variables de instancia
 // tarifaComision y ventasBrutas mediante sus métodos accesores 
  	public double ingresos()
  	{
  		return obtenerTarifaComision() * obtenerVentasBrutas();
  	}

	// aqui se modifica el méto sobreescrito toString() para acceder a las variables
	// de instancia mediante sus métodos accesores
  	@Override
  	public String toString()
  	{
  		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
  			"empleado por comisión", obtenerPrimerNombre(), obtenerApellidoPaterno(), 
  			"numero de seguro social", obtenerNumeroSeguroSocial(), 
  			"ventas brutas", obtenerVentasBrutas(),
  			"tarifa por comisión", obtenerTarifaComision());
  	}
}
