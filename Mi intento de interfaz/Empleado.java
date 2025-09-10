// La superclase abstracta Empleado que implementa a PorPagar
public abstract class Empleado implements PorPagar {
    private final String primerNombre;
    private final String apellidoPaterno;
    private final String numeroSeguroSocial;

    // Constructor
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    // Devuelve el primer nombre
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    // Devuelve el apellidoPaterno
    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    // Devuelve el número de seguro social
    public String obtenerNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    // Devuelve representación String de un objeto Empleado
    @Override
    public String toString() {
        return String.format("%s %s%nnumero de seguro social: %s",
                obtenerPrimerNombre(), obtenerApellidoPaterno(),
                obtenerNumeroSeguroSocial());
    }
}
