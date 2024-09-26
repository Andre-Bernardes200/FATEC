public class Main {
    public static void main(String[] args) {

        int n = 10000; // Número de threads a serem criadas
        ThreadManager threadManager = new ThreadManager(n); // Gerenciador de threads

        System.out.println("Iniciando o programa com " + n + " threads.");

        // Inicializa e começa a execução das threads
        threadManager.startThreads();

        // Aguarda todas as threads finalizarem
        threadManager.waitForThreads();

        System.out.println("Todas as threads finalizaram. Programa encerrado com sucesso.");
        System.exit(0); // Código de saída indicando sucesso

    }
}