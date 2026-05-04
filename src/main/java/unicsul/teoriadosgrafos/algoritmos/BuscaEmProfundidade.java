package unicsul.teoriadosgrafos.algoritmos;

import unicsul.teoriadosgrafos.Grafo;
import unicsul.teoriadosgrafos.colecoes.EstruturaDados;
import unicsul.teoriadosgrafos.colecoes.Pilha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuscaEmProfundidade implements Busca {

    EstruturaDados pilha;
    String verticeAtual;
    List<String> processados;
    Set<String> visitados;

    @Override
    public String buscar(Grafo g, String verticeInicial, String verticeFinal) {

        pilha = new Pilha();
        verticeAtual = null;
        processados = new ArrayList<>();
        visitados = new HashSet<>();

        pilha.inserir(verticeInicial);

        while (!pilha.estaVazia()) {
            verticeAtual = pilha.remover();

            if (!visitados.add(verticeAtual)) continue;

            if (verticeAtual.equals(verticeFinal)) {
                return "Caminho encontrado: " + String.join(" -> ", processados) + " -> " + verticeAtual;
            }

            g.adjacencia.getOrDefault(verticeAtual, List.of())
                    .stream()
                    .filter(v -> !visitados.contains(v))
                    .forEach(pilha::inserir);

            processados.add(verticeAtual);
            verticeAtual = null;
        }

        return "Não achado";
    }
}