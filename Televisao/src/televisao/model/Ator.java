
package televisao.model;

import java.util.ArrayList;

public class Ator extends Funcionario implements IParticipantes{
    private double salario;
    private Producao producao;

    public Ator() {
    }

    public Ator(Cena cena, double salario, String nome, int idade) {
        super(nome, idade);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    @Override
    public double valorSalario() {
        return producao.getTempo() * salario;
    }
}
