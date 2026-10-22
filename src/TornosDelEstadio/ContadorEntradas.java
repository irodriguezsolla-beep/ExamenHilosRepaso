package TornosDelEstadio;

import java.util.Random;

public class ContadorEntradas extends Thread {
    // static = Variable compartida por TODAS las instancias (Marcador del estadio)
    private static int marcadorEstadio = 0;

    private  Random random = new Random();
    private int entradasPropias; // Guarda solo las entradas generadas por este torno

    public static synchronized void sumarAlMarcador(int cantidad) {

        marcadorEstadio += cantidad;
    }

    public static int getMarcadorEstadio() {

        return marcadorEstadio;
    }

    public ContadorEntradas(int torno) {

        super("Torno-" + torno);
    }

    @Override
    public void run() {
        // Genera entre 500 y 1000 (inclusive)
        this.entradasPropias = random.nextInt(500, 1001);
        System.out.println(getName() + ": " + entradasPropias + " entradas");

        // Suma sus entradas al marcador del estadio
        sumarAlMarcador(entradasPropias);
    }

    public int getEntradasPropias() {
        return entradasPropias;
    }
}