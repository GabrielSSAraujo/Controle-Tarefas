/*import java.util.*;

import controle.*;
import modelo.*;

public class App {
    
    static Tarefas[] taref = new Tarefas[50];
    static Projeto[] proj = new Projeto[12];
    static CRUDProjeto cad;
    static ControleTarefas cadT;
    static Recompensa rec;
    static Sorteio sort;
    static Cronometro c;
    static Pomodoro pomo;
    
    //oausar codigo para tester contador.
    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    public static void main(String[] args) throws Exception {

        //data somente para teste
        GregorianCalendar d = new GregorianCalendar();
        Date agora = d.getTime();

        cad = new CRUDProjeto();
        cadT = new ControleTarefas();
        //Criando projetos.
        proj[0]= new Projeto(agora, agora, "Projeto 1");
        proj[1]= new Projeto(agora, agora, "Projeto 2");
        //cadastrando projetos
        cad.cadastroProjeto(proj[0]);
        cad.cadastroProjeto(proj[1]);

        //Excluindo um projeto
        //cad.excluirProjeto(proj[1]);

        //editando projeto
        //cad.editarProjeto(proj[0],proj[2]);

        //mostrando projetos cadastrados
        System.out.println(cad.consultarProjetosCadastrados().toString());

        //criando tarefas
        taref[0] = new Tarefas("Tarefa 1", agora, agora, 10, "Essa é a descrição da tarefa 1", "Urgente", proj[0]);
        taref[1] = new Tarefas("Tarefa 2", agora, agora, 15, "Essa é a descrição da tarefa 2", "Nao Urgente", proj[0]);
        taref[2] = new Tarefas("Tarefa 3", agora, agora, 20, "Essa é a descrição da tarefa 3", "Importante", proj[1]);
        taref[3] = new Tarefas("Tarefa 4", agora, agora, 40, "Essa é a descrição da tarefa 4", "Urgente", proj[1]);

        cadT.cadastroTarefa(taref[0]);
        cadT.cadastroTarefa(taref[1]);

        System.out.println(cadT.consultarTarefasCadastradas(proj[0]));

        //cadastrando tarefas
        taref[0].cadastrar();
        taref[1].cadastrar();
        taref[2].cadastrar();
        taref[3].cadastrar();

        //editando tarefas
        taref[0].setDescricao("A descrição da tarefa 1 mudou");
        taref[0].setPrioridade("nao urgente");

        //excluindo tarefas
        taref[3].excluir();

        //mostrando tarefas cadastrada nos projetos
        System.out.println(cad.consultarTarefasProjeto(proj[0]));

        //editando recompensas, por default é:
            //"ASSISTIR SERIE/FILME", 0
            //"REDES SOCIAIS", 1
            //"LER LIVRO", 2
            //"JOGAR", 3
            //"BARZINHO <3", 4

        rec = new Recompensa();

        System.out.println(rec.consultarRecompensasCadastradas().toString());
        rec.setRecompensas("Futebol", 3);
        System.out.println(rec.consultarRecompensasCadastradas().toString());
       
        //contador da tarefa paramentro:0 parando contador parâmetro:1
        c = new Cronometro();

        c.cronometro(0, taref[0]);//inicia contador do tempo real da tarefa 1
        System.out.println("Iniciando cronometro");
        pause(3000);
        c.cronometro(1, taref[0]); //para contador de tempo real da tarefa 1

        pause(1000);
        
        //testando recomeço do cronometro
        c.cronometro(0, taref[0]);
        pause(3000);
        System.out.println("Iniciando cronometro");
        c.cronometro(1, taref[0]);

        pause(1000);

        //fazendo novamente o contador para tarefa 2. Agora apara testar a contagem total de tempo trabalhado.
        c.cronometro(0, taref[1]);
        pause(5000);
        System.out.println("Iniciando cronometro");
        c.cronometro(1, taref[1]);

        pause(1000);

        //chamando - sorteio que calcula a quantidade total de tempo gasto nos projetos
        sort = new Sorteio(cad,rec);
        sort.sortear();

        //definindo pomodoro
        pomo = new Pomodoro(45,15);

        //editando pomodoro
        pomo.setTempoDescanso(10);
    }
} */
