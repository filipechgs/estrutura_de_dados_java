public class No // Implementação da classe No de uma árvore AVL
{
    private long id; // identificador do elemento
    private Object elemento; // armazena o elemento de cada No
    private No esq; // aponta para o filho esquerdo do nó
    private No dir; // aponta para o filho direito do nó
    private No pai; // aponta para o pai do nó
    private long b; // balanceamento do NO

    public No(long id, Object elemento, No esq, No dir) { // construtor classe No
        this.id = id;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.b = 0; // inicia o nó sempre balanceado com 0
        this.pai = null; // inicia o pai sempre como vazio
    }

    public String toString() { // método para converter o nó em texto
        return Long.toString(getId());
        // return ″Id:″+Long.toString(getId())+″ B:″+Long.toString(getB());
    }

    public void setId(long id) { // método para alterar o identificador do nó
        this.id = id;
    }

    public long getId() { // método para receber o identificador do nó
        return this.id;
    }

    public void setElemento(Object elemento) { // método para alterar o elemento
        this.elemento = elemento;
    }
    
    public Object getElemento() { // método para receber o objeto contido no No
        return elemento;
    }

    public void setEsq(No esq) { // método que altera o filho esquerdo
        this.esq = esq;
    }

    public No getEsq() { // método que recebe o filho esquerdo do nó
        return esq;
    }

    public void setDir(No dir) { // método que altera o filho direito
        this.dir = dir;
    }

    public No getDir() { // método que recebe o filho direito do nó
        return dir;
    }

    public void setB(long b) { // método para alterar o balanceamento
        this.b = b;
    }

    public long getB() { // método que recebe o balanceamento
        return b;
    }

    public void setPai(No pai) { // método que altera o pai do nó
        this.pai = pai;
    }

    public No getPai() { // método que recebe o pai do nó
        return pai;
    }
}