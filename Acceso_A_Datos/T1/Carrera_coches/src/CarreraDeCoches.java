class CarreraDeCoches {
    public static void main(String[] args) {
        // Crear varios coches
        Thread[] coches = new Thread[5];
        for (int i = 0; i < coches.length; i++) {
            Coche coche = new Coche("Coche " + (i + 1));
            coches[i] = new Thread(coche);
            coches[i].start();
        }

        // Esperar a que todos los coches terminen
        for (Thread coche : coches) {
            try {
                coche.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Anunciar el ganador
        if (Coche.ganador != null) {
            System.out.println("¡El ganador de la carrera es: " + Coche.ganador + "!");
        }
    }
}
