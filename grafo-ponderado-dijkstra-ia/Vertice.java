class Vertice {
    private String rotulo;
    private boolean visitado;
    
    public Vertice() {
        this.rotulo = "";
        this.visitado = false;
    }
    
    public Vertice(String rotulo) {
        this.rotulo = rotulo;
        this.visitado = false;
    }
    
    public String getRotulo() {
        return rotulo;
    }
    
    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }
    
    public boolean getVisitado() {
        return visitado;
    }
    
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}