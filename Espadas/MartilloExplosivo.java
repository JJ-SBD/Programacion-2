public class MartilloExplosivo extends Martillo
{
    private double poderExplosivo;

    public MartilloExplosivo(String nombre, String material, double fuerza, double energia, double dureza,
            double poderExplosivo) {
        super(nombre, material, fuerza, energia, dureza);
        this.poderExplosivo = poderExplosivo;
    }

    @Override
    public void atacar()
    {
        System.out.println("has usado un martillo explosivo");
        double daño = getFuerza() + getDureza() + poderExplosivo * getEnergia();
        System.out.println("El enemigo ha recibido daño de:" + daño  + "pts");
    }
}
