package unicsul.teoriadosgrafos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BuscaEmProfundidade {

    private Set<String> visitados = new HashSet<>();

    public void buscar(Grafo grafo, String inicio, String fim) {

        visitados.clear(); // importante para não "vazar estado"

        Stack<List<String>> pilha = new Stack<>();
        pilha.push(Arrays.asList(inicio));

        while (!pilha.isEmpty()) {

            List<String> caminho = pilha.pop();
            String atual = caminho.get(caminho.size() - 1);

            if (atual.equals(fim)) {
                System.out.println("Caminho encontrado (DFS): " + caminho);
                return;
            }

            if (!visitados.contains(atual)) {
            visitados.add(atual);
            }  

                List<String> vizinhos = grafo.adjacencia.get(atual);

                if (vizinhos != null) {
                    for (String v : vizinhos) {
                        List<String> novoCaminho = new ArrayList<>(caminho);
                        novoCaminho.add(v);
                        pilha.push(novoCaminho);
                    }
                }
            }
        }
    }
