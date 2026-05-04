package unicsul.teoriadosgrafos;

import unicsul.teoriadosgrafos.algoritmos.BuscaEmLargura;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmProfundidade;
import unicsul.teoriadosgrafos.algoritmos.Busca;

public class Main {
    public static void main(String[] args) {

        Grafo grafo = Grafo.construir();
        grafo.imprimirAdjacencia();

        medirTempo(grafo, "A-0", "G-8", "BFS", new BuscaEmLargura());
        medirTempo(grafo, "A-0", "G-8", "DFS", new BuscaEmProfundidade());
    }

    public static void medirTempo(Grafo grafo, String inicio, String fim, String label, Busca buscador) {

        long totalTempo = 0;
        int rodadas = 10;
        String retorno = "";

        for (int i = 0; i < rodadas; i++) {
            long start = System.nanoTime();
            retorno = buscador.buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.println("\n[" + label + "] " + retorno + "\nMédia: " + (totalTempo / rodadas) / 1000.0 + " µs");
    }
}