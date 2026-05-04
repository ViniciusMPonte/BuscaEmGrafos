package unicsul.teoriadosgrafos;

import unicsul.teoriadosgrafos.colecoes.EstruturaDados;
import unicsul.teoriadosgrafos.colecoes.Fila;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuscaEmLargura implements Busca {

    EstruturaDados fila;
    String verticeAtual;
    List<String> processados = new ArrayList<>();
    Set<String> visitados = new HashSet<>();

    public BuscaEmLargura() {
        fila = new Fila();
    }

    @Override
    public void buscar(Grafo g, String verticeInicial, String verticeFinal) {

        fila.inserir(verticeInicial);

        while (!fila.estaVazia()) {
            verticeAtual = fila.remover();

            if (!visitados.add(verticeAtual)) continue;

            if (verticeAtual.equals(verticeFinal)) {
                System.out.println("Caminho encontrado: ");
                System.out.println(String.join(" -> ", processados) + " -> " + verticeAtual);
                return;
            }

            g.adjacencia.getOrDefault(verticeAtual, List.of())
                    .stream()
                    .filter(v -> !visitados.contains(v))
                    .forEach(fila::inserir);

            processados.add(verticeAtual);
            verticeAtual = null;
        }

        System.out.println("Não achado");
    }
}