package unicsul.teoriadosgrafos.colecoes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Pilha implements EstruturaDados {
    private Deque<String> pilha = new ArrayDeque<>();

    @Override
    public void inserir(String item) {
        pilha.push(item);
    }

    @Override
    public void inserirLista(List<String> itens) {
        itens.forEach(pilha::push);
    }

    @Override
    public String remover() {
        return pilha.isEmpty() ? null : pilha.pop();
    }

    @Override
    public String espiar() {
        return pilha.isEmpty() ? null : pilha.peek();
    }

    @Override
    public boolean estaVazia() {
        return pilha.isEmpty();
    }

    @Override
    public int tamanho() {
        return pilha.size();
    }

    public void empilhar(String item) {
        inserir(item);
    }

    public void empilharLista(List<String> itens) {
        inserirLista(itens);
    }

    public String desempilhar() {
        return remover();
    }

    public String topo() {
        return espiar();
    }
}