package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.AttributeSet.FontAttribute;

import java.awt.event.*;
import java.util.*;
import controle.*;
import modelo.*;

public class TelaEscolhaTarefa implements ActionListener, ListSelectionListener {

    private JFrame janela = new JFrame("Escolha taarefa");
    private JLabel labelBusca = new JLabel("Buscar:");
    private JButton buscar = new JButton("Buscar");
    private JTextField valorBusca;

    private JList<String> listaTodasTarefas;
    private String[] listaTTarefas = new String[100];

    private ControleTarefas cont;

    public void mostarTodasTarefas(ControleTarefas controle){
        cont = controle;
        //cinfig da janela
        janela.setVisible(true);
        janela.setLayout(null);
        janela.setSize(600, 400);

        //definindo campo de busca
        labelBusca.setFont(new Font("Arial", Font.BOLD,14));
        valorBusca = new JTextField();

        //adicionando 12 projetos prévios
        listaTTarefas = controle.getAllTasks();
        listaTodasTarefas = new JList<String>(listaTTarefas);
        listaTodasTarefas.addListSelectionListener(this);

        labelBusca.setBounds(80,60,80,25);
        valorBusca.setBounds(160,60,240,25);
        buscar.setBounds(410,60,90,25);
        listaTodasTarefas.setBounds(80,130,420,180);

        janela.add(labelBusca);
        janela.add(valorBusca);
        janela.add(buscar);
        janela.add(listaTodasTarefas);

        buscar.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();

        if(src == buscar){
            System.out.println(valorBusca.getText());
            listaTodasTarefas.setListData(cont.buscarTarefaNome(String.valueOf(valorBusca.getText())));			
			listaTodasTarefas.updateUI();
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        
    } 
}
