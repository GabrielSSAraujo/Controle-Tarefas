package modelo;

/**
 * Cria projeto com informações de inicio e termino
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class Projeto{

    private String dataInicio;
    private String dataTermino;
    private String nome;

    /**
     * Seta os dados de inicio termino e nome para criação do projeto
     * @param dataInicio
     * @param dataTermino
     * @param nomeProjeto
     */
    public Projeto(String di, String df, String n){
        dataInicio = di;
        dataTermino = df;
        nome = n;
    }

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

    @Override
    public String toString(){
        return "Projeto: "+getNome()+"";
    }

}
