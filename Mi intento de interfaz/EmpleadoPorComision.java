public class EmpleadoPorComision extends Empleado {

	private double ventasBrutas;
	private double tarifaComision;

	public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
	String numeroSeguroSocial, double ventasBrutas, double tarifaComision )
    
	{
		super(primerNombre, apellidoPaterno, numeroSeguroSocial);

		if (ventasBrutas < 0.0)
			throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");

		if (tarifaComision <= 0.0 || tarifaComision >= 1.0)
			throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
		

		this.ventasBrutas = ventasBrutas;
		this.tarifaComision = tarifaComision;
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
    @Override 	
    public double obtenerMontoPago()
  	{
  		return obtenerTarifaComision() * obtenerVentasBrutas();
  	}




	// aqui se modifica el méto sobreescrito toString() para acceder a las variables
	// de instancia mediante sus métodos accesores
  	@Override
  	public String toString()
  	{
  		return String.format("%s: %s%n%s: %.2f%n%s: %.2f",
  			"empleado por comisión", super.toString(), 
  			"ventas brutas", obtenerVentasBrutas(),
  			"tarifa por comisión", obtenerTarifaComision());
  	}
}
