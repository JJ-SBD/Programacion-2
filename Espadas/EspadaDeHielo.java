//herencia desde una superclase
public class EspadaDeHielo extends Espada
{
    private Double poderCongelador;

    public EspadaDeHielo(String nombre, String material, double fuerza, double energia, double sharpness,
            Double poderCongelador) {
        super(nombre, material, fuerza, energia, sharpness);
        this.poderCongelador = poderCongelador;
    }

    //metodo sobreescrito
    @Override
    public void atacar()
    {
        System.out.println("has usado una espada comun");
        double daño = getFuerza() + getSharpness() + poderCongelador * getEnergia();
        System.out.println("El enemigo ha recibido daño de:" + daño  + "pts");
    }
}
