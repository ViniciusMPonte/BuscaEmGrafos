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
    List<String> processados = new ArrayList<>();
    Set<String> visitados = new HashSet<>();

    public BuscaEmProfundidade() {
        pilha = new Pilha();
    }

    @Override
    public void buscar(Grafo g, String verticeInicial, String verticeFinal) {

        pilha.inserir(verticeInicial);

        while (!pilha.estaVazia()) {
            verticeAtual = pilha.remover();

            if (!visitados.add(verticeAtual)) continue;

            if (verticeAtual.equals(verticeFinal)) {
                System.out.println("Caminho encontrado: ");
                System.out.println(String.join(" -> ", processados) + " -> " + verticeAtual);
                return;
            }

            g.adjacencia.getOrDefault(verticeAtual, List.of())
                    .stream()
                    .filter(v -> !visitados.contains(v))
                    .forEach(pilha::inserir);

            processados.add(verticeAtual);
            verticeAtual = null;
        }

        System.out.println("Não achado");
    }
}