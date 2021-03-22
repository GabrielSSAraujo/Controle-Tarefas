package controle;

import modelo.*;

public class CRUDProjeto{

    private Projeto[] arrayProjeto = new Projeto[15];
    private int numProjetos=0;

    //cadastrando projetos e verificando se há alguma posição nula para ser preenchida
    public void cadastroProjeto(Projeto pro){
        //chave para verificar se há posição nula
        int qtd=0;
        if(getNumProjetos()==0){setArrProjetos(pro, 0);}
        else{
            for(int i=0; i<getNumProjetos(); i++){
                if(getArrProjetos(i)==null){
                    setArrProjetos(pro, i);
                    //se houver posição nula a chave é 1
                    qtd=1;
                    break;
                }
                else{
                    setArrProjetos(pro, getNumProjetos());
                }
            }
        }
        //caso a chave seja 0, deve incrementar o numero de projetos pois nao havia posição nula no vetor
        if(qtd==0){setNumProjetos(getNumProjetos()+1);}
        
    }
    
    public void editarProjeto(Projeto pro, Projeto newPro){
        for(int j=0; j<getNumProjetos();j++){
            if(getArrProjetos(j) != null && pro.equals(getArrProjetos(j))){
                setArrProjetos(newPro, j);
            }
        }
    }

    public void excluirProjeto(Projeto pro){
        int key=0;
        for(int j=0; j<getNumProjetos();j++){
            if(getArrProjetos(j) != null && pro.equals(getArrProjetos(j))){
                System.out.println("\n apagando "+pro+"...\n");
                setArrProjetos(null, j);
                key++;
            }
        }
        if(key<1){System.out.println("Projeto "+pro+"nao encontrado\n");}
    }

    /*public void buscaProjetoCadTarefa(String name, Tarefas taref, int key){
        for(int j=0; j<getNumProjetos();j++){
            if(getArrProjetos(j) != null && name.equals(getArrProjetos(j).getNome())){
                if(key==0){
                    taref.setProjeto(getArrProjetos(j));
                    taref.cadastrar();
                }
                else if(key==1){
                    System.out.println(getArrProjetos(j).consultarTarefasCadastradas().toString());
                }

            }
        }
    } */

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
    public String consultarTarefasProjeto(Projeto pro){
        String saida = "";
        for (int i=0; i<getNumProjetos(); i++){
            if(getArrProjetos(i) != null && pro.equals(getArrProjetos(i))){
                saida  = saida + pro.consultarTarefasCadastradas();
            }
        } 
        
        return saida;
    }


}
