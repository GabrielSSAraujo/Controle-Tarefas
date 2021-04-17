package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.*;
import controle.*;
import modelo.*;

public class TesteView implements ActionListener, ListSelectionListener{

    private static JFrame janela= new JFrame("Controle de tarefas");
    private static JLabel titulo = new JLabel("Controle de tarefas");
    private static JLabel lbTempoPomodoro = new JLabel("Cadastre pomodoro");
    private static JLabel  lbProjCad = new JLabel("Projetos cadastrados:");
    private static JLabel  lbNewProj = new JLabel("Nenhum projeto cadastrado.");
    private static JButton addProjeto = new JButton("add");
    private static JButton refreshProjeto = new JButton("Refresh");
    private JList<String> listaProjetosCadastrados;
    private String[] listaProjetos = new String[50];
    public static CRUDProjeto proj = new CRUDProjeto();
    public static ControleTarefas cadTaref = new ControleTarefas();
    public static Projeto[] project = new Projeto[6];
    public static Tarefas[] tarefa = new Tarefas[20];
    public static ControleDados cadDados = new ControleDados();

    private static JButton b;
    private static JFrame f;

    public TesteView() {

        //cadastrando projetos teste
        cadDados.filWithSomeData(proj, project, cadTaref, tarefa);

        //titulo da janela
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(200, 10, 200, 30);

        //buscando projetos cadastrados e salvando no Jlist
        listaProjetos = proj.getNomeProjeto();
        
        listaProjetosCadastrados = new JList<String>(listaProjetos);
        listaProjetosCadastrados.setBounds(80, 205, 420, 90);
        listaProjetosCadastrados.addListSelectionListener(this);

        //setando label dos projetos cadastrados 
        lbProjCad.setFont(new Font("Arial", Font.BOLD, 14));
        lbProjCad.setBounds(80, 170, 200, 30);

        janela.setLayout(null);

        //Botão adicionar projeto
        if(proj.getNumProjetos()<6){
            addProjeto.setBounds(200, 310, 90, 25);
            refreshProjeto.setBounds(310, 310, 90, 25);
            janela.add(addProjeto);

        }else{refreshProjeto.setBounds(310, 310, 90, 25);}

        janela.add(titulo);
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
    } 

    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        
        if(src == addProjeto){
            new TelaDetalheProjeto().MostrarDadosProjeto(proj, listaProjetosCadastrados.getSelectedIndex(),1,cadTaref);
        }
        if(src == refreshProjeto){
            listaProjetosCadastrados.setListData(proj.getNomeProjeto());			
			listaProjetosCadastrados.updateUI();
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaProjetosCadastrados) {
			new TelaDetalheProjeto().MostrarDadosProjeto( proj,	listaProjetosCadastrados.getSelectedIndex(),2,cadTaref);
		}
        
    }
    
}
