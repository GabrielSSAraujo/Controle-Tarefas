package modelo;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import java.awt.EventQueue;

public class Cronometro {
    private Timer tm;
    private int contador = 0;
    private Tarefas taref;
    private int tempControl;
    private boolean rodando = false;
    private int key;
    
    public void cronometro(int tmp,Tarefas t){
        taref =t;
        tempControl = tmp;

        EventQueue.invokeLater(new Runnable(){ 
            @Override
            public void run(){
                if(getTempControl()==0) initCrono(null);
                else finCrono();
            }             
        });
    } 

    //inicia contador(por enquanto finaliza a contagem com um inteiro enviado do app)
    public void initCrono(JLabel contagem){
        if(!rodando){
            setTm(new Timer());
            getTm().scheduleAtFixedRate(new TimerTask(){
            @Override
                public void run(){
                    setContador(getContador()+1);
                    int seg = contador % 60;
                    int min = contador/60;
                    int hora = min/60;
                    min %= 60;
                    contagem.setText(String.format("%02d:%02d:%02d",hora, min,seg));
                }
            }, 1000,1000);
            rodando=true;
        }
    }

    //finaliza contagem e zera contaor
    public void finCrono(){
        if(rodando){
            getTm().cancel();//esta com problema ao recomeçar isso aqui nao permite iniciar novamente o cronometro
            rodando = false;
            getTaref().setTempReal(getContador()+getTaref().getTempReal());
            setContador(0);
            System.out.println("O tempo total gasto na tarefa: "+getTaref().getNome()+" é de: "+getTaref().getTempReal());
        }
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