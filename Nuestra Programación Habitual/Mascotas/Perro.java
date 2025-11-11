public class Perro extends Animal{ //clase de tipo objeto actividad de diapositivas 59 en adelante
   // declaracion de atributos, variables de clase, campos de instancia
    
    private double peso;
    private String ladrido = "Woof";

    public Perro(String nombre, String raza, double peso, String color){
        super(nombre, raza, color);
        this.peso = peso;
    }

    // segundo metodo constructor sobrecargado
    public Perro(String nombre, String raza, double peso, String color, String ladrido){
        super(nombre, raza, color);
        this.peso = peso;
        this.ladrido = ladrido;
    }

    // metodo set
    public void setPeso(double peso){
        this.peso = peso;
    }
    

    // metodo get
    public double getPeso(){
        return peso;
    }

    //metodo funcional ladrido 
    public void ladrar(){
        System.out.println(ladrido);
    }

    //metodo funcional sobrecargado
    public void ladrar(String ladrido){
        System.out.println(ladrido);
    }
}
