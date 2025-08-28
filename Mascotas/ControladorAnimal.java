public class ControladorAnimal{ 
    //Sobrecarga de constructores
    //Sobrecarga de metodos
    //Herencia
    public static void main(String[] args){
        //Creamos un objeto llamado MiPrimerPescado en la Clase Pez con el cosntructor que tambien se llama Pez
        Pez MiPrimerPescado = new Pez("Gibby","Beta","muy azul","negro");
        
        System.out.println("Nombre del pescado:" + MiPrimerPescado.getNombre());
        System.out.println("Tipo:" + MiPrimerPescado.getRaza());
        System.out.println("Agua:" + MiPrimerPescado.gettipoAgua());
        System.out.println("Color:" + MiPrimerPescado.getColor());

        
        Perro UnoPerriño = new Perro("Hotto Dogu","Mr. Worldwide",10,"cafe");

        System.out.println("Nombre del perro:" + UnoPerriño.getNombre());
        System.out.println("Raza:" + UnoPerriño.getRaza());
        System.out.println("Peso:" + UnoPerriño.getPeso());
        System.out.println("Color:" + UnoPerriño.getColor());
        UnoPerriño.ladrar(); //llama al metodo con el valor que le fue declarado en los atributos
        UnoPerriño.ladrar("Doo"); //llama al metodo con un valor que le estamos escribiendo aqui
    }
}