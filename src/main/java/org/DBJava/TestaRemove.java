package org.DBJava;

import org.Database.Contato;
import org.Database.ContatoDAO;

import java.util.List;

public class TestaRemove {
    public static void main(String[] args) {
        ContatoDAO DAO = new ContatoDAO();
        List<Contato> contatos = DAO.getLista();
        DAO.remove(contatos.get(2).getId());
        System.out.println(contatos.get(2).getNome() + " Foi removido.");
    }
}
