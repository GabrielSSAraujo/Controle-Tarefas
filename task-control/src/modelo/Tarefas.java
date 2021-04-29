package modelo;

/**
 * Cria tarefa comas seguintes informações:
 * (1) data de inicio
 * (2) data de termino
 * (3) nome da tarefa
 * (4) tempo estimado para sua realização
 * (5) tempo real gasto que é calculado e atualizado conforme o tempo de trabalho
 * (6) descrição da tarefa
 * (7) prioridade 
 * (8) projeto em que a tarefa será cadastrada
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class Tarefas{

    private String dataInicio;
    private String dataTermino;
    private String nome;
    private int tempoEstimado;
    private int tempReal = 0;
    private String descricao;
    private String prioridade;
    private Projeto projeto;

    /**
     *  /**
     * Seta os dados necessarios para definição da tarefa
     * @param nomeTarefa
     * @param dataInicio
     * @param dataFinal
     * @param tempoEstimado
     * @param descriçao
     * @param prioridade
     * @param projeto
     */
    public Tarefas(String nt, String di, String df, int te, String d, String pr,Projeto p){
        dataInicio= di;
        dataTermino = df;
        tempoEstimado=te;
        descricao = d;
        prioridade = pr;
        nome= nt;
        projeto= p;

        //dados a serem cadastrados em cada tarefa
        setNome(getNome());
        setDescricao(getDescricao());
        setTempoEstimado(getTempoEstimado());
        setPrioridade(getPrioridade());
    }

  /*  public void cadastrar(){
        //Tarefas sendo cadastradas no projeto
        Projeto pro = this.getProjeto();
        int qtd=0;

        if(pro.getNumTarefas()==0){pro.setTarefas(this, 0);}
        else{
            for(int i =0;i<pro.getNumTarefas();i++){
                if(pro.getTarefas(i)==null){
                    pro.setTarefas(this, i);
                    qtd=1;
                    break;
                }
                else{
                    pro.setTarefas(this, pro.getNumTarefas());
                }
            }
        }
        if(qtd==0){
            pro.setNumTarefas(pro.getNumTarefas()+1); 
        } 
    }

    public void excluir(){
        Projeto proj = this.getProjeto();
        for(int i =0;i<proj.getNumTarefas();i++){
            if(proj.getTarefas(i).equals(this)){
                proj.setTarefas(null, i);
            }
        }
    }*/

    public String getDataInicio(){
        return dataInicio;
    }
    public void setDataInicio(String dataInicio){
        this.dataInicio=dataInicio;
    }
    public String getDataTermino(){
        return dataTermino;
    }
    public void setDataTermino(String dataTermino){
        this.dataTermino=dataTermino;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public int getTempoEstimado(){
        return tempoEstimado;
    }
    public void setTempoEstimado(int tempoEstimado){
        this.tempoEstimado =tempoEstimado;
    }
    public int getTempReal(){
        return tempReal;
    }
    public void setTempReal(int tempReal){
        this.tempReal = tempReal;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getPrioridade(){
        return prioridade;
    }
    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }
    public Projeto getProjeto(){
        return projeto;
    }
    public void setProjeto(Projeto projeto){
        this.projeto = projeto;
    }

    @Override
    public String toString(){
        return " Nome da tarefa: "+getNome()+", Descrição: "+ getDescricao()+", O tempo estimado: "+getTempoEstimado()+
        "min, Prioridade:" +getPrioridade()+ " Agora o tempo real gasto: "+getTempReal();
    }


}