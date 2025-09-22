public class PruebaSistemaNomina {
    public static void main(String[] args) {
        
        // Crear empleados de distintos tipos
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Sue", "Jones", "333-33-3333", 10000, .06);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

        // Imprimir empleados individualmente
        System.out.println("Empleados procesados por separado: ");
        System.out.printf("%s%ningresos: $%,.2f%n%n", empleadoAsalariado, empleadoAsalariado.ingresos());
        System.out.printf("%s%ningresos: $%,.2f%n%n", empleadoPorHoras, empleadoPorHoras.ingresos());
        System.out.printf("%s%ningresos: $%,.2f%n%n", empleadoPorComision, empleadoPorComision.ingresos());
        System.out.printf("%s%ningresos: $%,.2f%n%n", empleadoBaseMasComision, empleadoBaseMasComision.ingresos());

        // Arreglo de empleados → demuestra el POLIMORFISMO
        Empleado[] empleados = new Empleado[4];
        empleados[0] = empleadoAsalariado;
        empleados[1] = empleadoPorHoras;
        empleados[2] = empleadoPorComision;
        empleados[3] = empleadoBaseMasComision;

        System.out.println("Empleados procesados en forma polimorfica:%n%n");

        // Recorremos el arreglo con for-each
        for (Empleado empleadoActual : empleados) {
            System.out.println(empleadoActual); // Llama automáticamente a toString()

            // Si es un empleado base+comisión, se le aumenta el sueldo base 10%
            if (empleadoActual instanceof EmpleadoBaseMasComision) {
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) empleadoActual; // casting
                empleado.establecerSalarioBase(1.10 * empleado.obtenerSalarioBase());
                System.out.printf("El nuevo salario base con 10%% de aumento es: $%,.2f%n",
                        empleado.obtenerSalarioBase());
            }

            // Imprimir ingresos
            System.out.printf("ingresos $%,.2f%n%n", empleadoActual.ingresos());
        }

        // Mostrar el tipo real de cada objeto
        for (int j = 0; j < empleados.length; j++)
            System.out.printf("El empleado %d es un %s%n", j, empleados[j].getClass().getName());
    }
}