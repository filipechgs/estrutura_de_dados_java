/* Implementado com Matriz de Adjacencia */
class Grafo {

    private static final int MAX_VERTICES = 20; // 'final' torna essa variável uma constante.
    private Vertice[] listaVertice;
    private int[][] matriz; // Pode ser feito CRUD da matriz de insidência
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

    /**
     *  DFS e BFD
     *  Métodos que implemtam algorítmos para sistematicamente buscar e identificar todos
     *  os vértices alcançáveis a partir de um determinado vértice inicial.
     */
    /**
     * Deep-first Search || Pesquisa em Profundidade
     * Visa identificar primeiro a profundidade de cada adjacencia a partir
     * de um vértice inicial
     */
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
            int verticeAdjacente = verificarSeVerticeAdjacenteFoiVisitado(pilha.peek());

            // Se o vertice ja foi visitado, remove-o da pilha
            if (verticeAdjacente == -1) {
                pilha.pop();

            // Se o vertice não foi visitado, adiciona-o na pilha e realiza uma ação
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

    private int verificarSeVerticeAdjacenteFoiVisitado(int verticeSelecionado) {
        if (verticeSelecionado < 0 || verticeSelecionado >= numVertices) {
            return -1;  // Evita erro ao acessar posição inválida
        }

        for (int v = 0; v < numVertices; v++) {
            if (matriz[verticeSelecionado][v] == 1 && !listaVertice[v].getVisitado()) {
                return v;
            }
        }

        return -1;
    }

    /**
     * Breadth-first Search || Pesquisa em Largura
     * Visa identificar primeiro os verticer adjacentes a um vertice inicial
     */
    public void executarBFS() { 
        if (numVertices == 0) {
            System.out.println("Erro: Nenhum vértice disponível para busca.");
            return;
        }

        FilaArray<Integer> fila = new FilaArray<>();
        listaVertice[0].marcarComoVisitado();
        mostrarVertice(0);
        fila.enqueue(0);
        int vertice2;

        // Enquanto a fila tiver elementos:
        while (!fila.isEmpty()) { 
            // Desenfilera o vertice
            int vertice1 = fila.dequeue();

            // Enquanto hover vertice não visitado, adjacente ao vertice desenfilerado:
            while ((vertice2 = verificarSeVerticeAdjacenteFoiVisitado(vertice1)) != -1) { 
                // Marca o vertice adjacente como visitado
                // Enfilera o vertice adjacente
                // Enquanto este looping não alcança s sua condição de parada, ele diatncia o looping externo da condição de parada
                // O desenfileramento só recomeça quando este looping para
                listaVertice[vertice2].marcarComoVisitado();
                mostrarVertice(vertice2);
                fila.enqueue(vertice2);

                // A partir da qui o looping retorna para verificar se vertice2 tem mais adjacencia não visitada 
            }
        }

        // Reseta as marcações dos vetices
        for (int v = 0; v < numVertices; v++) {
            listaVertice[v].marcarComoNaoVisitado();
        }
    }
}
