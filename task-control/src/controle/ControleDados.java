package controle;
import java.util.*;

import modelo.*;

public class ControleDados {

    public void filWithSomeData(CRUDProjeto cadPro, Projeto[] projeto, ControleTarefas cadTar, Tarefas[] tarefas ){
        Date d = Calendar.getInstance().getTime();
        for(int i = 0; i < 3; i++){
            projeto[i] = new Projeto(d,d,"projeto "+i);
            cadPro.cadastroProjeto(projeto[i]);

            for(int j = 0; j <2; j++){
                tarefas[j] = new Tarefas("tarefas "+j+i , d, d, 10*(i+j), "descrição tarefa"+i+j, "URGENTE", projeto[i]);
                cadTar.cadastroTarefa(tarefas[j]);
            }


            
        }
    }
}
