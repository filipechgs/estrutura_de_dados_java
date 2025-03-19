
class Grafo { // implementação da classe Grafo

    private final int MAX_VERTICES = 20; // número máximo de vértices
    private final int INFINITO = 1000000; // número muito grande
    private Vertice listaVertice[]; // lista de vértices
    private int matriz[][]; // matriz adjacente
    private int numVertices; // número atual de vértices
    private int numFechados; // número de vértices com distância fechada
    private DistanciaEstimada menor[]; // vetor com o caminho mais curto
    private int verticeAtual; // vértice atual
    private int distParaAtual; // distância para o vértice atual

    public Grafo() { // construtor da classe Grafo
        listaVertice = new Vertice[MAX_VERTICES];
        matriz = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;
        numFechados = 0;

        for (int y = 0; y < MAX_VERTICES; y++) {
            for (int x = 0; x < MAX_VERTICES; x++) {
                matriz[x][y] = INFINITO;
            }
        }
        menor = new DistanciaEstimada[MAX_VERTICES];
    }

    public void adicionarVertice(String rotulo) {
        if (numVertices < MAX_VERTICES) {
            listaVertice[numVertices] = new Vertice(rotulo);
            numVertices++;
        } else {
            System.out.println("Erro: Limite máximo de vértices atingido.");
        }
    }


    public void adicionarAresta(int inicio, int fim, int peso) {
        if (peso < 0) {
            // System.out.println("Erro: Arestas com peso negativo não são permitidas.");
            return;
        }
        if (inicio == fim) {
            // System.out.println("Erro: Loop detectado! Não é possível adicionar arestas que ligam um vértice a si mesmo.");
            return;
        }
        matriz[inicio][fim] = peso;
    }

    private int pegaMinimo() { // pega o índice com a menor distância
        int minimo = INFINITO;
        int indice = 0;
        for (int j = 1; j < numVertices; j++) {
            if (!listaVertice[j].getVisitado() && menor[j].getDistancia() < minimo) {
                minimo = menor[j].getDistancia();
                indice = j;
            }
        }
        return indice;
    }

    private void ajustaMenor() { // ajusta o vetor com os caminhos mais curtos
        int coluna = 1;
        while (coluna < numVertices) {
            if (listaVertice[coluna].getVisitado()) {
                coluna++;
                continue;
            }

            int atualParaMargem = matriz[verticeAtual][coluna];
            int inicioParaMargem = distParaAtual + atualParaMargem;
            int menorDistancia = menor[coluna].getDistancia();

            if (inicioParaMargem < menorDistancia) {
                menor[coluna].setPaiVertice(verticeAtual);
                menor[coluna].setDistancia(inicioParaMargem);
            }
            coluna++;
        }
    }

    private void mostraMenor() { // mostra o menor caminho encontrado
        for (int j = 0; j < numVertices; j++) {
            System.out.print(listaVertice[j].getRotulo() + "=");
            if (menor[j].getDistancia() == INFINITO) {
                System.out.print("inf");
            } else {
                System.out.print(menor[j].getDistancia());
            }
            String pai = (String) listaVertice[menor[j].getPaiVertice()].getRotulo();
            System.out.print("(" + pai + ") ");
        }
        System.out.println("");
    }

    public void menorCaminho() { // encontra o menor caminho
        int inicio = 0;
        listaVertice[inicio].marcarComoNaoVisitado();;
        numFechados = 1;

        for (int j = 0; j < numVertices; j++) {
            int distancia = matriz[inicio][j];
            menor[j] = new DistanciaEstimada(inicio, distancia);
        }

        while (numFechados < numVertices) {
            int indiceParaMinimo = pegaMinimo();
            int minimaDistancia = menor[indiceParaMinimo].getDistancia();

            if (minimaDistancia == INFINITO) {
                System.out.println("Existem vértices não endereçados");
                break;
            } else {
                verticeAtual = indiceParaMinimo;
                distParaAtual = menor[indiceParaMinimo].getDistancia();
            }

            listaVertice[verticeAtual].marcarComoVisitado();;
            numFechados++;
            ajustaMenor();
        }

        mostraMenor();
        numFechados = 0;

        for (int j = 0; j < numVertices; j++) {
            listaVertice[j].marcarComoNaoVisitado();;
        }
    }
}
