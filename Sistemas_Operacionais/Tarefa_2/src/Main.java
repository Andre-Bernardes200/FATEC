public class Main {
    public static void main(String[] args) {

        int n = 5; // Número de threads a serem criadas
        ThreadManager threadManager = new ThreadManager(n); // Gerenciador de threads

        // Mensagem inicial informando o início do programa
        System.out.println("Iniciando o programa com " + n + " threads.");

        // Inicializa e começa a execução das threads
        threadManager.startThreads();

        /**
         * Aqui, as threads estão executando simultaneamente.
         * O sistema operacional é responsável por gerenciar e escalonar as threads, permitindo que elas sejam executadas em paralelo (em sistemas multicore)
         * ou alternando entre elas rapidamente em sistemas com um único núcleo.
         * Cada thread pode estar "dormindo" (simulando uma tarefa de longa duração) por um tempo aleatório,
         * mas o sistema operacional lida com a alocação de tempo de CPU para cada uma.
         */

        // Aguarda todas as threads finalizarem
        threadManager.waitForThreads();

        /**
         * O método join() utilizado dentro do waitForThreads() faz com que a função main aguarde
         * a conclusão de todas as threads criadas. Isso é necessário para garantir que o programa
         * não finalize sua execução antes que todas as tarefas paralelas (threads) sejam concluídas.
         * Este é o controle de ordem de execução: a thread principal (main) espera que as outras threads
         * finalizem antes de continuar e encerrar o programa.
         */

        // Mensagem final informando que todas as threads foram concluídas e o programa vai encerrar
        System.out.println("Todas as threads finalizaram. Programa encerrado com sucesso.");

        // Código de saída do sistema indicando que o programa foi encerrado com sucesso
        System.exit(0);

    }
}