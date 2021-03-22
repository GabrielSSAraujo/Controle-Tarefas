package modelo;
import java.util.Date;

public class Projeto{

    private Date dataInicio;
    private Date dataTermino;
    private String nome;
    private Tarefas[] tarefasProjeto = new Tarefas[50];
    private int numTarefas = 0;

    //construtor
    public Projeto(Date di, Date df, String n){
        dataInicio = di;
        dataTermino = df;
        nome = n;
    }

    public Date getDataInicio(){
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio){
        this.dataInicio=dataInicio;
    }
    public Date getDataTermino(){
        return dataTermino;
    }
    public void setDataTermino(Date dataTermino){
        this.dataTermino=dataTermino;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public Tarefas[] getTarefasProjeto(){
        return this.tarefasProjeto;
    }
    public void setTarefasProjeto(Tarefas[] t){
        this.tarefasProjeto = t;
    }
    public Tarefas getTarefas(int i){
        return tarefasProjeto[i];
    }
    public void setTarefas(Tarefas tarefas, int i){
        this.tarefasProjeto[i]= tarefas;
    }
    public int getNumTarefas(){
        return numTarefas;
    }
    public void setNumTarefas(int numTarefas){
        this.numTarefas = numTarefas;
    }

    public String consultarTarefasCadastradas() {
		String saida = "\n***** Lista as tarefas cadastradas no projeto "+getNome()+"*****\n" ;
        
		for(int i = 0; i < getNumTarefas(); i++) {
            if(getTarefas(i)!=null){saida = saida + "\n" +i+"-"+ getTarefas(i);}
		}
		return saida;
	}

    @Override
    public String toString(){
        return "Projeto: "+getNome()+"";
    }

}
