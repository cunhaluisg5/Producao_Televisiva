
package televisao.model;

public class Cena {
    private String nome;
    private Producao producao;

    public Cena() {
    }

    public Cena(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }
}
