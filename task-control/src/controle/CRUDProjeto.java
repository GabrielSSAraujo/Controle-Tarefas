package controle;
import java.util.*;

import modelo.*;

public class CRUDProjeto{

    private Projeto[] arrayProjeto = new Projeto[15];
    private int numProjetos=0;

    //cadastrando projetos e verificando se há alguma posição nula para ser preenchida
    public boolean cadastroProjeto(Projeto pro){
        //chave para verificar se há posição nula
        boolean ret = false;
        int qtd=0;
        if(getNumProjetos()==0){setArrProjetos(pro, 0); ret=true;}
        else{
            for(int i=0; i<getNumProjetos(); i++){
                if(getArrProjetos(i)==null){
                    setArrProjetos(pro, i);
                    //se houver posição nula a chave é 1
                    qtd=1;
                    ret=true;
                    break;
                }
                else{
                    setArrProjetos(pro, getNumProjetos());
                    ret=true;
                }
            }
        }
        //caso a chave seja 0, deve incrementar o numero de projetos pois nao havia posição nula no vetor
        if(qtd==0){setNumProjetos(getNumProjetos()+1);}

        return ret;
    }
    
    public boolean editarProjeto(Date di, Date dt, String nome, int pos){
        getArrProjetos(pos).setNome(nome);
        getArrProjetos(pos).setDataInicio(di);
        getArrProjetos(pos).setDataTermino(dt);

        return true;
    }

    public boolean excluirProjeto(int ind){
        boolean ret;
        if(ind>=0){
            setArrProjetos(null, ind); 
            ret=true;
        }else{ret=false;}

        return ret;
    }

    public String[] getNomeProjeto() {
		String[] s = new String[getNumProjetos()];
		for(int i = 0; i < getNumProjetos(); i++) {
            if(getArrProjetos(i)!=null){
                s[i] = getArrProjetos(i).getNome();
            }
        }
		
		return s;
	}

    public int getNumProjetos(){
        return numProjetos;
    }
    public void setNumProjetos(int numProjetos){
        this.numProjetos = numProjetos;
    }
    public Projeto[] getArrayProjetos(){
        return this.arrayProjeto;
    }
    public void setArrayProjetos(Projeto[] p){
        this.arrayProjeto = p;
    }
    public Projeto getArrProjetos(int i){
        return arrayProjeto[i];
    }
    public void setArrProjetos(Projeto projetos, int i){
        this.arrayProjeto[i] = projetos;
    }

    public String consultarProjetosCadastrados() {
		String saida = "***** Lista de projetos cadastrados ***** \n" ;
		for(int i = 0; i < getNumProjetos(); i++) {
			if(getArrProjetos(i)!=null){
                saida = saida +i+"-"+ getArrProjetos(i)+"\n";
            }
		}
		return saida;
	}

}
