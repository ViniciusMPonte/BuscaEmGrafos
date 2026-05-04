package unicsul.teoriadosgrafos.algoritmos;

import unicsul.teoriadosgrafos.Grafo;

import java.math.BigDecimal;

public interface Busca {
    String buscar(Grafo g, String verticeInicial, String verticeFinal);
    BigDecimal medirTempoEImprimir(Grafo grafo, String inicio, String fim);
}