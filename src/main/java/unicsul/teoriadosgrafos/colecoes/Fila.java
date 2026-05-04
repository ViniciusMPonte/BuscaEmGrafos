package unicsul.teoriadosgrafos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Fila {
    private Queue<String> fila = new LinkedList<>();


    public void enfileirar(String item) {
        fila.add(item);
    }

    public void enfileirarLista(List<String> itens) {
        fila.addAll(itens);
    }

    public String desenfileirar() {
        return fila.poll();
    }

    public String frente() {
        return fila.peek();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }
}