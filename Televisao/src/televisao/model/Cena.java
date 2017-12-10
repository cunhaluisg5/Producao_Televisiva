
package televisao.model;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Cena {
    private String nome;
    private Producao producao;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Tomada> tomadas;

    public Cena() {
        this.funcionarios = new ArrayList<>();
        this.tomadas = new ArrayList<>();
    }

    public Cena(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
        this.tomadas = new ArrayList<>();
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

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public void funcionarios(){
        for(Funcionario f : funcionarios){
            System.out.println(f.getNome());
        }
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Tomada> getTomadas() {
        return tomadas;
    }

    public void setTomadas(ArrayList<Tomada> tomadas) {
        this.tomadas = tomadas;
    }
    
    public void mostraAtores(){
        int i = 1;
        for(Funcionario f : funcionarios){
            if(f instanceof Ator){
                System.out.println(i + ") " + f.getNome());
                i++;
            }
        }
    } 
    
    public Ator retornaAtor(String nome){
        Ator ator = null;
        for(Funcionario f : funcionarios){
            if(f.getNome().equals(nome)){
                ator = (Ator) f;
            }
        }
        return ator;
    }
    
    public String atorEscolhido(int i){
        int j = 1;
        String nome = "";
        for(Funcionario f : funcionarios){
            if(i == j){
                nome =  f.getNome();
            }
            j++;
        }
        return nome;
    }
    
    public Tomada retornaTomada(String nome){
        Tomada tomada = null;
        for(Tomada t : tomadas){
            if(t.getNome().equals(nome)){
                tomada = (Tomada) t;
            }
        }
        return tomada;
    }
    
    public void trocaNomeTomada(String n){
        for(Tomada t : tomadas){
            t.setNome((n) + t.getVal());
        }
    }
    
    public String tomadaEscolhida(int i){
        int j = 1;
        String nome = "";
        for(Tomada t : tomadas){
            if(i == j){
                nome =  t.getNome();
            }
            j++;
        }
        return nome;
    }
}
