package unicsul.teoriadosgrafos.algoritmos;

import unicsul.teoriadosgrafos.Grafo;
import unicsul.teoriadosgrafos.colecoes.EstruturaDados;
import unicsul.teoriadosgrafos.colecoes.Fila;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuscaEmLargura implements Busca {

    EstruturaDados fila;
    String verticeAtual;
    List<String> processados;
    Set<String> visitados;

    @Override
    public String buscar(Grafo g, String verticeInicial, String verticeFinal) {

        fila = new Fila();
        verticeAtual = null;
        processados = new ArrayList<>();
        visitados = new HashSet<>();

        fila.inserir(verticeInicial);

        while (!fila.estaVazia()) {
            verticeAtual = fila.remover();

            if (!visitados.add(verticeAtual)) continue;

            if (verticeAtual.equals(verticeFinal)) {
                return "Caminho encontrado: " + String.join(" -> ", processados) + " -> " + verticeAtual;
            }

            g.adjacencia.getOrDefault(verticeAtual, List.of())
                    .stream()
                    .filter(v -> !visitados.contains(v))
                    .forEach(fila::inserir);

            processados.add(verticeAtual);
            verticeAtual = null;
        }

        return "Não achado";
    }
}