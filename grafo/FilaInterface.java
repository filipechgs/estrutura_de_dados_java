/**
 * Interface que define as operações de um TAD Fila
 * @param <T> Tipo genérico dos elementos da fila
 */
public interface FilaInterface<T> {
    /**
     * Insere um elemento no final da fila
     * @param elemento Elemento a ser inserido
     */
    void enqueue(T elemento);
    
    /**
     * Remove e retorna o elemento do início da fila
     * @return O elemento do início da fila
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    T dequeue();
    
    /**
     * Consulta o elemento do início da fila sem removê-lo
     * @return O elemento do início da fila
     * @throws java.util.NoSuchElementException se a fila estiver vazia
     */
    T front();
    
    /**
     * Verifica se a fila está vazia
     * @return true se a fila estiver vazia, false caso contrário
     */
    boolean isEmpty();
    
    /**
     * Retorna o número de elementos na fila
     * @return O tamanho da fila
     */
    int size();
    
    /**
     * Limpa todos os elementos da fila
     */
    void clear();
}
