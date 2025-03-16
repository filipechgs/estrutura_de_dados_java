
class ExemploGrafo {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.adicionarVertice("A"); // será índice 0
        g.adicionarVertice("B"); // será índice 1
        g.adicionarVertice("C"); // será índice 2
        g.adicionarVertice("D"); // será índice 3
        g.adicionarVertice("E"); // será índice 4
        g.adicionarVertice("F"); // será índice 5
        g.adicionarVertice("G"); // será índice 6

        // inserção das arestas
        g.adicionarAresta(0, 1); // aresta AB
        g.adicionarAresta(0, 2); // aresta AC
        g.adicionarAresta(0, 3); // aresta AD
        g.adicionarAresta(1, 4); // aresta BE
        g.adicionarAresta(4, 6); // aresta EG
        g.adicionarAresta(2, 5); // aresta CF
        g.adicionarAresta(2, 3); // aresta CD
        
        System.out.print("DFS - Vertices visitados: ");
        g.executarDFS(); // pesquisa em profundidade
        System.out.println();
        System.out.print("BFS - Vertices visitados: ");
        g.executarBFS(); // pesquisa em profundidade

    } // final main
}