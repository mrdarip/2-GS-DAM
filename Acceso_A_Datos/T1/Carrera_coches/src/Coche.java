import java.util.Random;

public class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private static final int DISTANCIA_META = 100;
    private static final Random random = new Random();
    private static boolean hayGanador = false;
    static String ganador = null;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < DISTANCIA_META && !hayGanador) {
            // Avanzar el coche por una distancia aleatoria (entre 1 y 10)
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            // Imprimir el progreso del coche
            System.out.println(nombre + " ha avanzado: " + distanciaRecorrida + " unidades.");

            // Simular el tiempo que tarda en avanzar (entre 100 y 500 ms)
            try {
                Thread.sleep(random.nextInt(400) + 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Verificar si este coche ha ganado la carrera
            if (distanciaRecorrida >= DISTANCIA_META && !hayGanador) {
                hayGanador = true;
                ganador = nombre;
                System.out.println(nombre + " ha llegado a la meta y ha ganado la carrera!");
            }
        }
    }
}
