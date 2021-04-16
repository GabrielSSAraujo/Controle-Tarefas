package modelo;
import java.util.Date;

public class Projeto{

    private Date dataInicio;
    private Date dataTermino;
    private String nome;

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

    @Override
    public String toString(){
        return "Projeto: "+getNome()+"";
    }

}
