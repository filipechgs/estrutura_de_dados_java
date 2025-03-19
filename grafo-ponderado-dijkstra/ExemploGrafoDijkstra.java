/**
 * ExemploGrafoDijkstra - Classe para demonstrar o uso do algoritmo de Dijkstra
 * Demonstra a criação de um grafo, adição de vértices e arestas, e
 * execução do algoritmo para encontrar caminhos mais curtos.
 */
public class ExemploGrafoDijkstra {
    public static void main(String[] args) {
        // Cria um novo grafo
        Grafo grafo = new Grafo();
        
        // Adiciona vértices ao grafo
        grafo.adicionaVertice("A");  // índice 0
        grafo.adicionaVertice("B");  // índice 1
        grafo.adicionaVertice("C");  // índice 2
        grafo.adicionaVertice("D");  // índice 3
        grafo.adicionaVertice("E");  // índice 4
        grafo.adicionaVertice("F");  // índice 5
        
        // Adiciona arestas direcionadas com seus pesos
        // De A para outros vértices
        grafo.adicionaAresta(0, 1, 6);    // A -> B, peso 6
        grafo.adicionaAresta(0, 3, 1);    // A -> D, peso 1
        
        // De B para outros vértices
        grafo.adicionaAresta(1, 2, 5);    // B -> C, peso 5
        grafo.adicionaAresta(1, 3, 2);    // B -> D, peso 2
        grafo.adicionaAresta(1, 4, 2);    // B -> E, peso 2
        
        // De C para outros vértices
        grafo.adicionaAresta(2, 4, 5);    // C -> E, peso 5
        
        // De D para outros vértices
        grafo.adicionaAresta(3, 1, 2);    // D -> B, peso 2
        grafo.adicionaAresta(3, 4, 1);    // D -> E, peso 1
        grafo.adicionaAresta(3, 5, 4);    // D -> F, peso 4
        
        // De E para outros vértices
        grafo.adicionaAresta(4, 2, 5);    // E -> C, peso 5
        grafo.adicionaAresta(4, 5, 3);    // E -> F, peso 3
        
        // Exibe a estrutura do grafo
        System.out.println("\n=== Estrutura do Grafo ===");
        grafo.mostraMatriz();
        
        // Executa o algoritmo de Dijkstra a partir do vértice A (índice 0)
        System.out.println("\n=== Algoritmo de Dijkstra a partir de A ===");
        grafo.caminhoMaisCurto(0);
        
        // Exemplo de como encontrar caminhos específicos
        System.out.println("\n=== Consultando caminhos específicos ===");
        // Encontra o caminho mais curto de A para F
        System.out.println("Caminho de A para F:");
        grafo.mostrarCaminho(0, 5);
        
        // Executa o algoritmo a partir de outro vértice, por exemplo, B (índice 1)
        System.out.println("\n=== Algoritmo de Dijkstra a partir de B ===");
        grafo.caminhoMaisCurto(1);
        
        // Exemplo com outro grafo - um pouco mais complexo
        System.out.println("\n\n========== OUTRO EXEMPLO ==========");
        Grafo grafo2 = new Grafo();
        
        // Adiciona vértices representando cidades
        grafo2.adicionaVertice("São Paulo");      // 0
        grafo2.adicionaVertice("Rio de Janeiro"); // 1
        grafo2.adicionaVertice("Belo Horizonte"); // 2
        grafo2.adicionaVertice("Brasília");       // 3
        grafo2.adicionaVertice("Salvador");       // 4
        grafo2.adicionaVertice("Curitiba");       // 5
        grafo2.adicionaVertice("Porto Alegre");   // 6
        
        // Adiciona arestas com distâncias em km (aproximadas)
        // São Paulo para outras cidades
        grafo2.adicionaAresta(0, 1, 430);  // São Paulo -> Rio
        grafo2.adicionaAresta(0, 2, 590);  // São Paulo -> BH
        grafo2.adicionaAresta(0, 3, 1010); // São Paulo -> Brasília
        grafo2.adicionaAresta(0, 5, 410);  // São Paulo -> Curitiba
        
        // Rio de Janeiro para outras cidades
        grafo2.adicionaAresta(1, 0, 430);  // Rio -> São Paulo
        grafo2.adicionaAresta(1, 2, 440);  // Rio -> BH
        grafo2.adicionaAresta(1, 4, 1650); // Rio -> Salvador
        
        // Belo Horizonte para outras cidades
        grafo2.adicionaAresta(2, 0, 590);  // BH -> São Paulo
        grafo2.adicionaAresta(2, 1, 440);  // BH -> Rio
        grafo2.adicionaAresta(2, 3, 740);  // BH -> Brasília
        grafo2.adicionaAresta(2, 4, 1370); // BH -> Salvador
        
        // Brasília para outras cidades
        grafo2.adicionaAresta(3, 0, 1010); // Brasília -> São Paulo
        grafo2.adicionaAresta(3, 2, 740);  // Brasília -> BH
        grafo2.adicionaAresta(3, 4, 1170); // Brasília -> Salvador
        
        // Salvador para outras cidades
        grafo2.adicionaAresta(4, 1, 1650); // Salvador -> Rio
        grafo2.adicionaAresta(4, 2, 1370); // Salvador -> BH
        grafo2.adicionaAresta(4, 3, 1170); // Salvador -> Brasília
        
        // Curitiba para outras cidades
        grafo2.adicionaAresta(5, 0, 410);  // Curitiba -> São Paulo
        grafo2.adicionaAresta(5, 6, 710);  // Curitiba -> Porto Alegre
        
        // Porto Alegre para outras cidades
        grafo2.adicionaAresta(6, 5, 710);  // Porto Alegre -> Curitiba
        
        // Exibe a estrutura do grafo
        System.out.println("\n=== Estrutura do Grafo de Cidades ===");
        grafo2.mostraMatriz();
        
        // Encontra caminhos mais curtos a partir de São Paulo
        System.out.println("\n=== Caminhos mais curtos a partir de São Paulo ===");
        grafo2.caminhoMaisCurto(0);
        
        // Encontra caminhos mais curtos a partir de Porto Alegre
        System.out.println("\n=== Caminhos mais curtos a partir de Porto Alegre ===");
        grafo2.caminhoMaisCurto(6);
    }
}
