package unicsul.teoriadosgrafos.algoritmos;

import unicsul.teoriadosgrafos.Grafo;
import unicsul.teoriadosgrafos.colecoes.EstruturaDados;
import unicsul.teoriadosgrafos.colecoes.Fila;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuscaEmLargura implements Busca {

    @Override
    public String buscar(Grafo g, String verticeInicial, String verticeFinal) {

        EstruturaDados fila = new Fila();
        List<String> processados = new ArrayList<>();
        Set<String> visitados = new HashSet<>();

        fila.inserir(verticeInicial);

        while (!fila.estaVazia()) {
            String verticeAtual = fila.remover();

            if (!visitados.add(verticeAtual)) continue;

            if (verticeAtual.equals(verticeFinal)) {
                return "Caminho encontrado: " + String.join(" -> ", processados) + " -> " + verticeAtual;
            }

            g.adjacencia.getOrDefault(verticeAtual, List.of())
                    .stream()
                    .filter(v -> !visitados.contains(v))
                    .forEach(fila::inserir);

            processados.add(verticeAtual);
        }

        return "Não achado";
    }

    @Override
    public void medirTempoEImprimir(Grafo grafo, String inicio, String fim) {

        long totalTempo = 0;
        int rodadas = 10;
        String retorno = "";

        for (int i = 0; i < rodadas; i++) {
            long start = System.nanoTime();
            retorno = buscar(grafo, inicio, fim);
            totalTempo += System.nanoTime() - start;
        }

        System.out.print("[BFS] " + retorno + "\nMédia: " + (totalTempo / rodadas) / 1000.0 + " µs\n\n");
    }
}