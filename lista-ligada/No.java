public class No {
    private No proximo; // aponta para o próximo No da Lista
    private Object elemento; // armazena o elemento de cada No 

    public No(Object elemento, No proximo) // construtor classe No
    {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public void setProximo(No proximo) // método que altera próximo No da Lista
    {
        this.proximo = proximo;
    }

    public No getProximo() // método que recebe o próximo No da Lista
    {
        return proximo;
    }

    public void setElemento(Object elemento) // método para alterar o elemento
    {
        this.elemento = elemento;
    }

    public Object getElemento() // método para receber o objeto contido no No
    {
        return elemento;
    }
}