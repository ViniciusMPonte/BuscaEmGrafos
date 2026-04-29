package unicsul.teoriadosgrafos;

import java.util.ArrayList;
import java.util.List;

public class BuscaEmLargura {

    Fila fila;
    String verticeAtual;
    List<String> processados = new ArrayList<>();

    public BuscaEmLargura() {
        fila = new Fila();
    }

    public void buscar(Grafo g, String verticeInicial, String verticeFinal) {

        fila.enfileirar(verticeInicial);

        while (!fila.estaVazia()) {
            verticeAtual = fila.desenfileirar();

            if (verticeAtual.equals(verticeFinal)) {
                System.out.println("Caminho encontrado: ");
                System.out.println(String.join(" -> ", processados) + " -> " + verticeAtual);
                return;
            }

            List<String> vizinhos = g.adjacencia.get(verticeAtual);
            if (!vizinhos.isEmpty()) fila.enfileirarLista(vizinhos);

            processados.add(verticeAtual);
            verticeAtual = null;
        }

        System.out.println("Não achado");
    }
}
