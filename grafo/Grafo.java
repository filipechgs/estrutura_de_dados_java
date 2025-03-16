/* Implementado com Matriz de Adjacencia */
class Grafo {

    private static final int MAX_VERTICES = 20; // final e static tornam essa variável constante.
    private Vertice[] listaVertice;
    private int[][] matriz;
    private int numVertices;

    public Grafo() {
        listaVertice = new Vertice[MAX_VERTICES];
        matriz = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;

        for (int y = 0; y < MAX_VERTICES; y++) {
            for (int x = 0; x < MAX_VERTICES; x++) {
                matriz[y][x] = 0;  // Corrigido para seguir lógica padrão de linhas e colunas
            }
        }
    }

    public void adicionarVertice(String rotulo) {
        if (numVertices < MAX_VERTICES) {
            listaVertice[numVertices] = new Vertice(rotulo);
            numVertices++;
        } else {
            System.out.println("Erro: Limite máximo de vértices atingido.");
        }
    }

    public void adicionarAresta(int inicio, int fim) {
        if (inicio >= 0 && inicio < numVertices && fim >= 0 && fim < numVertices) {
            matriz[inicio][fim] = 1;
            matriz[fim][inicio] = 1;
        } else {
            System.out.println("Erro: Índices de vértices inválidos para adição de aresta.");
        }
    }

    public void mostrarVertice(int v) {
        if (v >= 0 && v < numVertices) {
            System.out.print(listaVertice[v].getRotulo()); // Exibe sem quebra de linha no console
        } else {
            System.out.println("Erro: Índice de vértice inválido.");
        }
    }

    public void executarDFS() {
        if (numVertices == 0) {
            System.out.println("Erro: Nenhum vértice disponível para busca.");
            return;
        }

        PilhaEncadeada<Integer> pilha = new PilhaEncadeada<>();
        listaVertice[0].marcarComoVisitado();
        mostrarVertice(0);
        pilha.push(0);

        while (!pilha.isEmpty()) {
            int verticeAdjacente = obtemVerticeNaoVisitado(pilha.peek());
            
            if (verticeAdjacente == -1) {
                pilha.pop();
            } else {
                listaVertice[verticeAdjacente].marcarComoVisitado();
                mostrarVertice(verticeAdjacente);
                pilha.push(verticeAdjacente);
            }
        }

        for (int v = 0; v < numVertices; v++) {
            listaVertice[v].marcarComoNaoVisitado();
        }
    }

    private int obtemVerticeNaoVisitado(int vTopoPilha) {
        if (vTopoPilha < 0 || vTopoPilha >= numVertices) {
            return -1;  // Evita erro ao acessar posição inválida
        }

        for (int v = 0; v < numVertices; v++) {
            if (matriz[vTopoPilha][v] == 1 && !listaVertice[v].getVisitado()) {
                return v;
            }
        }
        return -1;
    }
}