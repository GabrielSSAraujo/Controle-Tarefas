package modelo;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

public class Cronometro {
    private Timer tm;
    private int contador = 0;
    private Tarefas taref;
    private int tempControl;
    private boolean rodando = false;
    private int contador2;
    private int key;
    
    public void cronometro(int tmp,Tarefas t){
        taref =t;
        tempControl = tmp;

        EventQueue.invokeLater(new Runnable(){ 
            @Override
            public void run(){
                if(getTempControl()==0){} //initCrono();
                else finCrono();
            }             
        });
    } 

    //inicia contador(por enquanto finaliza a contagem com um inteiro enviado do app)
    public void initCrono(JLabel contagem, Pomodoro pomo){
        if(!rodando){
            setTm(new Timer());
            getTm().scheduleAtFixedRate(new TimerTask(){
            @Override
                public void run(){
                    setContador(getContador()+1);
                    contador2 += 1;
                    int seg = contador % 60;
                    int min = contador/60;
                    int hora = min/60;
                    min %= 60;
                    contagem.setText(String.format("%02d:%02d:%02d",hora, min,seg));
                    //verificando se chegou no tempo do pomodoro
                    if(key==0){
                        if(contador2/60==pomo.getTempoTrabalho()){
                            notificarPomodoro();
                            key =1;
                            contador2=0;
                        }
                    }else{
                        if(contador2/60==pomo.getTempoDescanso()){
                            System.out.println("Agora ja acabou seu pomodoro, vai trabalhar vagabundo");
                            notificarPomodoro();
                            key=0;
                            contador2 =0;
                        }
                    }
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

    public void notificarPomodoro(){
        String esc;
        if(key==0) esc="descanso";
        else esc = "trabalho";
        JOptionPane.showMessageDialog(null, "Tempo de "+esc, null, 
				JOptionPane.INFORMATION_MESSAGE);
    }
}