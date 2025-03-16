/**
 * Interface que define as operações de um TAD Pilha
 * @param <T> Tipo genérico dos elementos da pilha
 */
public interface PilhaInterface<T> {
    /**
     * Insere um elemento no topo da pilha
     * @param elemento Elemento a ser inserido
     */
    void push(T elemento);
    
    /**
     * Remove e retorna o elemento do topo da pilha
     * @return O elemento do topo da pilha
     * @throws EmptyStackException se a pilha estiver vazia
     */
    T pop();
    
    /**
     * Consulta o elemento do topo da pilha sem removê-lo
     * @return O elemento do topo da pilha
     * @throws EmptyStackException se a pilha estiver vazia
     */
    T peek();
    
    /**
     * Verifica se a pilha está vazia
     * @return true se a pilha estiver vazia, false caso contrário
     */
    boolean isEmpty();
    
    /**
     * Retorna o número de elementos na pilha
     * @return O tamanho da pilha
     */
    int size();
    
    /**
     * Limpa todos os elementos da pilha
     */
    void clear();
}
