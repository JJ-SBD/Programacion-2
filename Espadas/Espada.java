//herencia desde una superclase abstracta
public class Espada extends Arma
{
    private double sharpness;

    public Espada(String nombre, String material, double fuerza, double energia, double sharpness) {
        super(nombre, material, fuerza, energia);
        this.sharpness = sharpness;
    }

    public double getSharpness() {
        return sharpness;
    }

    @Override
    public void atacar()
    {
        System.out.println("has usado una espada comun");
        double daño = getFuerza() + sharpness * getEnergia();
        System.out.println("El enemigo ha recibido daño de:" + daño  + "pts");
    }

}
