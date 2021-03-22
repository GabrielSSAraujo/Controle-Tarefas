package modelo;

public class Pomodoro {
    private int tempoTrabalho;
    private int tempoDescanso;

    public Pomodoro(int tt, int td){
        tempoTrabalho = tt;
        tempoDescanso = td;

        setTempoDescanso(getTempoDescanso());
        setTempoTrabalho(getTempoTrabalho());
    }
    //Ao iniciar tempo da tarefa inicia também a contagem do pomodoro
            //não deu tempo de implementar.
        
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
