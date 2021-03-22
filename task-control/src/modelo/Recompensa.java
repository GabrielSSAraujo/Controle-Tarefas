package modelo;

public class Recompensa {
    private int tempoRecompensa;
    private String[] nomeRecompensas = new String[5];

    public Recompensa(){
        setTempoRecompensa(20);
        setRecompensas("ASSISTIR SERIE/FILME", 0);
        setRecompensas("REDES SOCIAIS", 1);
        setRecompensas("LER LIVRO", 2);
        setRecompensas("JOGAR", 3);
        setRecompensas("BARZINHO <3", 4);
    }

    public int getTempoRecompensa(){
        return tempoRecompensa;
    }
    public void setTempoRecompensa(int tempoRecompensa){
        this.tempoRecompensa = tempoRecompensa;
    }
    public String[] getNomeRecompensa(){
        return this.nomeRecompensas;
    }
    public void setNomeRecompensas(String[] s){
        this.nomeRecompensas = s;
    }
    public String getRecompensas(int i){
        return nomeRecompensas[i];
    }
    public void setRecompensas(String recomp, int i){
        this.nomeRecompensas[i]= recomp;
    }

    public String consultarRecompensasCadastradas() {
		String saida = "\n***** Lista de recompensas cadastradas*****\n" ;
		for(int i = 0; i <5; i++) {
            saida = saida + "\n" +getTempoRecompensa()+" min-"+ getRecompensas(i);
		}
		return saida;
	}
    
}
