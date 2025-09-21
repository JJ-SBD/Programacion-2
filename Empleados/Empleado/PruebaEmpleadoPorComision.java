public class PruebaEmpleadoPorComision {
    public static void main(String[] args) {
        EmpleadoPorComision empleado = new EmpleadoPorComision("Antonio", "Dominguez", 
        "2222-2222", 10000, 0.6);
        
        System.out.println("Información del empleado obtenido por los métodos establecer: ");
        System.out.printf("%n%s %s%n", "El primer nombre es", empleado.getPrimerNombre());
        System.out.printf("%s %s%n", "El apellido paterno es", empleado.getApellidoPaterno());
        System.out.printf("%s %s%n", "El numero de seguro social es", 
                empleado.getNumeroSeguroSocial());
        System.out.printf("%s %.2f%n", "Las ventas brutas son", empleado.obtenerVentasBrutas());
        System.out.printf("%s %.2f%n", "La tarifa de comision es:",
        empleado.obtenerTarifaComision());
        
        
        empleado.establecerVentasBrutas(500);
        empleado.establecerTarifaComision(.1);
        
        System.out.printf("%n %s: %n %n %s %n",
        "Información actualizada del empleado, obtenido mediante toString",
                empleado.toString());
    }
}