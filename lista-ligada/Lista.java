public class Lista {

    private No inicio;

    public Lista() {
        this.inicio = null;
    }

    public void insereInicio(Object elemento) {
        No novoNo = new No(elemento, null);
        novoNo.setProximo(this.inicio);
        this.inicio = novoNo;
    }

    public Object removeInicio() {
        if (this.inicio == null) {
            return null;
        }
        No auxiliar = this.inicio;
        this.inicio = auxiliar.getProximo();

        return auxiliar.getElemento();
    }

    public Object removePosicao(int posicao) {
        // Se a posição for 0, remove o primeiro nó
        if (posicao == 0) {
            return removeInicio();
        }

        No atual = this.inicio;
        No anterior = null;

        // Percorre a lista até a posição desejada
        for (int i = 0; i < posicao; i++) {
            // Se o nó atual for nulo, a posição é inválida
            if (atual == null) {
                return null;
            }
            anterior = atual;
            atual = atual.getProximo();
        }

        // Se o nó atual não for nulo, remove o nó na posição desejada
        if (atual != null) {
            if (anterior != null) {
                anterior.setProximo(atual.getProximo());
            }
            return atual.getElemento();

        } else {
            // Se o nó atual for nulo, a posição é inválida
            return null;
        }
    }

    public void imprimeLista() {
        No auxiliar = this.inicio;
        System.out.println("\n# Inicio da Lista Ligada");
        
        while (auxiliar != null) {
            System.out.println(auxiliar.getElemento());
            auxiliar = auxiliar.getProximo();
        }
        System.out.println("# Final da Lista Ligada\n");
    }

    public Object buscaElemento(long posicao) {
        No auxiliar = this.inicio;
        while ((posicao > 0) && (auxiliar != null)) {
            auxiliar = auxiliar.getProximo();
            posicao--;
        }
        return (auxiliar != null) ? auxiliar.getElemento() : null;
    }

    public void liberaLista() {
        while (inicio != null) {
            this.inicio = inicio.getProximo();
        }
    }
}
