public class EmpleadoPorHoras extends Empleado {
    private double sueldo; // sueldo por hora
    private double horas; // horas trabajadas por semana

    // constructor
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno,
        String numeroSeguroSocial, double sueldo, double horas)
        {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);

        if (sueldo < 0.0) // valida sueldo
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");

        if ((horas < 0.0) || (horas > 168.0)) // valida horas
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0.0 y <= 168.0");

        this.sueldo = sueldo;
        this.horas = horas;
        }

    // establece el sueldo
    public void establecerSueldo(double sueldo) {
        if (sueldo < 0.0) // valida sueldo
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");
        this.sueldo = sueldo;
    }

    // devuelve el sueldo
    public double obtenerSueldo() {
        return sueldo;
    }

    // establece las horas trabajadas
    public void establecerHoras(double horas) {
        if ((horas < 0.0) || (horas > 168.0)) // valida horas
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0.0 y <= 168.0");
        this.horas = horas;
    }
    
   // devuelve las horas trabajadas
    public double obtenerHoras()
    {    
        return horas;
    }
    
   // calcula los ingresos; sobrescribe el método abstracto ingresos en Empleado
    @Override
   public double ingresos()
    {  //si el pibe trabajo nomas 40 hrs no tiene extra
       if (obtenerHoras() <= 40)
           return obtenerSueldo() * obtenerHoras();
        else
            return (40 * obtenerSueldo()) + ((obtenerHoras() - 40) * obtenerSueldo() * 1.5);
    }
    
    // devuelve representación String de un objeto EmpleadoPorHoras
    @Override
    public String toString()    {    
        return String.format("Empleado por horas: %s%n%s: $%,.2f; %s: %,.2f",
            super.toString(), "Sueldo por hora", obtenerSueldo(),
            "horas trabajadas", obtenerHoras());
    }
} // fin de la clase EmpleadoPorHoras