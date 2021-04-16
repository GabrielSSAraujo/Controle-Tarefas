package view;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;  

import javax.swing.*;
import javax.swing.event.*;

import controle.*;

import controle.CRUDProjeto;
import modelo.*;

public class TelaDetalheProjeto implements ActionListener, ListSelectionListener{
    private static final String NullCheck = null;
    private JFrame janela= new JFrame("Tela principal");
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
    private String[] dadosProjeto = new String[6];

    private int opt;
    private int ind;
    private CRUDProjeto p;
    private ControleTarefas ct;

    public void MostrarDadosProjeto(CRUDProjeto proj, int indice,int menu, ControleTarefas cadTar){

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

        //lista de tarefas do projeto

        if(menu == 2){
            valorNomeProjeto = new JTextField(proj.getArrProjetos(indice).getNome(), 300);
            valorDataInicio = new JTextField(proj.getArrProjetos(indice).getDataInicio().toString(),300);
            valorDataTermino = new JTextField(proj.getArrProjetos(indice).getDataTermino().toString(),300);
            listaTarefas = cadTar.getNomeTarefasProjeto(proj.getArrProjetos(indice));
            listaTarefasCadastradas = new JList<String>(listaTarefas);
        }
        else{
            valorNomeProjeto = new JTextField();
            valorDataInicio = new JTextField();
            valorDataTermino= new JTextField();
            listaTarefasCadastradas = new JList<String>(listaTarefas);
            
        }
        labelNomeProjeto.setBounds(40, 70, 80, 25);
        valorNomeProjeto.setBounds(100, 70, 380, 25);
        labelDataInicio.setBounds(40,110,100,25);
        valorDataInicio.setBounds(120,110,120,25);
        labelDataTermino.setBounds(265,110,100,25);
        valorDataTermino.setBounds(360,110,120,25);
        labelListaTarefa.setBounds(40,170,150,25);
        listaTarefasCadastradas.setBounds(80, 200, 400, 90);
        listaTarefasCadastradas.addListSelectionListener(this);
        salvarProjeto.setBounds(200, 300, 90, 25);
        excluirProjeto.setBounds(310, 300, 90, 25);
        
        janela.add(titulo);
        janela.add(labelNomeProjeto);
        janela.add(valorNomeProjeto);
        janela.add(labelDataInicio);
        janela.add(valorDataInicio);
        janela.add(labelDataTermino);
        janela.add(valorDataTermino);
        janela.add(labelListaTarefa);
        janela.add(listaTarefasCadastradas);
        janela.add(salvarProjeto);
        janela.add(excluirProjeto);

        salvarProjeto.addActionListener(this);
        excluirProjeto.addActionListener(this);


    }
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
                    Projeto projeto = new Projeto(new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2021"), 
                    new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2021"), dadosProjeto[3]);
                    ret = p.cadastroProjeto(projeto);
                }else{
                    ret = p.editarProjeto(new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2021"), 
                    new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2021"), dadosProjeto[3],ind);
                }
                if(ret) {
					sucessoCadastro();
				}
				else erroCadastro();


            } catch(NullPointerException ex){
                erroCadastro();
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
        }
        
        if(src == excluirProjeto){
            boolean ret;
            ret = p.excluirProjeto(ind);
            if(ret){sucessoExcluir();}
            else{erroExcluir();}
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

       /* if(e.getValueIsAdjusting() && src == listaTarefasCadastradas) {
			new TelaDetalheProjeto().MostrarDadosProjeto( proj,	listaTarefasCadastradas.getSelectedIndex(),2,cadTaref);
		}*/
        
    }

    public void sucessoCadastro(){
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
    public void erroCadastro(){
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }
    public void sucessoExcluir(){
        JOptionPane.showMessageDialog(null, "Projeto excluido com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
    }
    public void erroExcluir(){
        JOptionPane.showMessageDialog(null, "Erro ao excluir projeto!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
    }
}
