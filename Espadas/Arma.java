public abstract class Arma
{   
    //encapsulamiento con atributos privados
    public String nombre;
    private String material;
    private double fuerza;
    private double energia;

    
    public Arma(String nombre, String material, double fuerza, double energia)
    {
        this.nombre = nombre;
        this.material = material;
        this.fuerza = fuerza;
        this.energia = energia;
    }
    //metodos get para que no tengamos problemas con los accesos privados
    public String getNombre() {
        return nombre;
    }

    public String getMaterial() {
        return material;
    }

    public double getFuerza() {
        return fuerza;
    }

    public double getEnergia() {
        return energia;
    }

    //metodo abstracto porque todas las armas del multiverso son capaces de atacar
    public abstract void atacar();
}
