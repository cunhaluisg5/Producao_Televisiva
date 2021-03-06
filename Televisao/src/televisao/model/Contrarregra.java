
package televisao.model;

public class Contrarregra extends Funcionario implements IFuncionariosApoio{
    private Producao producao;

    public Contrarregra() {
    }

    public Contrarregra(String nome, int idade) {
        super(nome, idade);
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public double val() {
        return SALARIO_CONTRARREGRA;
    }
    
    @Override
    public double valorSalario() {
        return producao.getTempo() * SALARIO_CONTRARREGRA;
    }
}
