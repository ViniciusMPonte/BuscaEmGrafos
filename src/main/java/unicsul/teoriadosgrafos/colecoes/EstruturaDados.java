package unicsul.teoriadosgrafos.colecoes;

import java.util.List;

public interface EstruturaDados {
    void inserir(String item);
    void inserirLista(List<String> itens);
    String remover();
    String espiar();
    boolean estaVazia();
    int tamanho();
}