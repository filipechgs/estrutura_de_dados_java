
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

    /* Algoritmos de varredura e busca*/
    private void inFixado(No atual) // caminhamento in fixado da árvore binária. É o mesmo que simFixado
    {
        if (atual != null) {
            inFixado(atual.getEsq());
            System.out.println("Id: " + atual.getId() + " Elemento: " + atual.getElemento());
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

    private No busca(No atual, long id) // busca recursiva na ABB
    {
        if (atual == null) { // não encontrou e retorna nulo
            return null;

        } else {
            if (id == atual.getId()) { // achou o elemento
                return atual;

            } else {
                if (id < atual.getId()) {
                    // busca só na subárvore esquerda
                    return busca(atual.getEsq(), id);

                } else {
                    // busca só na subárvore direita
                    return busca(atual.getDir(), id);
                }
            }
        }
    }

    public No buscaABB(long id) // busca de um elemento na ABB
    {
        return busca(raiz, id);
    }

    public boolean removeABB(long id) // remove um elemento da ABB
    { // a ABB não pode ser vazia
        No atual = raiz;
        No pai = raiz;
        boolean filhoEsq = true;
        while (atual.getId() != id) { // busca o elemento
            pai = atual;
            if (id < atual.getId()) { // busca à esquerda
                filhoEsq = true;
                atual = atual.getEsq();
            } else { // busca à direita
                filhoEsq = false;
                atual = atual.getDir();
            }
            if (atual == null) { // não achou e termina
                return false;
            }
        }
        
        // caso 1: elemento não possui filhos
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) { // eliminando a raiz da ABB
                raiz = null;
        
            } else {
                if (filhoEsq) { // o elemento era filho esquerdo
                    pai.setEsq(null);
        
                } else { // o elemento era filho direito
                    pai.setDir(null);
                }
            }
        } else {
            if (atual.getDir() == null) { // Caso 2: com apenas o filho esquerdo
                if (atual == raiz) { // eliminando a raiz
                    raiz = atual.getEsq();
        
                } else {
                    if (filhoEsq) { // o elemento era filho esquerdo
                        pai.setEsq(atual.getEsq());
        
                    } else { // o elemento era filho direito
                        pai.setDir(atual.getEsq());
                    }
                }
            } else {
                if (atual.getEsq() == null) { // Caso 2: com apenas o filho direito
                    if (atual == raiz) { // eliminando a raiz
                        raiz = atual.getDir();
        
                    } else {
                        if (filhoEsq) { // o elemento era filho esquerdo
                            pai.setEsq(atual.getDir());
        
                        } else { // o elemento era filho direito
                            pai.setDir(atual.getDir());
                        }
                    }
                } else { // Caso 3: elemento possui os dois filhos
                    No sucessor = getSucessor(atual); // busca o elemento sucessor
                    if (atual == raiz) { // raiz passa a ser o sucessor
                        raiz = sucessor;
        
                    } else {
                        if (filhoEsq) { // o elemento era filho esquerdo
                            pai.setEsq(sucessor);
        
                        } else { // o elemento era filho direito
                            pai.setDir(sucessor);
                        }
                    }
                    sucessor.setEsq(atual.getEsq());
                }
            }
        }
        return true;
    }

    private No getSucessor(No eliminado) // encontra o próximo menor valor
    {
        No sucessorPai = eliminado;
        No sucessor = eliminado;
        No atual = eliminado.getDir(); // ir para o filho da direita
        while (atual != null) { // até não haver mais filhos à esquerda
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }
        if (sucessor != eliminado.getDir()) { // se não for o próprio filho direito
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(eliminado.getDir());
        }
        return sucessor;
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
