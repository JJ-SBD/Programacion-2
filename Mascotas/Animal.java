public class Animal {
    private String nombre;
    private String raza;
    private String color;

    public Animal(String nombre, String raza, String color){
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        //Para que se pone esto exactamente?
    }
    
    //Definimos getter y setter para cada campo
    //(no importa donde vayan pero no seas code-monkey y ponlos luego de los constructores)
    
    public void setNombre(String nombre){
    this.nombre = nombre;
    // Variable de instancia y variable local o parametro de metodo?
    }

    public String getNombre(){
    return nombre;
    }
    

    public void setRaza(String raza){
    this.raza = raza;
    }

    public String getRaza(){
    return raza;
    }

    
    public void setColor(String color){
    this.color = color;
    }

    public String getColor(){
    return color;
    }
}