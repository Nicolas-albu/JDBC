package org.DBJava;

import org.Database.Contato;
import org.Database.ContatoDAO;

import java.util.Calendar;


/*
 * [3].Escreva uma classe de testes com o método main Para testar o DAO. Por exemplo, uma chamada TestaInsere. Crie um novo
 * objeto Contato com dados de teste echamar a nova classe ContatoDao para adicioná-lo ao banco de dados.
 */
public class TestaInsere {
    public static void main(String[] args) {
        ContatoDAO ManipulationContatoDb = new ContatoDAO();
        Contato contatoRubens = new Contato(
                "Ricardo", "ricardo@ifal.edu.br", "IFAL", Calendar.getInstance());
        ManipulationContatoDb.adiciona(contatoRubens);
        System.out.println("Gravado no banco de dados");
    }
}
