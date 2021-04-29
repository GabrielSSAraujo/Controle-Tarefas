package controle;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

import modelo.*;
/**
 * Realiza o CRUD projeto, busca de projetos e faz a verificação dos dados do projeto 
 *
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class ControleProjeto{

    private Projeto[] arrayProjeto = new Projeto[15];
    private int numProjetos=0;

    /**
     * Cadastra projeto
     * @param projeto
     * @return
     */
    //cadastrando projetos e verificando se há alguma posição nula para ser preenchida
    public boolean cadastroProjeto(Projeto pro){
        //validando datas
        boolean ret = false;
        boolean verDi = isDateValid(pro.getDataTermino());
        boolean verDf = isDateValid(pro.getDataTermino());

        int qtd=0;
        if(verDi==true && verDf==true){
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
        }
        //caso a chave seja 0, deve incrementar o numero de projetos pois nao havia posição nula no vetor
        if(qtd==0){setNumProjetos(getNumProjetos()+1);}

        return ret;
    }
    
    /**
     * Edita projeto a partir da posição e nome do projeto recebidos como parâmetro
     * @param dataInicio
     * @param dataTermino
     * @param nomeProjeto
     * @param posicao
     * @return
     */
    public boolean editarProjeto(String di, String dt, String nome, int pos){

        boolean verDi = isDateValid(di);
        boolean verDf = isDateValid(dt);
        boolean ret = false;

        if(verDf==true && verDi==true){
            getArrProjetos(pos).setNome(nome);
            getArrProjetos(pos).setDataInicio(di);
            getArrProjetos(pos).setDataTermino(dt);
            ret = true;
        }
        return ret;
    }

    /**
     * Exclui projeto a partir da posição do projeto recebida como parâmetro
     * @param indice
     * @return
     */
    public boolean excluirProjeto( int ind){
        boolean ret;
        if(getArrProjetos(ind)==null){
            ind=-1;
        }
        if(ind>=0){

            setArrProjetos(null, ind); 
            ret=true;
        }else{ret=false;}

        return ret;
    }

    /**
     * Faz uma busca pelos projetos cadastrados e retorna um array com os nomes dos projetos
     * @return
     */
    public String[] getNomeProjeto() {
		String[] s = new String[getNumProjetos()];
		for(int i = 0; i < getNumProjetos(); i++) {
            if(getArrProjetos(i)!=null){
                s[i] = getArrProjetos(i).getNome();
            }
        }
		
		return s;
	}

    /**
     * Faz a validação das datas recebidas em formato de string
     * @param strDate
     * @return
     */
    public static boolean isDateValid(String strDate) {
        String dateFormat = "dd/MM/uuuu";
    
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
        .ofPattern(dateFormat)
        .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
           return false;
        } 
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
