import java.util.NoSuchElementException;

/**
 * Implementação do TAD Fila utilizando array circular
 * @param <T> Tipo genérico dos elementos da fila
 */
public class FilaArray<T> implements FilaInterface<T> {
    private static final int CAPACIDADE_INICIAL = 10;
    private Object[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;
    
    /**
     * Construtor padrão com capacidade inicial de 10 elementos
     */
    public FilaArray() {
        this(CAPACIDADE_INICIAL);
    }
    
    /**
     * Construtor com capacidade específica
     * @param capacidade Capacidade inicial da fila
     */
    public FilaArray(int capacidade) {
        elementos = new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }
    
    @Override
    public void enqueue(T elemento) {
        if (tamanho == elementos.length) {
            redimensionar();
        }
        elementos[fim] = elemento;
        fim = (fim + 1) % elementos.length;
        tamanho++;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        T elemento = (T) elementos[inicio];
        elementos[inicio] = null; // Para ajudar o garbage collector
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return elemento;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return (T) elementos[inicio];
    }
    
    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }
    
    @Override
    public int size() {
        return tamanho;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = null;
        }
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }
    
    /**
     * Método privado para redimensionar o array quando estiver cheio
     */
    private void redimensionar() {
        int novaCapacidade = elementos.length * 2;
        Object[] novoArray = new Object[novaCapacidade];
        
        // Copia os elementos para o novo array, reorganizando a fila
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[(inicio + i) % elementos.length];
        }
        
        elementos = novoArray;
        inicio = 0;
        fim = tamanho;
    }
}
