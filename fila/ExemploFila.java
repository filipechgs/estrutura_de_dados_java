/**
 * Exemplo de uso do TAD Fila
 */
public class ExemploFila {
    public static void main(String[] args) {
        System.out.println("=== Exemplo com FilaArray ===");
        FilaInterface<Integer> filaArray = new FilaArray<>();
        
        System.out.println("Fila vazia? " + filaArray.isEmpty());
        System.out.println("Adicionando elementos...");

        filaArray.enqueue(10);
        filaArray.enqueue(20);
        filaArray.enqueue(30);

        System.out.println("Tamanho da fila: " + filaArray.size());
        System.out.println("Elemento da frente: " + filaArray.front());
        
        System.out.println("Removendo elementos:");
        while (!filaArray.isEmpty()) {
            System.out.println(filaArray.dequeue());
        }
        
        System.out.println("\n=== Exemplo com FilaEncadeada ===");
        FilaInterface<String> filaEncadeada = new FilaEncadeada<>();
        
        System.out.println("Fila vazia? " + filaEncadeada.isEmpty());
        System.out.println("Adicionando elementos...");
        
        filaEncadeada.enqueue("Primeiro Elemento");
        filaEncadeada.enqueue("Segundo Elemento");
        filaEncadeada.enqueue("Terceiro Elemento");
        
        System.out.println("Tamanho da fila: " + filaEncadeada.size());
        System.out.println("Elemento da frente: " + filaEncadeada.front());
        
        System.out.println("Removendo elementos:");
        while (!filaEncadeada.isEmpty()) {
            System.out.println(filaEncadeada.dequeue());
        }
    }
}
