
public class ExemploArvoreBinaria 
{
    public static void main(String[] args) 
    {
        ArvoreBinaria a = new ArvoreBinaria();
        a.insere(10, "A");
        a.insere(5, "B");  // vai para a esquerda de A
        a.insere(15, "C"); // vai para a direita de A
        a.insere(2, "D");  // vai para a esquerda de B 
        a.insere(7, "E");  // vai para a direita de B
        a.insere(12, "F"); // vai para a esquerda de C
        a.insere(6, "G");  // vai para a esquerda de E
        a.insere(8, "H");  // vai para a direita de E

        a.imprimeElementosArvore();
        System.out.println("Altura: " + a.alturaArvore());        
    }
}
