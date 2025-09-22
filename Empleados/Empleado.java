// Clase base para todos los empleados
// Se marca como "abstracta" porque no se crean empleados genéricos,
// sino empleados con un tipo específico (asalariado, por horas, etc.)
public abstract class Empleado {
    // Atributos básicos de un empleado
    // Son "final" porque no cambiarán después de asignarse en el constructor.
    private final String primerNombre;
    private final String apellidoPaterno;
    private final String numeroSeguroSocial;

    // Constructor: sirve para inicializar los datos de un empleado
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    // Métodos "getters" para acceder a los datos
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public String obtenerNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    // Representación de texto del empleado.
    // %s = cadena de texto, %n = salto de línea
    @Override
    public String toString() {
        return String.format("%s %s%nnumero de seguro social: %s",
                obtenerPrimerNombre(), obtenerApellidoPaterno(),
                obtenerNumeroSeguroSocial());
    }

    // Método abstracto: aquí solo se "declara", no se implementa.
    // Cada tipo de empleado calculará sus ingresos de manera distinta.
    public abstract double ingresos();
} // fin de la clase Empleado