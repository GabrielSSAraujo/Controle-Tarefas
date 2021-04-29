package controle;

import modelo.Tarefas;
import modelo.Projeto;

/**
 * Realiza o CRUD das tarefas, busca de tarefas e faz a verificação dos dados
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class ControleTarefas {
    private Tarefas[] tarefasProjeto = new Tarefas[50];
    private int numTarefas = 0;

    /**
     * Cadastra tarefa no projeot em que é dependente
     * @param tarefa
     * @return
     */
    public boolean cadastroTarefa(Tarefas t){
        int qtd=0;
        boolean ret=false;

        if(getNumTarefas()==0){setTarefas(t, 0);}
        else{
            for(int i =0;i<getNumTarefas();i++){
                if(getTarefas(i)==null){
                    setTarefas(t, i);
                    qtd=1;
                    ret=true;
                    break;
                }
                else{
                    setTarefas(t, getNumTarefas());
                    ret=true;
                }
            }
        }
        if(qtd==0){
            setNumTarefas(getNumTarefas()+1); 
            ret=true;
        } 
        return ret;
    }
    
    /**
     * Exclui tarefa com base no indice recebido de um evento no JList
     * @param indice
     * @return
     */
    public boolean excluirTarefa(int indice){
        boolean ret;
        if(indice>=0){
            setTarefas(null, indice); 
            ret=true;
        }else{ret=false;}

        return ret;
    }

    /**
     * Realiza a busca das tarefas que estão cadastradas em um determinado projeto
     * @param projeto
     * @return
     */
    public String[] getNomeTarefasProjeto(Projeto proj) {

		String[] s = new String[consultarTarefasCadastradas(proj)];
        int j=0;
		for(int i = 0; i < getNumTarefas(); i++) {
            if(getTarefas(i)!=null && getTarefas(i).getProjeto() == proj){
                s[j] = getTarefas(i).getNome();
                j++;
            }
		}
		return s;
	}

    /**
     * Faz uma busca por todas as tarefas cadastradas e retorna um array com os nomes das tarefas
     * @return
     */
    public String[] getAllTasks(){
        String[] s = new String[getNumTarefas()];

        for(int i = 0; i<getNumTarefas(); i++){
            if(getTarefas(i)!=null){
                s[i]=String.valueOf(i)+getTarefas(i).getNome();
            }

        }
        return s;
    }

    /**
     * realiza a busca das tarefas a partir do nome recebido
     * @param nomeTarefa
     * @return
     */
    public String[] buscarTarefaNome(String nomeTarefa){
        String[] s = new String[getNumTarefas()];
        for(int i = 0; i<getNumTarefas(); i++){
            if(getTarefas(i)!=null && String.valueOf(tarefasProjeto[i]) == nomeTarefa){
                System.out.println("entrou");
                s[i] = getTarefas(i).getNome();
            }
        }
        return s;
    }

    public int getNumTarefas(){
        return numTarefas;
    }
    public void setNumTarefas(int numTarefas){
        this.numTarefas = numTarefas;
    }

    public Tarefas[] getArrayTarefas(){
        return this.tarefasProjeto;
    }
    public void setArrayTarefas(Tarefas[] tp){
        this.tarefasProjeto = tp;
    }

    public Tarefas getTarefas(int i){
        return tarefasProjeto[i];
    }
    public void setTarefas(Tarefas tarefa, int i){
        this.tarefasProjeto[i]=tarefa;
    }

    public int consultarTarefasCadastradas(Projeto pro) {
		String saida = "\n***** Lista as tarefas cadastradas no projeto "+pro.getNome()+"*****\n" ;
        int qtdT = 0;
		for(int i = 0; i < getNumTarefas(); i++) {
            if(getTarefas(i)!=null && getTarefas(i).getProjeto() == pro){
                saida = saida + "\n" +i+"-"+ getTarefas(i);
                qtdT++;
            }
		}
		return qtdT;
	}

}
