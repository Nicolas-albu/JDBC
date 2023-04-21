package org.DBJava;

import org.Database.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.create()){
            System.out.println("Conexão aberta.");
        } catch (SQLException error) {
            System.out.println("Ocorreu um erro.");
            error.printStackTrace();
        }
    }
}
