
public class Cliente {

    private long codigo;
    private String razaoSocial;
    private String endereco;
    private double previsaoVendas;

    public Cliente(long c, String r, String e, double p) // construtor classe Cliente
    {
        this.codigo = c;
        this.razaoSocial = r;
        this.endereco = e;
        this.previsaoVendas = p;
    }

    public String toString() {
        return "- Codigo: " + this.codigo + " Razão Social: " + this.razaoSocial;
    }

    public void atualizaRazaoSocial(String r) {
        razaoSocial = r;
    }

    public void atualizaPrevisao(double p) {
        previsaoVendas = p;
    }

    public void mudaEndereco(String e) {
        endereco = e;
    }
}
