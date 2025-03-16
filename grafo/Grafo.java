/* Implementado com Matriz de Adjacencia */
class Grafo {

    private final int MAX_VERTICES = 20; // final torna esta variável em constante.
    private Vertice listaVertice[];
    private int matriz[][];
    private int numVertices;

    public Grafo() {
        listaVertice = new Vertice[MAX_VERTICES];
        matriz = new int[MAX_VERTICES][MAX_VERTICES];
        numVertices = 0;

        for (int y = 0; y < MAX_VERTICES; y++) {
            for (int x = 0; x < MAX_VERTICES; x++) {
                matriz[x][y] = 0;
            }
        }
    }

    public void adicionarVertice(String rotulo) {
        numVertices++;
        listaVertice[numVertices] = new Vertice(rotulo);
    }

    public void adicionarAresta(int inicio, int fim) {
        matriz[inicio][fim] = 1;
        matriz[fim][inicio] = 1;
    }

    public void mostrarVertice(int v) { // método para exibir um determinado vértice
        System.out.print(listaVertice[v].getRotulo());
    }

    public void fazerDFS() {
        PilhaEncadeada pilha = new PilhaEncadeada();
        listaVertice[0].marcarComoVisitado();
        mostrarVertice(0);
        pilha.push(0);

        while (!pilha.isEmpty()) {
            int verticeAdjacente = pegaVerticeNaoVisitado((int) pilha.peek());
            
            if (verticeAdjacente == -1) {
                pilha.pop();
            }
            
        }

    }

    private int pegaVerticeNaoVisitado(int v) { // método encontra vértice ainda não visitado
        for (int j = 0; j < numVertices; j++) {
            if (matriz[v][j] == 1 && listaVertice[j].getVisitado() == false) {
                return j;
            }
        }
        return -1;
    }
}
