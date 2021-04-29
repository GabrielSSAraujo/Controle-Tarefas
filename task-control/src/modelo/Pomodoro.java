package modelo;

/**
 * Cria pomodoro de trabalho
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class Pomodoro {
    private int tempoTrabalho;
    private int tempoDescanso;

    /**
     * Seta:
     * (1) tempo a ser trabalhado
     * (2) tempo de descanso
     * @param tempoTrabalho
     * @param tempoDescanso
     */
    public Pomodoro(int tt, int td){
        tempoTrabalho = tt;
        tempoDescanso = td;

        setTempoDescanso(getTempoDescanso());
        setTempoTrabalho(getTempoTrabalho());
    }    
        
    public int getTempoTrabalho(){
        return tempoTrabalho;
    }
    public void setTempoTrabalho(int tempoTrabalho){
        this.tempoTrabalho = tempoTrabalho;
    }
    public int getTempoDescanso(){
        return tempoDescanso;
    }
    public void setTempoDescanso(int tempoDescanso){
        this.tempoDescanso = tempoDescanso;
    }
}
