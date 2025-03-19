
public class DistanciaEstimada // classe trará a distância estimada do menorcaminho
{
private int paiVertice; // pai atual do vértice
    private int distancia; // distância do início até o vértice

    public DistanciaEstimada(int p, int d) { //construtor
        this.paiVertice = p;
        this.distancia = d;
    }

    public void setDistancia(int d) { // método para atribuir distância
        this.distancia = d;
    }

    public int getDistancia() { // método para retornar distância
        return this.distancia;
    }

    public void setPaiVertice(int p) { // método para atribuir pai do vértice
        this.paiVertice = p;
    }

    public int getPaiVertice() { // método para retornar o pai do vértice
        return this.paiVertice;
    }
}
