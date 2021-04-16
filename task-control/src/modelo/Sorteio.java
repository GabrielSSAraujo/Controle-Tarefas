package modelo;

import java.util.Random;

import controle.CRUDProjeto;
import controle.ControleTarefas;
import jdk.internal.platform.Container;

public class Sorteio {

    private int tempoTrabalhado;
    private Recompensa recompensa;
    private CRUDProjeto cad;
    private ControleTarefas cadT;
    private int residuo;

    public Sorteio(CRUDProjeto c, Recompensa r){
        cad = c;
        recompensa = r;
    }

    public void sortear(){
        
        //verificando em todos os projetos e em todas as tarefas a quantidade de horas trabalhadas
        for(int i=0;i<getCad().getNumProjetos(); i++){
            if(getCad().getArrProjetos(i) != null){
                for(int j=0; j<getCad().getArrProjetos(i).getNumTarefas();j++){
                    if(getCad().getArrProjetos(i).getTarefas(j)!=null){
                        setTempoTrabalhado(getCad().getArrProjetos(i).getTarefas(j).getTempReal() + getTempoTrabalhado());
                    }
                }
            }
        }
        System.out.println("O tempo total trabalhado em todos os projetos é de: " + getTempoTrabalhado());
        
        //A cada 10s trabalhado para fins de teste será feito um sorteio
        int qtdSorteios = ((int) getTempoTrabalhado()/10 - getResiduo() );
        System.out.println("Quantidade de sorteios a serem realizados: "+qtdSorteios);
        
        //Sorteando entre as 5 recompensas
        Random r = new Random();
        int n=0;
        for ( int i = 0; i < qtdSorteios; i++ ) {
            n = r.nextInt( 4 ) + 0;
            System.out.println("Sua recompensa pelo trabalho duro é: "+getRecompensa().getTempoRecompensa()+" min de "+getRecompensa().getRecompensas(n));
        }
        setResiduo(getTempoTrabalhado());

    }

    public int getTempoTrabalhado(){
        return tempoTrabalhado;
    }
    public void setTempoTrabalhado(int tempoTrabalhado){
        this.tempoTrabalhado = tempoTrabalhado;
    }
    public Recompensa getRecompensa(){
        return recompensa;
    }
    public void setRecompensa(Recompensa recompensa){
        this.recompensa = recompensa;
    }
    public CRUDProjeto getCad(){
        return cad;
    }
    public void setCad(CRUDProjeto cad){
        this.cad = cad;
    }
    public int getResiduo(){
        return residuo;
    }
    public void setResiduo(int residuo){
        this.residuo = residuo;
    }
}
