package view;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.*;

import controle.*;

import controle.ControleProjeto;
import modelo.*;


/**
 * Criação da interface com usuário mostrando dados do projeto e tratando eventos para cadastro e exclusão de projetos
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class TelaDetalheProjeto implements ActionListener, ListSelectionListener{
    private static final String NullCheck = null;
    private JFrame janela= new JFrame("Controle de tarefas - detalhamento projeto");
    private JLabel titulo = new JLabel("Detalhamento Projeto");
    private JLabel labelNomeProjeto = new JLabel("Nome:");
    private JTextField valorNomeProjeto;
    private JLabel labelDataInicio = new JLabel("Data inicio:");
    private JTextField valorDataInicio;
    private JLabel labelDataTermino = new JLabel("Data termino:");
    private JTextField valorDataTermino;
    private JLabel labelListaTarefa = new JLabel("Tarefas cadastradas:");
    private JList<String> listaTarefasCadastradas;
    private String[] listaTarefas = new String[50];
    private JButton salvarProjeto = new JButton("Salvar");
    private JButton excluirProjeto = new JButton("Excluir");
    private JButton atualizarProjeto = new JButton("Atualizar");
    private JButton addTarefa = new JButton("+");
    private String[] dadosProjeto = new String[6];
    private int opt;
    private int ind;
    private ControleProjeto p;
    private ControleTarefas ct;
    private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Mostra dados de projetos em uma lista clicavel como:
     * (1) lista de tarefas
     * (2) data de termino do projeto
     * (3) data de inicio do projeto
     * @param proj
     * @param indice
     * @param menu
     * @param cadTar
     */
    public void MostrarDadosProjeto(ControleProjeto proj, int indice,int menu, ControleTarefas cadTar){

        opt = menu;
        p = proj;
        ct = cadTar;
        ind = indice;

        //cinfig da janela
        janela.setVisible(true);
        janela.setLayout(null);
        janela.setSize(600, 400);

        //titulo da janela
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(200, 10, 200, 30);

        if(menu == 2){
            valorNomeProjeto = new JTextField(proj.getArrProjetos(indice).getNome(), 300);
            valorDataInicio = new JTextField(proj.getArrProjetos(indice).getDataInicio());
            valorDataTermino = new JTextField(proj.getArrProjetos(indice).getDataTermino());
            listaTarefas = cadTar.getNomeTarefasProjeto(proj.getArrProjetos(indice));
            listaTarefasCadastradas = new JList<String>(listaTarefas);
            salvarProjeto.setBounds(135, 310, 90, 25);
            excluirProjeto.setBounds(245, 310, 90, 25);
        }
        else{
            valorNomeProjeto = new JTextField();
            valorDataInicio = new JTextField();
            valorDataTermino= new JTextField();
            listaTarefasCadastradas = new JList<String>(listaTarefas);
            addTarefa.setVisible(false);
            labelListaTarefa.setVisible(false);
            listaTarefasCadastradas.setVisible(false);
            atualizarProjeto.setVisible(false);
            //realocar botões qunado não houver botão de atualizar
            salvarProjeto.setBounds(200, 310, 90, 25);
            excluirProjeto.setBounds(310, 310, 90, 25);
        }

        labelNomeProjeto.setBounds(80, 70, 60, 25);
        valorNomeProjeto.setBounds(140, 70, 360, 25);
        labelDataInicio.setBounds(80,110,80,25);
        valorDataInicio.setBounds(165,110,100,25);
        labelDataTermino.setBounds(300,110,90,25);
        valorDataTermino.setBounds(400,110,100,25);
        labelListaTarefa.setBounds(80,150,150,25);
        addTarefa.setBounds(80,180,45,20);
        listaTarefasCadastradas.setBounds(80, 210, 420, 90);
        listaTarefasCadastradas.addListSelectionListener(this);

        atualizarProjeto.setBounds(355, 310, 90, 25);
        
        janela.add(titulo);
        janela.add(labelNomeProjeto);
        janela.add(valorNomeProjeto);
        janela.add(labelDataInicio);
        janela.add(valorDataInicio);
        janela.add(labelDataTermino);
        janela.add(valorDataTermino);
        janela.add(labelListaTarefa);
        janela.add(addTarefa);
        janela.add(listaTarefasCadastradas);
        janela.add(salvarProjeto);
        janela.add(excluirProjeto);
        janela.add(atualizarProjeto);

        salvarProjeto.addActionListener(this);
        excluirProjeto.addActionListener(this);
        atualizarProjeto.addActionListener(this);
        addTarefa.addActionListener(this);
    }
    
    /**
     * Trata eventeos de clique nos botões de cadastro, atualizar
     */
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if(src == salvarProjeto){
            try{
                boolean ret=false;

                dadosProjeto[0] = Integer.toString(p.getNumProjetos());
                dadosProjeto[1] = valorDataInicio.getText();
                dadosProjeto[2] = valorDataTermino.getText();
                dadosProjeto[3] = valorNomeProjeto.getText();

                if(opt==1){
                    Projeto projeto = new Projeto(dadosProjeto[1],dadosProjeto[1], dadosProjeto[3]);
                    ret = p.cadastroProjeto(projeto);
                }else{
                    ret = p.editarProjeto(dadosProjeto[1],dadosProjeto[1], dadosProjeto[3],ind);
                }
                if(ret) {
					sucessoCadastro();
				}
				else erroCadastro();
            } catch(NullPointerException ex){
                erroCadastro();
            }
        }
        
        else if(src == excluirProjeto){
                boolean ret;
                ret = p.excluirProjeto(ind);
                if(ret){sucessoExcluir();}
                else{erroExcluir();}
        }
        
        else if(src == addTarefa){
            new TelaDetalheTarefa().mostrarDadosTarefa(ct, listaTarefasCadastradas.getSelectedIndex(),1, p.getArrProjetos(ind));
        }
        
        else if(src == atualizarProjeto){
            listaTarefasCadastradas.setListData(ct.getNomeTarefasProjeto(p.getArrProjetos(ind)));			
			listaTarefasCadastradas.updateUI();
        }
    }
   

    /**
     * Obsera eventos do JList para chamar o detalhamento das tarefas
     */
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

       if(e.getValueIsAdjusting() && src == listaTarefasCadastradas) {
           //envio do indice da tarefa, o controle de tarefas e do seletor 1 - adicionar nova 2 editar;
			new TelaDetalheTarefa().mostrarDadosTarefa(ct, listaTarefasCadastradas.getSelectedIndex(),2, p.getArrProjetos(ind));
       }
    }

    /**
     * notifica usuario sobre o sucesso no cadastro
     */
    public void sucessoCadastro(){
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
   
    /**
     * notifica usuario sobre erro no cadastro
     */
    public void erroCadastro(){
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }
   
    /**
     * Notifica usuario o sucesso na exclusão do projeto
     */
    public void sucessoExcluir(){
        JOptionPane.showMessageDialog(null, "Projeto excluido com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
   
    /**
     * notifica usuario do erro ao excluir projeto
     */
    public void erroExcluir(){
        JOptionPane.showMessageDialog(null, "Erro ao excluir projeto!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }
}
