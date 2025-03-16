/**
 * Implementação do TAD Pilha utilizando lista encadeada
 * @param <T> Tipo genérico dos elementos da pilha
 */
public class PilhaEncadeada<T> implements PilhaInterface<T> {
    private static class No<T> {
        private T dado;
        private No<T> proximo;
        
        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }
    
    private No<T> topo;
    private int tamanho;
    
    /**
     * Construtor padrão
     */
    public PilhaEncadeada() {
        topo = null;
        tamanho = 0;
    }
    
    @Override
    public void push(T elemento) {
        No<T> novoNo = new No<>(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }
    
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        T elemento = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return elemento;
    }
    
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return topo.dado;
    }
    
    @Override
    public boolean isEmpty() {
        return topo == null;
    }
    
    @Override
    public int size() {
        return tamanho;
    }
    
    @Override
    public void clear() {
        topo = null;
        tamanho = 0;
    }
}
