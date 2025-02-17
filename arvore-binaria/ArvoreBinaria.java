
public class ArvoreBinaria {

    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void insere(long id, Object elemento) {
        No novoNo = new No(id, elemento, null, null);

        if (raiz == null) {
            raiz = novoNo;

        } else {
            No atual = raiz;
            No pai;

            // O loop abaixo para apenas com o retorno vazio, que encerra a execução do método
            while (true) {
                pai = atual; // pai inicia com o valor do No raiz

                if (id < atual.getId()) {
                    atual = atual.getEsq();

                    if (atual == null) {
                        pai.setEsq(novoNo);
                        return;
                    }
                    // Se for != null: retorna true; 
                    // atual = ao No da esquerda;
                    // pai é atualizado com o valor de atual;

                } else { // Se o id no novo elemento for maior que o id da raiz
                    atual = atual.getDir();

                    if (atual == null) {
                        pai.setDir(novoNo);
                        return;
                    }
                    // Se for != null: retorna true; 
                    // atual = ao No da direita;
                    // pai é atualizado com o valor de atual;
                }
            }
        }
    }

    /* Algoritmos de varredura */
    private void preFixado(No atual) {
        if (atual != null) {
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
            preFixado(atual.getEsq());
            preFixado(atual.getDir());
        }
    }

    private void posFixado(No atual) {
        if (atual != null) {
            posFixado(atual.getEsq());
            posFixado(atual.getDir());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
        }
    }

    private void simFixado(No atual) // caminhamento simétrico fixado
    {
        if (atual != null) {
            simFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
            simFixado(atual.getDir());
        }
    }

    private long calcAltura(No atual, long a) 
    {
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
        preFixado(raiz);
    }
}
