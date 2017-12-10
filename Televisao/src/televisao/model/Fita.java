
package televisao.model;

public class Fita {
    private String numeroSerie;
    private int capacidade;

    public Fita() {
        capacidade = 120;
    }

    public Fita(String numeroSerie, int capacidade) {
        this.numeroSerie = numeroSerie;
        this.capacidade = capacidade;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
