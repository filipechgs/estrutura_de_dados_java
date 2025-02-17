
public class ArvoreBinariaBusca {

    private No raiz;

    public ArvoreBinariaBusca() {
        raiz = null;
    }

    public void insereABB(long id, Object elemento) // inserção na ABB
    {
        if (raiz == null) {
            raiz = new No(id, elemento, null, null);
        } else {
            No novoNo = new No(id, elemento, null, null);
            insere(raiz, novoNo);
        }
    }

    private void insere(No atual, No novo) // inserção ordenada
    {
        if (atual.getId() == novo.getId()) { // achou o elemento, nada inserido
            return;
        }
        if (novo.getId() < atual.getId()) { // vai inserir à esquerda
            if (atual.getEsq() == null) { // achou a posição, basta inserir
                atual.setEsq(novo);
            } else { // continua buscando resursivamente à esquerda
                insere(atual.getEsq(), novo);
            }
        }
        if (novo.getId() > atual.getId()) { // vai inserir à direita
            if (atual.getDir() == null) { // achou a posição, basta inserir
                atual.setDir(novo);
            } else { // continua buscando resursivamente à direita
                insere(atual.getDir(), novo);
            }
        }
    }

    /* Algoritmos de varredura */
    private void inFixado(No atual) // caminhamento in fixado da árvore binária
    {
        if (atual != null) {
            inFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: "+atual.getElemento());
            inFixado(atual.getDir());
        }
    }

    private long calcAltura(No atual, long a) {
        if (atual != null) {
            long esquerda, direita;
            esquerda = calcAltura(atual.getEsq(), a) + 1;
            direita = calcAltura(atual.getDir(), a) + 1;

            if (esquerda > direita) {
                return a + esquerda;
            } else {
                return a + direita;
            }
        }
        return a;
    }

    public long alturaArvore() {
        long a = 0;
        return calcAltura(raiz, a);
    } // final do método alturaArvore

    public void imprimeElementosArvore() // impressão dos elementos da árvore
    {
        inFixado(raiz);
    }
}
