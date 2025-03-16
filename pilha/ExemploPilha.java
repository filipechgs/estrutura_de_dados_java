
/**
 * Exemplo de uso do TAD Pilha
 */
public class ExemploPilha {

    public static void main(String[] args) {
        // Exemplo com PilhaArray
        System.out.println("=== Exemplo com PilhaArray ===");
        PilhaInterface<Integer> pilhaArray = new PilhaArray<>();

        System.out.println("Pilha vazia? " + pilhaArray.isEmpty());

        // Adicionando elementos
        pilhaArray.push(10);
        pilhaArray.push(20);
        pilhaArray.push(30);

        System.out.println("Tamanho da pilha: " + pilhaArray.size());
        System.out.println("Elemento do topo: " + pilhaArray.peek());

        System.out.println("Removendo elementos:");
        while (!pilhaArray.isEmpty()) {
            System.out.println(pilhaArray.pop());
        }

        // Exemplo com PilhaEncadeada
        System.out.println("\n=== Exemplo com PilhaEncadeada ===");
        PilhaInterface<String> pilhaEncadeada = new PilhaEncadeada<>();

        System.out.println("Pilha vazia? " + pilhaEncadeada.isEmpty());

        // Adicionando elementos
        pilhaEncadeada.push("Java");
        pilhaEncadeada.push("Python");
        pilhaEncadeada.push("C++");

        System.out.println("Tamanho da pilha: " + pilhaEncadeada.size());
        System.out.println("Elemento do topo: " + pilhaEncadeada.peek());

        System.out.println("Removendo elementos:");
        while (!pilhaEncadeada.isEmpty()) {
            System.out.println(pilhaEncadeada.pop());
        }
    }
}
