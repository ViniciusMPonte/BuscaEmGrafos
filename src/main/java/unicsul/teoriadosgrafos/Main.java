package unicsul.teoriadosgrafos;

import unicsul.teoriadosgrafos.algoritmos.Busca;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmLargura;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmProfundidade;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = Grafo.construir();
        Busca[] algoritmos = {
                new BuscaEmLargura(),
                new BuscaEmProfundidade()
        };

        System.out.println("\n\n==== Estrutura do Grafo ====\n");
        grafo.imprimirAdjacencia();

        buscarEImprimir(grafo, algoritmos, "A-0", "G-8");
        buscarEImprimir(grafo, algoritmos, "C-1", "L-4");
        buscarEImprimir(grafo, algoritmos, "B-2", "H-9");
    }

    private static void buscarEImprimir(Grafo grafo, Busca[] algoritmos, String inicio, String fim) {
        System.out.println("\n\n==== Busca do vertice " + inicio + " até " + fim + " ====\n");
        for (Busca algoritmo : algoritmos) {
            algoritmo.medirTempoEImprimir(grafo, inicio, fim);
        }
    }
}