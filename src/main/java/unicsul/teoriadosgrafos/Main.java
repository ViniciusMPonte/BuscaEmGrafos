package unicsul.teoriadosgrafos;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = Grafo.construir();
        grafo.imprimirAdjacencia();

        medirTempoBFS(grafo, "A", "G");

        medirTempoDFS(grafo, "A", "G");
    }

    public static void medirTempoBFS(Grafo grafo, String inicio, String fim) {

        long totalTempo = 0;
        int rodadas = 10;

        for (int i = 0; i < rodadas; i++) {
            BuscaEmLargura bfs = new BuscaEmLargura();

            long start = System.nanoTime();
            bfs.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\n[BFS] Média: " +
                (totalTempo / rodadas) / 1000.0 + " µs");
    }

    public static void medirTempoDFS(Grafo grafo, String inicio, String fim) {

        long totalTempo = 0;
        int rodadas = 10;

        for (int i = 0; i < rodadas; i++) {
            BuscaEmProfundidade dfs = new BuscaEmProfundidade();

            long start = System.nanoTime();
            dfs.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\n[DFS] Média: " +
                (totalTempo / rodadas) / 1000.0 + " µs");
    }
}