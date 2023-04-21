package org.DBJava;

import org.Database.Contato;
import org.Database.ContatoDAO;

import java.util.Calendar;

public class TestaAltera {
    public static void main(String[] args) {
        ContatoDAO manipulatorContato = new ContatoDAO();

        Contato newContato = new Contato(
                4L,
                "Robertinho",
                "roberto@outlook.com",
                "Benedito Bentes",
                Calendar.getInstance());

        manipulatorContato.altera(newContato);
    }
}
