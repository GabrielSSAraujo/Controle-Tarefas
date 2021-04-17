package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.event.*;
import java.util.*;
import controle.*;
import modelo.*;

public class TesteView implements ActionListener, ListSelectionListener{

    private JFrame janela= new JFrame("Controle de tarefas");
    private JLabel titulo = new JLabel("Controle de tarefas");
    private JLabel lbTempoPomodoro = new JLabel("Cadastre pomodoro");
    private JLabel  lbProjCad = new JLabel("Projetos cadastrados:");
    private JLabel  lbNewProj = new JLabel("Nenhum projeto cadastrado.");
    private static JButton addProjeto = new JButton("Cadastrar");
    private static JButton refreshProjeto = new JButton("Atualizar");
    private JList<String> listaProjetosCadastrados;
    private String[] listaProjetos = new String[50];
    public static CRUDProjeto proj = new CRUDProjeto();
    public static ControleTarefas cadTaref = new ControleTarefas();
    public static Projeto[] project = new Projeto[6];
    public static Tarefas[] tarefa = new Tarefas[20];
    public static ControleDados cadDados = new ControleDados();
    private Cronometro crono = new Cronometro();

    private JLabel labelConometro = new JLabel("00:00:00");
    private static JButton initCrono = new JButton("Iniciar"); 
    private static JButton stopCrono = new JButton("Parar"); 

    private static JButton cadastraPomodoro = new JButton("Cadastrar pomodoro"); 

    public TesteView() {

        //cadastrando projetos teste
        cadDados.filWithSomeData(proj, project, cadTaref, tarefa);

        //titulo da janela
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        //Contador de horas
        labelConometro.setFont(new Font("Arial", Font.BOLD,30));



        //buscando projetos cadastrados e salvando no Jlist
        listaProjetos = proj.getNomeProjeto();
        
        listaProjetosCadastrados = new JList<String>(listaProjetos);
        listaProjetosCadastrados.setBounds(80, 205, 420, 90);
        listaProjetosCadastrados.addListSelectionListener(this);

        //setando label dos projetos cadastrados 
        lbProjCad.setFont(new Font("Arial", Font.BOLD, 14));

        janela.setLayout(null);

        //Botão adicionar projeto
        if(proj.getNumProjetos()<6){
            addProjeto.setBounds(200, 310, 90, 25);
            refreshProjeto.setBounds(310, 310, 90, 25);
            janela.add(addProjeto);

        }else{refreshProjeto.setBounds(310, 310, 90, 25);}

        titulo.setBounds(200, 10, 200, 30);
        labelConometro.setBounds(240,60,130,30);
        initCrono.setBounds(200, 100, 90, 25);
        stopCrono.setBounds(310,100,90,25);
        cadastraPomodoro.setBounds(80,140,420,25);
        lbProjCad.setBounds(80, 170, 200, 30);

        janela.add(titulo);
        janela.add(labelConometro);
        janela.add(initCrono);
        janela.add(stopCrono);
        janela.add(cadastraPomodoro);
        janela.add(lbProjCad);
        janela.add(refreshProjeto);
        janela.add(listaProjetosCadastrados);

        //cinfig da janela
        janela.setVisible(true);
        janela.setSize(600, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(final String args[]){
        TesteView opt = new TesteView();

        addProjeto.addActionListener(opt);
        refreshProjeto.addActionListener(opt); 
        initCrono.addActionListener(opt);
        stopCrono.addActionListener(opt); 
    } 

    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        
        if(src == addProjeto){
            new TelaDetalheProjeto().MostrarDadosProjeto(proj, listaProjetosCadastrados.getSelectedIndex(),1,cadTaref);
        }
        else if(src == refreshProjeto){
            listaProjetosCadastrados.setListData(proj.getNomeProjeto());			
			listaProjetosCadastrados.updateUI();
        }
        else if(src == initCrono){
            crono.initCrono(labelConometro);
        }
        else if(src == stopCrono){
            crono.finCrono();
        }

    }
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaProjetosCadastrados) {
			new TelaDetalheProjeto().MostrarDadosProjeto( proj,	listaProjetosCadastrados.getSelectedIndex(),2,cadTaref);
		}
        
    }
    
}
