//herencia desde una superclase
public class EspadaDeFuego extends Espada
{
    private double poderIncinerador;

    public EspadaDeFuego(String nombre, String material, double fuerza, double energia, double sharpness,
            double poderIncinerador) {
        super(nombre, material, fuerza, energia, sharpness);
        this.poderIncinerador = poderIncinerador;
    }

    //metodo sobreescrito
    @Override
    public void atacar()
    {
        System.out.println("has usado una espada comun");
        double daño = getFuerza() + getSharpness() + poderIncinerador * getEnergia();
        System.out.println("El enemigo ha recibido daño de:" + daño  + "pts");
    }
}
