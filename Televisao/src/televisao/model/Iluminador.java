
package televisao.model;

public class Iluminador extends Funcionario implements IFuncionariosApoio{
    private Producao producao;

    public Iluminador() {
    }

    public Iluminador(String nome, int idade) {
        super(nome, idade);
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public double val() {
        return SALARIO_ILUMINADOR;
    }
    
    @Override
    public double valorSalario() {
        return producao.getTempo() * SALARIO_ILUMINADOR;
        
}
