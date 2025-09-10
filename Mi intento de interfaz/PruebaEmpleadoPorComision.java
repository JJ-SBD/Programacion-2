public class PruebaEmpleadoPorComision {

    public static void main(String[] args) {

        EmpleadoPorComision empleado = new EmpleadoPorComision("Antonio", "Dominguez",
            "222-22-2222", 10000, 0.06);

        System.out.println("Información del empleado obtenida por los métodos establecer:");
        System.out.printf("%nEl primer nombre es %s%n", empleado.obtenerPrimerNombre());
        System.out.printf("El apellido paterno es %s%n", empleado.obtenerApellidoPaterno());
        System.out.printf("El número de seguro social es %s%n", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("Las ventas brutas son %.2f%n", empleado.obtenerVentasBrutas());
        System.out.printf("La tarifa de comisión es %.2f%n", empleado.obtenerTarifaComision());

        empleado.establecerVentasBrutas(5000);
        empleado.establecerTarifaComision(0.1);

        System.out.printf("%n%s:%n%n", "Información actualizada del empleado, obtenida mediante toString");
        System.out.println(empleado.toString());
    }
}