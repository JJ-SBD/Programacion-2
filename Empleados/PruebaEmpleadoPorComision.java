public class PruebaEmpleadoPorComision {
    public static void main(String[] args) {
        // Crear un empleado por comisión
        EmpleadoPorComision empleado = new EmpleadoPorComision("Antonio", "Dominguez",
                "2222-2222", 10000, 0.6);

        // Imprimir sus datos accediendo con métodos "getters"
        System.out.println("Información del empleado obtenida por los métodos establecer: ");
        System.out.printf("%s %s%n", "El primer nombre es", empleado.obtenerPrimerNombre());
        System.out.printf("%s %s%n", "El apellido paterno es", empleado.obtenerApellidoPaterno());
        System.out.printf("%s %s%n", "El número de seguro social es", empleado.obtenerNumeroSeguroSocial());
        System.out.printf("%s %.2f%n", "Las ventas brutas son", empleado.obtenerVentasBrutas());
        System.out.printf("%s %.2f%n", "La tarifa de comisión es", empleado.obtenerTarifaComision());

        // Cambiamos sus valores
        empleado.establecerVentasBrutas(500);
        empleado.establecerTarifaComision(.1);

        // Imprimir con toString()
        System.out.printf("%n%s%n%n%s%n",
                "Informacion actualizada del empleado, obtenida mediante toString",
                empleado.toString());
    }
}