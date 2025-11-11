import java.io.Serializable;

public class Persona implements Serializable {
    
    private String nombre;
    private int edad;
    private  String direccion;
    String nacionalidad;
    double salario;

    public Persona(String nombre, int edad, String direccion, String nacionalidad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}