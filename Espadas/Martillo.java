//herencia desde una superclase abstracta
public class Martillo extends Arma
{
    private double dureza;

    public Martillo(String nombre, String material, double fuerza, double energia, double dureza) {
        super(nombre, material, fuerza, energia);
        this.dureza = dureza;
    }

    public double getDureza() {
        return dureza;
    }

    @Override
    public void atacar()
    {
        System.out.println("has usado un martillo comun");
        double daño = getFuerza() + dureza * getEnergia();
        System.out.println("El enemigo ha recibido daño de:" + daño  + "pts");
    }

}
