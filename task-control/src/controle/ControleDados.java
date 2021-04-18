package controle;
import java.text.SimpleDateFormat;
import java.util.*;

import modelo.*;

public class ControleDados {

    public void filWithSomeData(CRUDProjeto cadPro, Projeto[] projeto, ControleTarefas cadTar, Tarefas[] tarefas ){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        formatador.format(d);
        for(int i = 0; i < 3; i++){
            projeto[i] = new Projeto(d,d,"projeto "+i);
            cadPro.cadastroProjeto(projeto[i]);

            for(int j = 0; j <2; j++){
                tarefas[j] = new Tarefas("tarefas "+j+i , d, d, 10*(i+j), "descrição tarefa"+i+j, "NAO URGENTE", projeto[i]);
                cadTar.cadastroTarefa(tarefas[j]);
            }
        }
    }
}
