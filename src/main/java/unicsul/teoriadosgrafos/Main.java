package unicsul.teoriadosgrafos;

import unicsul.teoriadosgrafos.algoritmos.BuscaEmLargura;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmProfundidade;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = Grafo.construir();
        grafo.imprimirAdjacencia();

        medirTempoBFS(grafo, "A-0", "G-8");

        medirTempoDFS(grafo, "A-0", "G-8");
    }

    public static void medirTempoBFS(Grafo grafo, String inicio, String fim) {

        long totalTempo = 0;
        int rodadas = 10;
        String retorno = "";

        for (int i = 0; i < rodadas; i++) {
            BuscaEmLargura bfs = new BuscaEmLargura();

            long start = System.nanoTime();
            retorno = bfs.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\n[BFS] " + retorno + "\nMédia: " + (totalTempo / rodadas) / 1000.0 + " µs");
    }

    public static void medirTempoDFS(Grafo grafo, String inicio, String fim) {

        long totalTempo = 0;
        int rodadas = 10;
        String retorno = "";

        for (int i = 0; i < rodadas; i++) {
            BuscaEmProfundidade dfs = new BuscaEmProfundidade();

            long start = System.nanoTime();
            retorno = dfs.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\n[DFS] " + retorno + "\nMédia: " + (totalTempo / rodadas) / 1000.0 + " µs");
    }
}