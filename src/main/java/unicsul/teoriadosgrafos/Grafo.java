package unicsul.teoriadosgrafos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private final Map<String, List<String>> adjacencia = new LinkedHashMap<>();

    public void adicionarVertice(String vertice) {
        adjacencia.putIfAbsent(vertice, new ArrayList<>());
    }

    public void adicionarAresta(String origem, String destino) {
        adjacencia.get(origem).add(destino);
        adjacencia.get(destino).add(origem);
    }

    public void imprimirAdjacencia() {
        adjacencia.forEach((v, vizinhos) ->
                System.out.println(v + " -> " + vizinhos)
        );
    }

    public static Grafo construir() {
        Grafo g = new Grafo();

        for (String v : new String[]{"A-0", "B-2", "C-1", "D-3", "E-7", "F-10", "G-8", "H-9", "I-6", "J-5", "L-4"}) {
            g.adicionarVertice(v);
        }

        g.adicionarAresta("A-0", "C-1");
        g.adicionarAresta("A-0", "B-2");
        g.adicionarAresta("C-1", "J-5");
        g.adicionarAresta("C-1", "L-4");
        g.adicionarAresta("B-2", "D-3");
        g.adicionarAresta("D-3", "J-5");
        g.adicionarAresta("D-3", "E-7");
        g.adicionarAresta("J-5", "G-8");
        g.adicionarAresta("J-5", "I-6");
        g.adicionarAresta("L-4", "I-6");
        g.adicionarAresta("I-6", "H-9");
        g.adicionarAresta("H-9", "G-8");
        g.adicionarAresta("H-9", "F-10");
        g.adicionarAresta("G-8", "F-10");
        g.adicionarAresta("E-7", "F-10");

        return g;
    }
}