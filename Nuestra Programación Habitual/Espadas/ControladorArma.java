public class ControladorArma
{   
    public static void main(String[] args)
    {
        //creamos objetos para cada clase de forma normal
        Espada espada = new Espada("ChunChunmaru", "Netherite", 4.0, 1.2, 10);
        EspadaDeFuego espadaFuego = new EspadaDeFuego("ChunChunmaru Hellraiser", "Diamante", 4.5, 3.3, 5.0, 20.3);
        EspadaDeHielo espadaHielo = new EspadaDeHielo("ChunChunmaru Blizzard", "Adamantio", 5.0, 2.2, 2.4, 20.5);
        Martillo martillo = new Martillo("Death-Biter", "Acero bañado en Sangre de gigantes", 4.0, 10, 10);
        Martillo martilloTNT = new MartilloExplosivo("Mjölnir", "desconocido", 100.0, 110, 9999, 30.5);
        
        //creamos objetos super clase espada para sus subclases
        Espada espada2 = new Espada("Liquid Metal Sword", "Liquid Slime", 5.0, 1.2, 20.3);
        Espada espada3 = new EspadaDeFuego("Dragovian", "Dragonita", 5.0, 3.5, 3.4, 30.2);
        Espada espada4 = new EspadaDeHielo("Uber Falcon Blade", "Meteorite Bracer", 3.0, 5.5, 3.2, 30.4);
        //creamos objetos super clase martillo para sus subclases
        Martillo martillo2 = new Martillo("Skullbreaker", "Huesos y Arena de almas", 30.4, 40.5, 50.7);
        Martillo martilloTNT2 = new MartilloExplosivo("Sledgehammer", "Acero reforzado", 20.2, 30.4, 70, 40.3);
        

        //Array que guarda objetos de distintos tipos
        Arma [] arsenal = new Arma [10];

        arsenal[0] = espada;
        arsenal[1] = espadaFuego;
        arsenal[2] = espadaHielo;
        arsenal[3] = martillo;
        arsenal[4] = martilloTNT;
        arsenal[5] = espada2;
        arsenal[6] = espada3;
        arsenal[7] = espada4;
        arsenal[8] = martillo2;
        arsenal[9] = martilloTNT2;

        //for each que en cada iteracion impirime cada elemento del array
        for (Arma currentWeapon : arsenal)
        {
            System.out.println(currentWeapon.getNombre());
            //aqui pregunta: ¿el objeto que estas leyendo es de tipo martillo explosivo?
            if (currentWeapon instanceof MartilloExplosivo)
        {   //responde: si, el objeto es un martillo explosivo
            //entonces hacemos algo especial con el objeto, imprimimos su nombre porque se me antojo
            System.out.println(currentWeapon.getNombre());
        }

        }

        for (int i = 0; i < arsenal.length; i++)
        {
            //getclass().getName() te da el nombre de las clases
            //en el %d se imprime el numero de iteracion y en %s el contenido en ese momento del arreglo arsenal %n es un salto de linea
            System.out.printf("%nEl arma en el slot %d se llama %s%n esta hecha de: %s y tiene una fuerza de: %s pts %n",
                                                          i, arsenal[i].getNombre(), arsenal[i].getMaterial(), arsenal[i].getFuerza());
        }
        
}
}
