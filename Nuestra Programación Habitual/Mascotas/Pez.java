public class Pez extends Animal{
    private String tipoAgua;

    public Pez(String nombre, String raza, String tipoAgua, String color){
        super(nombre, raza, color);
        this.tipoAgua = tipoAgua;
    }
    public void setTipoAgua(String tipoAgua){
    this.tipoAgua = tipoAgua;
    }

    public String gettipoAgua(){
    return tipoAgua;
    }
}