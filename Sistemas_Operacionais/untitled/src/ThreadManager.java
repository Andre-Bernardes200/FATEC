import java.util.Random;

public class ThreadManager {
    private final Thread[] threads; // Array de threads
    private final int n; // Número de threads

    public ThreadManager(int n) {
        this.n = n;
        this.threads = new Thread[n];
    }

    /**
     * Inicializa e inicia todas as threads.
     */
    public void startThreads() {
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int threadId = i + 1;
            int sleepTime = 1000 + random.nextInt(4000); // Tempo aleatório entre 1 e 5 segundos

            // Criando e iniciando a thread com a lógica do Worker
            threads[i] = new Thread(String.valueOf(new Worker(threadId, sleepTime)));
            threads[i].start();
        }
    }

    /**
     * Aguarda a finalização de todas as threads.
     */
    public void waitForThreads() {
        for (int i = 0; i < n; i++) {
            try {
                threads[i].join(); // Espera a thread i finalizar
            } catch (InterruptedException e) {
                System.err.println("Thread principal interrompida enquanto aguardava as threads.");
                System.exit(1); // Código de saída indicando erro
            }
        }
    }

}
