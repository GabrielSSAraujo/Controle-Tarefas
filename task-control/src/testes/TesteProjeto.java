package testes;

import static org.junit.Assert.assertEquals;
import java.text.SimpleDateFormat;
import org.junit.Test;
import controle.ControleProjeto;
import modelo.Projeto;

/**
 * Criacao de testes para validacao do c�digo
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class TesteProjeto {


    private SimpleDateFormat formatador = new SimpleDateFormat("DD/MM/yyyy");

    ControleProjeto contP = new ControleProjeto();
    Projeto proj = new Projeto( "02/05/2021","30/06/2021", "testeJunit");

    boolean expectedResultBol = true;

    @Test
    /**
     * Teste do cadastro de projetos
     */
    public void testCadastro(){

        //Cadastrando projeto testeJunit com data de início: 02/05/2021 termino: 23/06/2021
        boolean result = contP.cadastroProjeto(proj);
        //retorno experado

        assertEquals((boolean)expectedResultBol,(boolean)result);
    }
    @Test
    /**
     * Teste de edi��o de projetos
     */
    public void testEditar(){
        //cadastrando projeto a ser editado
        contP.cadastroProjeto(proj);

        //Enviando posição a ser editado 
        //(como apenas 1 foi cadastrado so tem projeto na posição 0)
        boolean result = contP.editarProjeto( "02/05/2021","30/06/2021", "testeJunit", 0);

        assertEquals((boolean)expectedResultBol,(boolean)result);
    }

    @Test
    /**
     * Teste exclus�o de projetos
     */
    public void testExcluir(){

        //cadastrando projeto a ser excluido
        contP.cadastroProjeto(proj);

        //Enviando posição a ser excluido o projeto 
        //(como apenas 1 foi cadastrado so tem projeto na posição 0)
        boolean result = contP.excluirProjeto(0);

        assertEquals((boolean)expectedResultBol,(boolean)result);

    }

}
