package unicsul.teoriadosgrafos;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = Grafo.construir();
        grafo.imprimirAdjacencia();

        medirTempo(grafo, new BuscaEmLargura(), "A-0", "G-8");
    }

    public static void medirTempo(Grafo grafo, BuscaEmLargura busca, String inicio, String fim) {
        long totalTempo = 0;
        int rodadas = 10;

        for (int i = 0; i < rodadas; i++) {
            busca = new BuscaEmLargura();
            long start = System.nanoTime();
            busca.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\nMédia de " + rodadas + " rodadas: " + (totalTempo / rodadas) / 1000.0 + "µs");
    }
}