package testes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import controle.ControleProjeto;
import controle.ControleTarefas;
import modelo.Projeto;
import modelo.Tarefas;

/**
 * Criacao de testes para validacao de tarefas cadastradas
 * @author Gabriel Santos
 * @version 1.0 (27/04)
 */
public class TesteTarefas {

    ControleProjeto contP = new ControleProjeto();
    Projeto proj = new Projeto( "02/05/2021","30/06/2021", "testeJunit");
    ControleTarefas cadT = new ControleTarefas();
    Tarefas taref = new Tarefas("tarefa teste Junit", "21/03/2021", "21/03/2021", 10, "Descrição da tarefa", "urgente", proj);

    boolean expectedResult= true;

    @Test
    /**
     * Testa o cadastro de tarefas que retorna um boolean
     */
    public void testCadastroTarefa(){

        boolean result = cadT.cadastroTarefa(taref);

        assertEquals((boolean)expectedResult,(boolean)result);
    }
}
