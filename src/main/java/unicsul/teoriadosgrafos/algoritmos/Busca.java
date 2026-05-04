package unicsul.teoriadosgrafos.algoritmos;

import unicsul.teoriadosgrafos.Grafo;

public interface Busca {
    String buscar(Grafo g, String verticeInicial, String verticeFinal);
    void medirTempoEImprimir(Grafo grafo, String inicio, String fim);
}