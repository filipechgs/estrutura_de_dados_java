import java.util.NoSuchElementException;

/**
 * Implementação do TAD Fila utilizando lista encadeada
 * @param <T> Tipo genérico dos elementos da fila
 */
public class FilaEncadeada<T> implements FilaInterface<T> {
    private static class No<T> {
        private T dado;
        private No<T> proximo;
        
        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
    
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;
    
    /**
     * Construtor padrão
     */
    public FilaEncadeada() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
    
    @Override
    public void enqueue(T elemento) {
        No<T> novoNo = new No<>(elemento);
        
        if (isEmpty()) {
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        
        fim = novoNo;
        tamanho++;
    }
    
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        
        T elemento = inicio.dado;
        inicio = inicio.proximo;
        tamanho--;
        
        if (inicio == null) {
            fim = null; // Se a fila ficou vazia, atualiza o fim também
        }
        
        return elemento;
    }
    
    @Override
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return inicio.dado;
    }
    
    @Override
    public boolean isEmpty() {
        return inicio == null;
    }
    
    @Override
    public int size() {
        return tamanho;
    }
    
    @Override
    public void clear() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }
}
