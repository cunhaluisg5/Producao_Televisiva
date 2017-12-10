
package televisao.model;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Tomada {
    private String nome;
    private int duracao;
    private Cena cena;
    private int val;
    private ArrayList<Fita> fitas;

    public Tomada() {
        this. fitas = new ArrayList<>();
    }

    public Tomada(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
        this. fitas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = (nome + val);
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Cena getCena() {
        return cena;
    }

    public void setCena(Cena cena) {
        this.cena = cena;
    }

    public ArrayList<Fita> getFitas() {
        return fitas;
    }

    public void setFitas(ArrayList<Fita> fitas) {
        this.fitas = fitas;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    
    public void adicionaFitas(int n){
        Fita fita = new Fita();
        fitas.add(fita);
        String recebe = NumberFormat.getInstance().format(getFitas().size());
        fita.setNumeroSerie("#" + n + "." + recebe);
        int val = duracao - fita.getCapacidade();
        while(val > 0){
            Fita fita2 = new Fita();
            fitas.add(fita2);
            recebe = NumberFormat.getInstance().format(getFitas().size());
            fita2.setNumeroSerie("#" + n + "." + recebe);
            val -= fita.getCapacidade();
        }
    }
}
