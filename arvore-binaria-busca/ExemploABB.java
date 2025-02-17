
public class ExemploABB // Exemplo de criação de uma ABB
{

    public static void main(String[] args) {
        ArvoreBinariaBusca a = new ArvoreBinariaBusca(); // cria a árvore binária de busca
        a.insereABB(88, "elemento");
        a.insereABB(70, "elemento");
        a.insereABB(75, "elemento");
        a.insereABB(99, "elemento");
        a.insereABB(110, "elemento");
        a.insereABB(105, "elemento");
        a.insereABB(119, "elemento");
        a.insereABB(80, "elemento");
        a.insereABB(67, "elemento");
        a.insereABB(59, "elemento");
        a.insereABB(72, "elemento");
        a.insereABB(91, "elemento");
        a.insereABB(90, "elemento");
        a.insereABB(95, "elemento");
        a.insereABB(69, "elemento");
        a.insereABB(77, "elemento adicional"); // um elemento adicional
        a.imprimeElementosArvore();
    }
}
