package view;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  

import javax.swing.*;
import javax.swing.event.*;

import controle.*;
import modelo.*;

public class TelaDetalheTarefa implements ActionListener {

    private JFrame janela = new JFrame("Controle de tarefas - Detalhamento tarefas");
    private JLabel titulo = new JLabel("Detalhamento tarefa");
    private JLabel labelNomeTarefa = new JLabel("Nome:");
    private JTextField valorNomeTarefa;
    private JLabel labelDi = new JLabel("Data inicio:");
    private JTextField valorDi;
    private JLabel labelDt = new JLabel("Data termino:");
    private JTextField valorDt;
    private JLabel labelDescricao = new JLabel("Descrição:");
    private JTextArea valorDescricao;
    private JLabel labelPrioridade = new JLabel("Prioridade:");
    private JTextField valorPrioridade;
    private JLabel labelTempoEstimado = new JLabel("Tempo Estimado:");
    private JTextField valorTempoEstimado;
    private JButton cadastrarTarefa = new JButton("Cadastrar"); 
    private JButton excluirTarefa = new JButton("Excluir"); 

    

    private int op;
    private int ind;
    private ControleTarefas conT;
    private String[] dadosTarefa = new String[10];
    private Projeto p;
    
    String[] choices = { "UGENTE", "NAO URGENTE", "ADIAVEL", "NÃO IMPORTANTE"};
    final JComboBox<String> cb = new JComboBox<String>(choices);
    
    public void mostrarDadosTarefa(ControleTarefas ct, int indice, int opt, Projeto projeto){
        op = opt;
        ind = indice;
        conT = ct;
        p = projeto;
        
        //cinfig da janela
        janela.setVisible(true);
        janela.setLayout(null);
        janela.setSize(600, 400);

        //titulo da janela
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(200, 10, 200, 30);

        if(opt==2){
            valorNomeTarefa = new JTextField(ct.getTarefas(indice).getNome());
            valorDi = new JTextField(ct.getTarefas(indice).getDataInicio().toString());
            valorDt = new JTextField(ct.getTarefas(indice).getDataTermino().toString());
            valorDescricao = new JTextArea(ct.getTarefas(indice).getDescricao());
            valorPrioridade = new JTextField(ct.getTarefas(indice).getPrioridade());
            valorTempoEstimado = new JTextField(String.valueOf(ct.getTarefas(indice).getTempoEstimado()));
            cb.setSelectedItem(ct.getTarefas(indice).getPrioridade());
            System.out.println(ct.getTarefas(indice).getPrioridade());
        }else{
            valorNomeTarefa = new JTextField();
            valorDi = new JTextField();
            valorDt = new JTextField();
            valorDescricao = new JTextArea();
            valorPrioridade = new JTextField();
            valorTempoEstimado = new JTextField();
            cb.setSelectedItem("URGENTE");
        }

        labelNomeTarefa.setBounds(80, 70, 60, 25);
        valorNomeTarefa.setBounds(140, 70, 360, 25);
        labelDi.setBounds(80,110,80,25);
        valorDi.setBounds(165,110,100,25);
        labelDt.setBounds(300,110,90,25);
        valorDt.setBounds(400,110,100,25);
        labelPrioridade.setBounds(80,150,80,25);
        cb.setBounds(165,150,110,25);
        labelTempoEstimado.setBounds(300,150,80,25);
        valorTempoEstimado.setBounds(400,150,100,25);
        labelDescricao.setBounds(80,190,80,25);
        valorDescricao.setBounds(165,190,335,75);
        cadastrarTarefa.setBounds(200, 280, 90, 25);
        excluirTarefa.setBounds(310, 280, 90, 25);

        janela.add(titulo);
        janela.add(labelNomeTarefa);
        janela.add(valorNomeTarefa);
        janela.add(labelDi);
        janela.add(valorDi);
        janela.add(labelDt);
        janela.add(valorDt);
        janela.add(labelPrioridade);
        janela.add(cb);
        janela.add(labelTempoEstimado);
        janela.add(valorTempoEstimado);
        janela.add(labelDescricao);
        janela.add(valorDescricao);
        janela.add(cadastrarTarefa);
        janela.add(excluirTarefa);

        cadastrarTarefa.addActionListener(this);
        excluirTarefa.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if(src==cadastrarTarefa){
            try{
                boolean ret =true;
                dadosTarefa[1] = valorNomeTarefa.getText();
                dadosTarefa[2] = valorDi.getText();
                dadosTarefa[3] = valorDt.getText();
                dadosTarefa[4] = String.valueOf(cb.getSelectedItem());
                dadosTarefa[5] = valorTempoEstimado.getText();
                dadosTarefa[6] = valorDescricao.getText();

                if(op==1){

                    Tarefas tarefa = new Tarefas(dadosTarefa[1], new SimpleDateFormat("dd/mm/yyyy").parse(dadosTarefa[2]),
                    new SimpleDateFormat("dd/mm/yyyy").parse(dadosTarefa[3]), Integer.valueOf(dadosTarefa[5]), dadosTarefa[6], 
                    dadosTarefa[4],p);

                    ret = conT.cadastroTarefa(tarefa);
                }

                if(ret) {
					sucessoCadastroTar();
				}else erroCadastroTar();

            } catch (NumberFormatException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        
        else if(src == excluirTarefa){
            boolean ret;
                ret = conT.excluirTarefa(ind);
                if(ret){sucessoExcluirTar();}
                else{erroExcluirTar();}
        }
    
    }

    public void sucessoCadastroTar(){
        JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
    public void erroCadastroTar(){
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar tarefa!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }
    public void sucessoExcluirTar(){
        JOptionPane.showMessageDialog(null, "Projeto excluido com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
    public void erroExcluirTar(){
        JOptionPane.showMessageDialog(null, "Erro ao excluir projeto!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }

}
