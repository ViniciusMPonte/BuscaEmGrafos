package unicsul.teoriadosgrafos;

import unicsul.teoriadosgrafos.algoritmos.Busca;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmLargura;
import unicsul.teoriadosgrafos.algoritmos.BuscaEmProfundidade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = Grafo.construir();
        Busca[] algoritmos = {
                new BuscaEmLargura(),
                new BuscaEmProfundidade()
        };

        Map<Busca, BigDecimal> totais = new HashMap<>();
        for (Busca algoritmo : algoritmos) totais.put(algoritmo, BigDecimal.ZERO);

        System.out.println("\n\n==== Estrutura do Grafo ====\n");
        grafo.imprimirAdjacencia();

        buscarEImprimir(grafo, algoritmos, totais, "A-0", "G-8");
        buscarEImprimir(grafo, algoritmos, totais, "C-1", "L-4");
        buscarEImprimir(grafo, algoritmos, totais, "B-2", "H-9");

        imprimirResultadoFinal(totais);
    }

    private static void buscarEImprimir(Grafo grafo, Busca[] algoritmos, Map<Busca, BigDecimal> totais, String inicio, String fim) {
        System.out.println("\n\n==== Busca do vertice " + inicio + " até " + fim + " ====\n");
        for (Busca algoritmo : algoritmos) {
            BigDecimal media = algoritmo.medirTempoEImprimir(grafo, inicio, fim);
            totais.merge(algoritmo, media, BigDecimal::add);
        }
    }

    private static void imprimirResultadoFinal(Map<Busca, BigDecimal> totais) {
        System.out.println("\n\n==== Resultado Final ====\n");
        Busca vencedor = totais.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get().getKey();

        for (Map.Entry<Busca, BigDecimal> entry : totais.entrySet()) {
            String nome = entry.getKey().getClass().getSimpleName();
            String destaque = entry.getKey() == vencedor ? " <<< mais rápido" : "";
            System.out.println(nome + ": " + entry.getValue() + " µs" + destaque);
        }
    }
}