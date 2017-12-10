
package televisao.model;

public class Funcionario{
    private String nome;
    private int idade;
    private boolean ehAtor = false;

    public Funcionario() {
    }

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isEhAtor() {
        return ehAtor;
    }

    public void setEhAtor(boolean ehAtor) {
        this.ehAtor = ehAtor;
    }
}
