package unicsul.teoriadosgrafos.colecoes;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fila implements EstruturaDados {
    private Queue<String> fila = new LinkedList<>();

    @Override
    public void inserir(String item) {
        fila.add(item);
    }

    @Override
    public void inserirLista(List<String> itens) {
        fila.addAll(itens);
    }

    @Override
    public String remover() {
        return fila.poll();
    }

    @Override
    public String espiar() {
        return fila.peek();
    }

    @Override
    public boolean estaVazia() {
        return fila.isEmpty();
    }

    @Override
    public int tamanho() {
        return fila.size();
    }
}