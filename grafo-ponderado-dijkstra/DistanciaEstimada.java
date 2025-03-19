class DistanciaEstimada {
    private int distancia;
    private int paiVertice;
    
    public DistanciaEstimada() {
        this.distancia = Integer.MAX_VALUE;
        this.paiVertice = 0;
    }
    
    public int getDistancia() {
        return distancia;
    }
    
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    public int getPaiVertice() {
        return paiVertice;
    }
    
    public void setPaiVertice(int paiVertice) {
        this.paiVertice = paiVertice;
    }
}