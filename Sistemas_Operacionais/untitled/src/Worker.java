public class Worker {

    private final int threadId; // Identificador da thread
    private final int sleepTime; // Tempo que a thread vai "trabalhar"

    public Worker(int threadId, int sleepTime) {
        this.threadId = threadId;
        this.sleepTime = sleepTime;
    }

        public void run() {
        System.out.println("Thread " + threadId + " iniciada. Executando por " + sleepTime + " ms.");
        try {
            // Simula a tarefa que leva sleepTime milissegundos
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.err.println("Thread " + threadId + " foi interrompida.");
            return;
        }
        System.out.println("Thread " + threadId + " finalizada.");
    }
}
