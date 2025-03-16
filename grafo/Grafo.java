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

    public void executarDFS() { // deep-first search
        if (numVertices == 0) {
            System.out.println("Erro: Nenhum vértice disponível para busca.");
            return;
        }

        PilhaEncadeada<Integer> pilha = new PilhaEncadeada<>();
        listaVertice[0].marcarComoVisitado();
        mostrarVertice(0);
        pilha.push(0);

        while (!pilha.isEmpty()) {
            int verticeAdjacente = obterVerticeNaoVisitado(pilha.peek());

            if (verticeAdjacente == -1) {
                pilha.pop();
            } else {
                listaVertice[verticeAdjacente].marcarComoVisitado();
                mostrarVertice(verticeAdjacente);
                pilha.push(verticeAdjacente);
            }
        }
        // Reseta as marcações dos vetices
        for (int v = 0; v < numVertices; v++) {
            listaVertice[v].marcarComoNaoVisitado();
        }
    }

    private int obterVerticeNaoVisitado(int vTopoPilha) {
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

    public void executarBFS() { // breadth-first search
        if (numVertices == 0) {
            System.out.println("Erro: Nenhum vértice disponível para busca.");
            return;
        }

        FilaArray<Integer> fila = new FilaArray<>();
        listaVertice[0].marcarComoVisitado();
        mostrarVertice(0);
        fila.enqueue(0);
        int vertice2;

        // Desenfilera os elementos até que a fila esteja vazia
        while (!fila.isEmpty()) { 
            int vertice1 = fila.dequeue();

            while ((vertice2 = obterVerticeNaoVisitado(vertice1)) != -1) { 
                listaVertice[vertice2].marcarComoVisitado();
                mostrarVertice(vertice2);
                fila.enqueue(vertice2);
            }
        }
        // Reseta as marcações dos vetices
        for (int v = 0; v < numVertices; v++) {
            listaVertice[v].marcarComoNaoVisitado();
        }
    }
}
