
package televisao.model;

public class Producao {
    private String nome;
    private int ano;
    private double verba;
    private double tempo;

    public Producao() {
    }

    public Producao(String nome, int ano, double verba, double tempo) {
        this.nome = nome;
        this.ano = ano;
        this.verba = verba;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getVerba() {
        return verba;
    }

    public void setVerba(double verba) {
        this.verba = verba;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
}
