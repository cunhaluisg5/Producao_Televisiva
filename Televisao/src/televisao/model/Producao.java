
package televisao.model;

import java.util.ArrayList;

public class Producao {
    private String nome;
    private int ano;
    private double verba;
    private double tempo;
    private ArrayList<Cena> cenas;
    private ArrayList<Funcionario> funcionarios;

    public Producao() {
        this.cenas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public Producao(String nome, int ano, double verba, double tempo) {
        this.nome = nome;
        this.ano = ano;
        this.verba = verba;
        this.tempo = tempo;
        this.cenas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
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

    public ArrayList<Cena> getCenas() {
        return cenas;
    }

    public void setCenas(ArrayList<Cena> cenas) {
        this.cenas = cenas;
    }
    

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    public double valorPago(){
        return 0;
    }
    
    public void mostraCenas(){
        int i = 1;
        for(Cena c : cenas){
            System.out.println(i + ") " + c.getNome());
            i++;
        }
    }
    
    public void mostraTomadas(int cena){
        int i = 1;
        Tomada tomada = null;
        for(Tomada t : cenas.get(cena).getTomadas()){
            System.out.println(i + ") " + t.getNome());
            i++;
        }
    }
    
    public Ator verificaFuncionario(Funcionario fun){
        Ator ator = null;
        for(Funcionario f : funcionarios){
            if(f.getNome().equals(fun.getNome())){
                ator = new Ator();
            }
        }
        return ator;
    }
    
    public void infoCenas(){
        System.out.println("Quantidade de cenas: " + getCenas().size());
        for(Cena c : cenas){
            System.out.println("Nome da cena: " + c.getNome() + ", quantidade de tomadas: "
            + c.getTomadas().size());
            System.out.println("Tomadas da cena: ");
            for(Tomada t : c.getTomadas()){
                System.out.print(t.getNome() + ", duração: " + t.getDuracao()); 
                System.out.print("min, tomada gravada em " + t.getFitas().size() + " fitas (");
                for(Fita f : t.getFitas()){
                    System.out.print(f.getNumeroSerie() + ", ");
                }
                System.out.println(")");
            }
            System.out.println("");
            System.out.print("Funcionários da cena: ");
            for(Funcionario f : c.getFuncionarios()){
                if(f.isEhAtor()){
                    System.out.print(f.getNome() + " = ator, ");
                }else{
                    System.out.print(f.getNome() + " = dublê de (" + ((Duble) f).getAtor().getNome() + "), ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("");
    }
    
    
    
    public void infoFuncionarios(){
        if(funcionarios.size() != 0){
            System.out.println("Funcionários participantes da produção: ");
            mostraFuncionarios();
        }else{
            System.out.println("Funcionários participantes da produção: 0");
        }
        System.out.println("");
    }

    public void mostraFuncionarios() {
        int i = 1;
        for(Funcionario f : funcionarios){
            if(f instanceof Ator){
                System.out.print(i + ") " + f.getNome() + " = ator, ");
            }else if(f instanceof Duble){
                System.out.print(i + ") " + f.getNome() + " = dublê de (" + ((Duble) f).getAtor().getNome() + "), ");
            }else if(f instanceof Camera){
                System.out.print(i + ") " + f.getNome() + " = câmera, ");
            }else if(f instanceof Contrarregra){
                System.out.print(i + ") " + f.getNome() + " = contrarregra, ");
            }else if(f instanceof Iluminador){
                System.out.print(i + ") " + f.getNome() + " = iluminador, ");
            }
            i++;
        }
    }
    
    public void infoSalarios(){
        System.out.println("Verba da produção R$" + verba);
        System.out.println("O salário total dos funcionários é R$" + totalSalarioFuncionarios());
        for(Funcionario f : funcionarios){
            if(f instanceof Ator){
                System.out.println(f.getNome() + " = ator, salário mensal: " + (((Ator) f).getSalario() + ", salario completo: " + ((Ator) f).valorSalario()));
            }else if(f instanceof Duble){
                System.out.println(f.getNome() + " = dublê, salário mensal: " + (((Duble) f).getSalario() + ", salario completo: " + ((Duble) f).valorSalario()));
            }else if(f instanceof Camera){
                System.out.println(f.getNome() + " = câmera, salário mensal: " + ((Camera) f).val() + ", salario completo: " + ((Camera) f).valorSalario());
            }else if(f instanceof Contrarregra){
                System.out.println(f.getNome() + " = contrarregra, salário mensal: " + ((Contrarregra) f).val() + ", salario completo: " + ((Contrarregra) f).valorSalario());
            }else if(f instanceof Iluminador){
                System.out.println(f.getNome() + " = iluminador, salário mensal: " + ((Iluminador) f).val() + ", salario completo: " + ((Iluminador) f).valorSalario());
            }
        }
        System.out.println("");
    }
    
    public double totalSalarioFuncionarios(){
        double soma = 0;
        for(Funcionario f : funcionarios){
            if(f instanceof IParticipantes){
                soma += ((IParticipantes) f).valorSalario();
            }else if(f instanceof IFuncionariosApoio){
                soma += ((IFuncionariosApoio) f).valorSalario();
            }
        }
        return soma;
    }
}
