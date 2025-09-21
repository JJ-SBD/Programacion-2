public class PruebaSistemaNomina {
    public static void main(String[] args) {
        // creo objetos de los empleados
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Sue", "Jones", "333-33-3333", 10000, .06);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

        System.out.println("Empleados procesados por separado: ");
        System.out.printf("%n %s %n %s: $%,.2f%n%n", empleadoAsalariado, "ingresos", empleadoAsalariado.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoPorHoras, "ingresos", empleadoPorHoras.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoPorComision, "ingresos", empleadoPorComision.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoBaseMasComision, "ingresos", empleadoBaseMasComision.ingresos());

        // creo un arreglo empleado de cuatro elementos
        Empleado[] empleados = new Empleado[4];

        // inicializa el arreglo con objetos empleado
        empleados[0] = empleadoAsalariado; //esto es un objeto de tipo empleadoAsalariado
        empleados[1] = empleadoPorHoras; //esto es un objeto de tipo empleadoPorHoras
        empleados[2] = empleadoPorComision; //esto es un objeto de tipo empleadoPorComision
        empleados[3] = empleadoBaseMasComision; //esto es un objeto de tipo empleadoBaseMasComision

        //aqui se uso polimorfismo porque estas guardando objetos de diferentes tipos en un arreglo de tipo empleado

        System.out.println("Empleados procesados en forma polimorfica:\n");

        // proceso en forma genérica a cada empleado en el arreglo de empleados
        //for each o for mejorado
        //en cada iteracion imprime a cada empleado guardado en el Array
        for (Empleado empleadoActual : empleados) {
            //cada uno se guarda e imprime en empleadoActual
            System.out.println(empleadoActual); // invoca a toString

            // determina si el elemento es un EmpleadoBaseMasComision
            //me dieron ganas de castear un objeto de tipo empleado a uno de tipo EmpleadoBaseMasCommision
            //es conversion descendente, lo bajo de nivel y se puede hacer cuando el lacayo tenga caracteristicas como las del jefe
            //usamos esta porque EmpleadoBaseMasCommision es la de nivel mas bajo
            if (empleadoActual instanceof EmpleadoBaseMasComision) {
                // conversión descendente de la referencia de Empleado
                // a una referencia de EmpleadoBaseMasComision
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) empleadoActual;
                empleado.establecerSalarioBase(1.10 * empleado.obtenerSalarioBase());
                System.out.printf("El nuevo salario base con 10%% de aumento es: $%, .2f %n", empleado.obtenerSalarioBase());
            } // fin de if
            System.out.printf("ingresos $%,.2f%n%n", empleadoActual.ingresos());
        } // fin de for

        // obtiene el nombre del tipo de cada objeto en el arreglo de empleados
        for (int j = 0; j < empleados.length; j++) {
            //getclass().getName te da el nombre de las clases
            System.out.printf("El empleado %d es un %s%n", j, empleados[j].getClass().getName());
        }
    } // fin de main
} // fin de la clase PruebaSistemaNomina