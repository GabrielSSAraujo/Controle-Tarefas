package modelo;

import java.util.Timer;
import java.util.TimerTask;

import java.awt.EventQueue;

public class Cronometro {
    private Timer tm;
    private int contador = 0;
    private Tarefas taref;
    private int tempControl;
    
    public void cronometro(int tmp,Tarefas t){
        taref =t;
        tempControl = tmp;

        EventQueue.invokeLater(new Runnable(){ 
            @Override
            public void run(){
                if(getTempControl()==0) initCrono();
                else finCrono();
            }             
        });
    } 

    //inicia contador(por enquanto finaliza a contagem com um inteiro enviado do app)
    public void initCrono(){
        setTm(new Timer());
        getTm().scheduleAtFixedRate(new TimerTask(){
        @Override
            public void run(){
                setContador(getContador()+1);
            }
        }, 1000,1000);
    }

    //finaliza contagem e zera contaor
    public void finCrono(){
        getTm().cancel();//esta com problema ao recomeçar isso aqui nao permite iniciar novamente o cronometro
        getTaref().setTempReal(getContador()+getTaref().getTempReal());
        setContador(0);
        System.out.println("O tempo total gasto na tarefa: "+getTaref().getNome()+" é de: "+getTaref().getTempReal());
    }

    public Timer getTm(){
        return tm;
    }
    public void setTm(Timer tm){
        this.tm = tm;
    }
    public int getContador(){
        return contador;
    }
    public void setContador(int contador){
        this.contador=contador;
    }
    public int getTempControl(){
        return tempControl;
    }
    public void setTempControl(int tempControl){
        this.tempControl = tempControl;
    }
    public Tarefas getTaref(){
        return taref;
    }
    public void setTaref(Tarefas taref){
        this.taref = taref;
    }
}