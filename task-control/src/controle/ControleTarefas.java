package controle;

import modelo.Tarefas;
import modelo.Projeto;

public class ControleTarefas {
    private Tarefas[] tarefasProjeto = new Tarefas[50];
    private int numTarefas = 0;

    public void cadastroTarefa(Tarefas t){
        int qtd=0;

        if(getNumTarefas()==0){setTarefas(t, 0);}
        else{
            for(int i =0;i<getNumTarefas();i++){
                if(getTarefas(i)==null){
                    setTarefas(t, i);
                    qtd=1;
                    break;
                }
                else{
                    setTarefas(t, getNumTarefas());
                }
            }
        }
        if(qtd==0){
            setNumTarefas(getNumTarefas()+1); 
        } 
    }

    public void excluirTarefa(Tarefas t){
        for(int i =0;i<getNumTarefas();i++){
            if(getTarefas(i).equals(t)){
                setTarefas(null, i);
            }
        }
    }

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