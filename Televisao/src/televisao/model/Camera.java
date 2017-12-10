
package televisao.model;

public class Camera extends Funcionario implements IFuncionariosApoio{
    private Producao producao;

    public Camera() {
    }

    public Camera(String nome, int idade) {
        super(nome, idade);
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public double val() {
        return SALARIO_CAMERA;
    }
    
    @Override
    public double valorSalario() {
        return producao.getTempo() * SALARIO_CAMERA;
    }
}
