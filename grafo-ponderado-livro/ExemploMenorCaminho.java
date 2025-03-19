
class ExemploMenorCaminho {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        
        g.adicionarVertice("A"); // 0 (início)
        g.adicionarVertice("B"); // 1
        g.adicionarVertice("C"); // 2
        g.adicionarVertice("D"); // 3
        g.adicionarVertice("E"); // 4
        g.adicionarVertice("F"); // 5
        g.adicionarVertice("G"); // 6
        g.adicionarAresta(0, 1, 50); // AB 50
        g.adicionarAresta(0, 3, 80); // AD 80
        g.adicionarAresta(1, 2, 60); // BC 60
        g.adicionarAresta(1, 3, 90); // BD 90
        g.adicionarAresta(2, 4, 40); // CE 40
        g.adicionarAresta(3, 2, 20); // DC 20
        g.adicionarAresta(3, 4, 70); // DE 70
        g.adicionarAresta(4, 1, 50); // EB 50
        g.adicionarAresta(5, 6, 20); // FG 20

        System.out.println("Menor Caminho");
        g.menorCaminho();
        System.out.println();
    } 
} 