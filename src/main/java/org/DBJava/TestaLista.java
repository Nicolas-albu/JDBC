package org.DBJava;

import org.Database.Contato;
import org.Database.ContatoDAO;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestaLista {
    public static void main(String[] args) {
        List<Contato> contatos = new ContatoDAO().getLista();
        SimpleDateFormat formatterData = new SimpleDateFormat("dd/MM/yyyy");

        for(Contato contato : contatos) {
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
}
