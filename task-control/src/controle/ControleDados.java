package controle;

import java.text.SimpleDateFormat;
import java.util.*;
import modelo.*;

/**
 * Cria dados para teste do projeto
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class ControleDados {
    private ControleProjeto cp;
    private Projeto[] p;
    private ControleTarefas ct;
    private Tarefas[] t;

    /**
     * Cria 3 projetos e 3 tarefas para realização de testes.
     * @param controleProjeto
     * @param projeto
     * @param controleTarefa
     * @param tarefas
     */
    public void filWithSomeData(ControleProjeto cadPro, Projeto[] projeto, ControleTarefas cadTar, Tarefas[] tarefas ){
        cp = cadPro;
        p = projeto;
        ct = cadTar;
        t = tarefas;

        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        formatador.format(d);
        for(int i = 0; i < 3; i++){
            projeto[i] = new Projeto("23/0"+i+"/2011","23/0"+i+"/2012","projeto "+i);
            cadPro.cadastroProjeto(projeto[i]);

            for(int j = 0; j <2; j++){
                tarefas[j] = new Tarefas("tarefas "+j+i , "23/0"+i+"/2011","23/0"+i+"/2011", 10*(i+j), "descrição tarefa"+i+j, "NAO URGENTE", projeto[i]);
                cadTar.cadastroTarefa(tarefas[j]);
            }
        }
    }
}
