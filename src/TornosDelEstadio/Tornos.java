package TornosDelEstadio;

public class Tornos {
    public static void main(String[] args) throws Exception {
        ContadorEntradas[] hilo = new ContadorEntradas[4];

        // 1. Crear e iniciar hilos (i < hilo.length evita el fallo fuera de rango)
        for (int i = 0; i < hilo.length; i++) {
            hilo[i] = new ContadorEntradas(i + 1);
            hilo[i].start();
        }

        // 2. Esperar a que todos los hilos terminen
        for (int i = 0; i < hilo.length; i++) {
            hilo[i].join();
        }

        // 3. Sumar individualmente las entradas que registró cada torno
        int sumaTornos = 0;
        for (ContadorEntradas h : hilo) {
            sumaTornos += h.getEntradasPropias();
        }

        // 4. Mostrar resultados finales
        System.out.println("Marcador del estadio: " + ContadorEntradas.getMarcadorEstadio());
        System.out.println("Suma de los tornos: " + sumaTornos);
    }
}