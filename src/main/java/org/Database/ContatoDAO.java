package org.Database;

import org.Resources.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDAO {

    private Connection connection = null;

    public ContatoDAO() {
        this.connection = ConnectionFactory.create();
    }

    public void adiciona(Contato contato) {
        String insertContato = "INSERT INTO CONTATOS (\"NOME\", \"EMAIL\", \"ENDERECO\", \"DATA_NASCIMENTO\") "
                + "VALUES (?,?,?,?);";

        try (PreparedStatement insertion = this.connection.prepareStatement(insertContato)) {
            insertion.setString(1, contato.getNome());
            insertion.setString(2, contato.getEmail());
            insertion.setString(3, contato.getEndereco());
            insertion.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            insertion.execute();

        } catch (SQLException error) {
            throw new DAOException();
        }
    }

    public List<Contato> getLista() {
        List<Contato> contatos = new ArrayList<>();
        String queryContatos = "SELECT * FROM CONTATOS;";

        try (PreparedStatement query = this.connection.prepareStatement(queryContatos);
             ResultSet resultQuery = query.executeQuery()) {

            while (resultQuery.next()) {
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(
                        resultQuery.getDate("DATA_NASCIMENTO"));

                Contato contato = new Contato(
                        resultQuery.getLong("ID"),
                        resultQuery.getString("NOME"),
                        resultQuery.getString("EMAIL"),
                        resultQuery.getString("ENDERECO"),
                        dataNascimento);

                contatos.add(contato);
            }

        } catch (SQLException error) {
            throw new DAOException();
        }

        return contatos;
    }

    public Contato pesquisar(int id) {
        // Escreva o método pesquisar querecebe um id (int) eretorna um objeto do tipo Contato.
        Contato contato = null;
        String queryCommand = "SELECT * FROM CONTATOS WHERE CONTATOS.\"ID\" = " + id;

        try (PreparedStatement query = this.connection.prepareStatement(queryCommand);
             ResultSet resultQuery = query.executeQuery()) {

            while (resultQuery.next()) {
                Calendar dataNascimento = Calendar.getInstance();
                dataNascimento.setTime(
                        resultQuery.getDate("DATA_NASCIMENTO"));

                contato = new Contato(
                        resultQuery.getLong("ID"),
                        resultQuery.getString("NOME"),
                        resultQuery.getString("EMAIL"),
                        resultQuery.getString("ENDERECO"),
                        dataNascimento);
            }

        } catch (SQLException error) {
            error.printStackTrace();
            throw new DAOException();
        }

        return contato;
    }


    public void altera(Contato contato) {
        String updateCommand = "UPDATE CONTATOS SET \"NOME\"=?, \"EMAIL\"=?, \"ENDERECO\"=?," +
                "\"DATA_NASCIMENTO\"=? WHERE \"ID\"=?";

        try (PreparedStatement updateExecution = connection.prepareStatement(updateCommand)){
            updateExecution.setString(1, contato.getNome());
            updateExecution.setString(2, contato.getEmail());
            updateExecution.setString(3, contato.getEndereco());
            updateExecution.setDate(4,
                    new Date(contato.getDataNascimento().getTimeInMillis()));
            updateExecution.setLong(5, contato.getId());
            updateExecution.execute();

        } catch (SQLException error) {
            throw new DAOException();
        }
    }

    public void remove(Long id) {
        String deleteCommand = "DELETE FROM CONTATOS WHERE \"ID\"=" + id;

        try (PreparedStatement deleteExecution = this.connection.prepareStatement(deleteCommand)){
            deleteExecution.execute();

        } catch (SQLException error) {
            throw new DAOException();
        }
    }

}
