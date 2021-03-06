
package televisao.model;

public class Duble extends Funcionario implements IParticipantes{
    
    private Ator ator;
    private double salario;
    private Producao producao;

    public Duble() {
    }

    public Duble(double salario, String nome, int idade) {
        super(nome, idade);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
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
