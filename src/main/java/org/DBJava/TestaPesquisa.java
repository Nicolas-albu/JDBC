package org.DBJava;

import org.Database.Contato;
import org.Database.ContatoDAO;

import java.text.SimpleDateFormat;

public class TestaPesquisa {
    public static void main(String[] args) {
        Contato contato = new ContatoDAO().pesquisar(5);
        SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println(String.format(
                    "Contato %s: ", contato.getId()));
            System.out.println("Nome: " + contato.getEmail());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println(String.format(
                    "Data de Nascimento: %s\n",
                    formatterData.format(
                            contato.getDataNascimento().getTime())));
        }

}

