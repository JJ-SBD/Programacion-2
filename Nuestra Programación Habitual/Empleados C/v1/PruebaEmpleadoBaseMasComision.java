// PruebaEmpleadoBaseMasComision.java
// Programa de prueba de EmpleadoBaseMasComision

public class PruebaEmpleadoBaseMasComision
{
	public static void main(String[] args)
	{
		// crea instancia de objeto EmpleadoBaseMasComision
		EmpleadoBaseMasComision empleado = 
		new EmpleadoBaseMasComision(
			"Mary", "Benitez", "333-33-3333", 5000, .04, 300);

		// obtiene datos del empleado por comisión con sueldo base
		System.out.println(
			"Información del empleado obtenida por métodos establecer: %n");
		System.out.printf("%s %s%n", "El primer nombre es", 
			empleado.obtenerPrimerNombre());
		System.out.printf("%s %s%n", "El apellido es", 
			empleado.obtenerApellidoPaterno());
		System.out.printf("%s %s%n", "El número de seguro social es", 
			empleado.obtenerNumeroSeguroSocial());
		System.out.printf("%s %.2f%n", "Las ventas brutas fueron", 
			empleado.obtenerVentasBrutas());
		System.out.printf("%s %.2f%n", "La tarifa de comisión es", 
			empleado.obtenerTarifaComision());
		System.out.printf("%s %.2f%n", "El salario base es", 
			empleado.obtenerSalarioBase());

		empleado.establecerSalarioBase(1000);

		System.out.printf("%n%s:%n%n%s%n", 
			"Información actualizada del empleado, obtenida por toString",
			empleado.toString());
	} // fin de main
} // Fin de la clase PruebaEmpleadoBaseMasComision
