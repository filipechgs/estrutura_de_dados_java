
class ExemploGrafo {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.adicionarVertice("A");
        g.adicionarVertice("B");
        g.adicionarVertice("C");
        g.adicionarVertice("D");

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(0, 3);
        g.adicionarAresta(2, 3);

        g.mostrarVertice(1);
    }
}
