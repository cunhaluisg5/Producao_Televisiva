
package televisao;

import java.util.ArrayList;
import java.util.Scanner;
import televisao.model.Ator;
import televisao.model.Camera;
import televisao.model.Cena;
import televisao.model.Contrarregra;
import televisao.model.Duble;
import televisao.model.Funcionario;
import televisao.model.IParticipantes;
import televisao.model.Iluminador;
import televisao.model.Producao;
import televisao.model.Tomada;

/**
 * Luís Gustavo da Cunha Cipriani
 */
public class Principal {
    private static ArrayList<Tomada> tomadasEscolhidas = new ArrayList<>();
    private static ArrayList<Producao> producoes = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Producao producao = new Producao();
        Cena cena = new Cena();
        Ator ator = new Ator();
        Duble duble = new Duble();
        Tomada tomada = new Tomada();
        
        int opcao = 0;
        int num = 0;
        int j = 0;
        while(opcao != 3){
            System.out.println("*** MENU INICIAL ***");
            System.out.println("1 - Criar uma produção");
            System.out.println("2 - Acessar uma produção existente");
            System.out.println("3 - Sair");
            opcao = le.nextInt();
            if(opcao == 1){
                producao = new Producao();
                producao = criaProducao(le);
                menu(le, opcao, num, producao); 
                producoes.add(producao);
            }
            if(opcao == 2){
                System.out.println("*** PRODUÇÕES ***");
                int i = 1;
                Producao guarda = null;
                if(producoes.size() != 0 ){
                    for(Producao p : producoes){
                        System.out.println(i + ") " + p.getNome());
                        guarda = p;
                        i++;
                    }
                    System.out.println("Escolha uma producao");
                    opcao = le.nextInt();
                    menu(le, opcao, num, producoes.get(opcao-1)); 
                }else{
                    System.out.println("Não existem produções criadas!");
                }
            }
        }                       
    }

    public static void menu(Scanner le, int opcao, int num, Producao producao) {
        while(opcao != 9){
            opcao = menuProducao(le);                
            if(opcao == 1){
                criaCena(le, producao, num);
            }
            if(opcao == 2){
                editaCena(le, producao, num);
            }
            if(opcao == 3){
                opcao = criaAtor(le, producao, opcao);                        
            }
            if(opcao == 4){
                opcao = criaDuble(le, producao, opcao);
            }
            if(opcao ==5){
                opcao = criaApoio(opcao, le, producao);
            }
            if(opcao == 6){
                editarFuncionario(le, producao, opcao);
            }
            if(opcao == 7){
                opcao = criaTomada(producao, opcao, le);
            }
            if(opcao == 8){
                opcao = criaRelatorio(producao, opcao, le);
            }
        }
    }

    private static int criaRelatorio(Producao producao, int opcao, Scanner le) {
        System.out.println("*** RELATÓRIO ***");
        producao.infoCenas();
        if(tomadasEscolhidas.size() != 0){
            System.out.println("Tomadas selecionadas: ");
            for(Tomada t : tomadasEscolhidas){
                System.out.print(t.getNome() + ", ");
            }
        }else{
            System.out.println("Tomadas selecionadas: 0");
        }
        System.out.println("");
        producao.infoFuncionarios();
        System.out.println("");
        producao.infoSalarios();
        if(producao.totalSalarioFuncionarios() > producao.getVerba()){
            System.out.println("*** ATENÇÃO ***");
            System.out.println("A produção não possui verba suficiente para pagar "
                    + "o salário de todos os funcionários");
            System.out.println("Deseja adicionar mais verbas?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            opcao = le.nextInt();
            if(opcao == 1){
                System.out.println("Informe a quantia para adicionar");
                producao.setVerba(producao.getVerba() + (le.nextDouble()));
            }
        }
        System.out.println("Tecle (1) para voltar ao menu anterior");
        opcao = le.nextInt();
        while(opcao != 1){
            System.out.println("Opção incorreta!");
            System.out.println("Tecle (1) para voltar ao menu anterior");
            opcao = le.nextInt();
        }
        return opcao;
    }

    private static int criaTomada(Producao producao, int opcao, Scanner le) {
        System.out.println("*** TOMADAS ***");
        if(producao.getCenas().size() != 0){
            System.out.println("Cenas da produção: ");
            producao.mostraCenas();
            System.out.println("Escolha uma cena");
            opcao = le.nextInt();
            int op = 0;
            while(op != 2){
                System.out.println("Tomadas da cena");
                producao.mostraTomadas(opcao-1);
                System.out.println("Escolha uma tomada");
                int recebeNome = le.nextInt();
                Tomada tomadaLocal = producao.getCenas().get(opcao-1).retornaTomada(producao.getCenas().get(opcao-1).tomadaEscolhida(recebeNome));
                tomadasEscolhidas.add(tomadaLocal);
                System.out.println("(1) Adicionar outra tomada / (2) Voltar");
                op = le.nextInt();
            }
            opcao = 0;
            return opcao;
        }else{
            System.out.println("Não existem cenas cadastradas!");
        }
        return opcao;
    }

    private static int criaApoio(int opcao, Scanner le, Producao producao) {
        System.out.println("*** APOIO ***");
        System.out.println("Escolha um tipo de funcionário de apoio");
        System.out.println("1 - Câmera");
        System.out.println("2 - Contrarregra");
        System.out.println("3 - Iluminador");
        opcao= le.nextInt();
        System.out.println("Informe o nome");
        String nome = le.next();
        System.out.println("Informe a idade");
        int idade = le.nextInt();
        Funcionario fun = null;
        if(opcao == 1){
            fun = new Camera(nome, idade);
            ((Camera)fun).setProducao(producao);
        }else if(opcao == 2){
            fun = new Contrarregra(nome, idade);
            ((Contrarregra)fun).setProducao(producao);
        }else if(opcao == 3){
            fun = new Iluminador(nome, idade);
            ((Iluminador)fun).setProducao(producao);
        }
        producao.getFuncionarios().add(fun);
        opcao = 0;
        return opcao;
    }

    private static int criaDuble(Scanner le, Producao producao, int opcao) {
        Duble duble;
        System.out.println("*** DUBLÊ ***");
        System.out.println("Informe o nome");
        String nome = le.next();
        System.out.println("Informe a idade");
        int idade = le.nextInt();
        System.out.println("Informe o salário mensal");
        double salario = le.nextDouble();
        duble = new Duble(salario, nome, idade);
        if(producao.getCenas().size() != 0){
            System.out.println("Escolha uma cena");
            producao.mostraCenas();
            opcao = le.nextInt();
            System.out.println("Escolha um ator da cena:");
            if((producao.getCenas().get(opcao-1).getFuncionarios().size()) != 0){
                producao.getCenas().get(opcao-1).mostraAtores();
                int recebeNome = le.nextInt();
                Ator atorLocal = producao.getCenas().get(opcao-1).retornaAtor(producao.getCenas().get(opcao-1).atorEscolhido(recebeNome));
                duble.setEhAtor(false);
                duble.setProducao(producao);
                duble.setAtor(atorLocal);
                producao.getFuncionarios().add(duble);
                producao.getCenas().get(opcao-1).getFuncionarios().add(duble);
            }else{
                System.out.println("Não possui atores cadastrados para a cena!");
            }
        }else{
            System.out.println("Não existem cenas cadastradas!");
        }
        opcao = 0;
        return opcao;
    }

    private static int criaAtor(Scanner le, Producao producao, int opcao) {
        Ator ator;
        System.out.println("*** ATOR ***");
        System.out.println("Informe o nome");
        String nome = le.next();
        System.out.println("Informe a idade");
        int idade = le.nextInt();
        System.out.println("Informe o salário mensal");
        double salario = le.nextDouble();
        if(producao.getCenas().size() != 0){
            System.out.println("De qual cena deseja participar?");
            producao.mostraCenas();
            opcao = le.nextInt();
            ator = new Ator(producao.getCenas().get(opcao-1), salario, nome, idade);
            ator.setEhAtor(true);
            ator.setProducao(producao);
            producao.getFuncionarios().add(ator);
            producao.getCenas().get(opcao-1).getFuncionarios().add(ator);
        }else{
            System.out.println("Não existem cenas cadastradas");
        }
        opcao = 0;
        return opcao;
    }
    
    private static int editarFuncionario(Scanner le, Producao producao, int opcao) {
        System.out.println("*** EDITAR FUNCIONÁRIO ***");
        if(producao.getFuncionarios().size() != 0){
            System.out.println("Funcionários da produção: ");
            producao.mostraFuncionarios();
            System.out.println("\nEscolha um funcionário");
            opcao = le.nextInt();
            System.out.println("Informe o nome: ");
            String nome = le.next();
            producao.getFuncionarios().get(opcao-1).setNome(nome);
            System.out.println("Informe a idade");
            int idade = le.nextInt();
            producao.getFuncionarios().get(opcao-1).setIdade(idade);
            Funcionario a = producao.getFuncionarios().get(opcao-1);
            if(a instanceof Ator){
                System.out.println("Informe o salário mensal");
                double salario = le.nextDouble();
                ((Ator) a).setSalario(salario);
            }else if(a instanceof Duble){
                System.out.println("Informe o salário mensal");
                double salario = le.nextDouble();
                ((Duble) a).setSalario(salario);
                System.out.println("Funcionários da produção: ");
                producao.mostraFuncionarios();
                System.out.println("Escolha um ator para vincular ao dublê");
                opcao = le.nextInt();
                while(!(producao.getFuncionarios().get(opcao-1) instanceof Ator)){
                    System.out.println("Escolha um ator para vincular ao dublê");
                    opcao = le.nextInt();
                }
                Funcionario b = producao.getFuncionarios().get(opcao-1);
                ((Duble) a).setAtor((Ator) b);
            }

            opcao = 0;
        }else{
            System.out.println("Não existem funcionários cadastrados!");
        }
        return opcao;
    }

    private static void criaCena(Scanner le, Producao producao, int num) {
        Cena cena;
        Tomada tomada;
        System.out.println("*** CENA ***");
        System.out.println("Informe o nome da cena");
        String nomeCena = le.next();
        cena = new Cena(nomeCena);
        cena.setProducao(producao);
        String escolha = "s";
        int i = 1;
        while(escolha.equalsIgnoreCase("s")){
            tomada = new Tomada();
            System.out.println(nomeCena + i);
            tomada.setVal(i);
            tomada.setNome(cena.getNome());
            System.out.println("Informe a duração da tomada (em minutos)");
            int duracao = le.nextInt();
            tomada.setDuracao(duracao);
            tomada.setCena(cena);
            tomada.adicionaFitas(num++);
            cena.getTomadas().add(tomada);
            System.out.println("Deseja adicionar mais tomadas (S)im ou (N)ão?");
            escolha = le.next();
            i++;
        }
        producao.getCenas().add(cena);
    }
    
    private static void editaCena(Scanner le, Producao producao, int num) {
        Cena cena;
        Tomada tomada;
        System.out.println("*** EDITA CENA ***");
        if(producao.getCenas().size() != 0){
            System.out.println("Cenas existentes");
            producao.mostraCenas();
            System.out.println("Escolha uma cena");
            int opcaoCena = le.nextInt();
                System.out.println("Informe o novo nome da cena");
                String nom = le.next();
                producao.getCenas().get(opcaoCena-1).setNome(nom);
                Tomada tomadas = new Tomada();
                producao.getCenas().get(opcaoCena-1).trocaNomeTomada(nom);
                System.out.println("Nome da cena alterado para " + producao.getCenas().get(opcaoCena-1).getNome());
            if(producao.getCenas().get(opcaoCena-1).getFuncionarios().size() != 0){
                System.out.println("Os funcionários da cena são: ");
                producao.getCenas().get(opcaoCena-1).funcionarios();
                System.out.println("(1) Remover funcionário");
                int opcao = le.nextInt();
                if(opcao == 1){
                    System.out.println("Escolha um funcionário para remover");
                    producao.getCenas().get(opcaoCena-1).getFuncionarios();
                    opcao = le.nextInt();
                    producao.getCenas().get(opcaoCena-1).getFuncionarios().remove(producao.getCenas().get(opcaoCena-1).getFuncionarios().get(opcao));
                    System.out.println("Removido!");
                }
            }else{
                System.out.println("Não existem funcionários cadastrados nessa cena!");
            }
        }else{
            System.out.println("Não existem cenas cadastradas!");
        }
    }

    private static int menuProducao(Scanner le) {
        int opcao;
        System.out.println("*** Escolha uma opção abaixo ***");
        System.out.println("1 - Criar cena");
        System.out.println("2 - Editar cena");
        System.out.println("3 - Adicionar ator");
        System.out.println("4 - Adicionar dublê");
        System.out.println("5 - Adicionar funcionário de apoio");
        System.out.println("6 - Editar funcionários");
        System.out.println("7 - Escolher tomadas para finalizar produção");
        System.out.println("8 - Ver relatório");
        System.out.println("9 - Voltar");
        opcao = le.nextInt();
        return opcao;
    }

    private static Producao criaProducao(Scanner le) {
        Producao producao;
        producao = new Producao();
        System.out.println("*** PRODUÇÃO ***");
        System.out.println("Informe o nome da produção");
        producao.setNome(le.next());
        System.out.println("Informe o ano da produção");
        producao.setAno(le.nextInt());
        System.out.println("Informe a quantidade de meses para a conclusão da produção");
        producao.setTempo(le.nextDouble());
        System.out.println("Informe a verba para a produção");
        producao.setVerba(le.nextDouble());
        return producao;
    }
}
