package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import controle.*;
import modelo.*;

public class TelaPrincipal implements ActionListener, ListSelectionListener{

    private JFrame janela= new JFrame("Controle de tarefas");
    private JLabel  lbProjCad = new JLabel("Projetos cadastrados:");
    private static JButton addProjeto = new JButton("Cadastrar");
    private static JButton refreshProjeto = new JButton("Atualizar");
    private JList<String> listaProjetosCadastrados;
    private String[] listaProjetos = new String[50];
    public  ControleProjeto proj = new ControleProjeto();
    public  ControleTarefas cadTaref = new ControleTarefas();
    public  Projeto[] project = new Projeto[6];
    public  Tarefas[] tarefa = new Tarefas[20];
    public  ControleDados cadDados = new ControleDados();
    private Cronometro crono = new Cronometro();

    private JLabel labelConometro = new JLabel("00:00:00");
    private static JButton initCrono = new JButton("Iniciar"); 
    private static JButton stopCrono = new JButton("Parar"); 

    private JLabel labelPomodoro = new JLabel("Pomodoro cadastrado:");
    private JTextField valorPomoTrab;
    private JLabel labelPomoTrab= new JLabel("min de trabalho");
    private JTextField valorPomoDesc;
    private JLabel labelPomoDesc = new JLabel("min de descanso");
    private static JButton cadastraPomodoro = new JButton("Atualizar");
    
    private Pomodoro pomodoro=new Pomodoro(30, 5);

    public TelaPrincipal() {

        //cadastrando projetos teste
        cadDados.filWithSomeData(proj, project, cadTaref, tarefa);

        //Contador de horas
        labelConometro.setFont(new Font("Arial", Font.BOLD,40));

        //atribuindo valores précadastrados do pomodoro
        valorPomoTrab = new JTextField(Integer.toString(pomodoro.getTempoTrabalho()));
        valorPomoDesc = new JTextField(Integer.toString(pomodoro.getTempoDescanso()));

        //buscando projetos cadastrados e salvando no Jlist
        listaProjetos = proj.getNomeProjeto();
        
        listaProjetosCadastrados = new JList<String>(listaProjetos);
        listaProjetosCadastrados.setBounds(80, 205, 420, 90);
        listaProjetosCadastrados.addListSelectionListener(this);

        //setando label dos projetos cadastrados 
        lbProjCad.setFont(new Font("Arial", Font.BOLD, 14));
        labelPomodoro.setFont(new Font("Arial", Font.BOLD, 14));

        janela.setLayout(null);

        //Botão adicionar projeto
        if(proj.getNumProjetos()<6){
            addProjeto.setBounds(200, 310, 90, 25);
            refreshProjeto.setBounds(310, 310, 90, 25);
            janela.add(addProjeto);

        }else{refreshProjeto.setBounds(310, 310, 90, 25);}

        labelConometro.setBounds(220,20,230,30);
        initCrono.setBounds(200, 65, 90, 25);
        stopCrono.setBounds(310,65,90,25);
        labelPomodoro.setBounds(80,105,190,25);
        valorPomoTrab.setBounds(80,140, 30,25);
        labelPomoTrab.setBounds(115,140,100,25);
        valorPomoDesc.setBounds(220,140, 30,25);
        labelPomoDesc.setBounds(255,140,110,25);
        cadastraPomodoro.setBounds(410,140,90,25);
        lbProjCad.setBounds(80, 170, 200, 25);

        janela.add(labelConometro);
        janela.add(initCrono);
        janela.add(stopCrono);
        janela.add(labelPomodoro);
        janela.add(valorPomoTrab);
        janela.add(labelPomoTrab);
        janela.add(valorPomoDesc);
        janela.add(labelPomoDesc);
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
        TelaPrincipal opt = new TelaPrincipal();

        addProjeto.addActionListener(opt);
        refreshProjeto.addActionListener(opt); 
        initCrono.addActionListener(opt);
        stopCrono.addActionListener(opt); 
        cadastraPomodoro.addActionListener(opt);
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
            // JOptionPane.showMessageDialog(null, "Escolha a tarefa que irá realizar!", null, 
            // JOptionPane.INFORMATION_MESSAGE);

            crono.initCrono(labelConometro,pomodoro);
        }
        else if(src == stopCrono){
            crono.finCrono();
        }
        else if(src == cadastraPomodoro){
            pomodoro.setTempoDescanso(Integer.valueOf(valorPomoDesc.getText()));
            pomodoro.setTempoTrabalho(Integer.valueOf(valorPomoTrab.getText()));
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if(e.getValueIsAdjusting() && src == listaProjetosCadastrados) {
			new TelaDetalheProjeto().MostrarDadosProjeto( proj,	listaProjetosCadastrados.getSelectedIndex(),2,cadTaref);
		}      
    } 
}
