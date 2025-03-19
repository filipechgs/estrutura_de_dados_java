public class Vertice
{
    private String rotulo;
    private boolean visitado;

    public Vertice (String rotulo) {
        this.rotulo = rotulo;
        this.visitado = false;
    }

    public String toString() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }  

    public Object getRotulo() {
        return rotulo;
    } 

    public void marcarComoVisitado() {
        this.visitado = true;
    }

    public void marcarComoNaoVisitado() {
        this.visitado = false;
    }

    public Boolean getVisitado() {
        return visitado;
    }

}