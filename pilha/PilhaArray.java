/**
 * Implementação do TAD Pilha utilizando array
 * @param <T> Tipo genérico dos elementos da pilha
 */
public class PilhaArray<T> implements PilhaInterface<T> {
    private static final int CAPACIDADE_INICIAL = 10;
    private Object[] elementos;
    private int topo;
    
    /**
     * Construtor padrão com capacidade inicial de 10 elementos
     */
    public PilhaArray() {
        this(CAPACIDADE_INICIAL);
    }
    
    /**
     * Construtor com capacidade específica
     * @param capacidade Capacidade inicial da pilha
     */
    public PilhaArray(int capacidade) {
        elementos = new Object[capacidade];
        topo = -1;
    }
    
    @Override
    public void push(T elemento) {
        if (topo == elementos.length - 1) {
            redimensionar();
        }
        elementos[++topo] = elemento;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        T elemento = (T) elementos[topo];
        elementos[topo--] = null; // Para ajudar o garbage collector
        return elemento;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return (T) elementos[topo];
    }
    
    @Override
    public boolean isEmpty() {
        return topo == -1;
    }
    
    @Override
    public int size() {
        return topo + 1;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i <= topo; i++) {
            elementos[i] = null;
        }
        topo = -1;
    }
    
    /**
     * Método privado para redimensionar o array quando estiver cheio
     */
    private void redimensionar() {
        int novaCapacidade = elementos.length * 2;
        Object[] novoArray = new Object[novaCapacidade];
        System.arraycopy(elementos, 0, novoArray, 0, elementos.length);
        elementos = novoArray;
    }
}
