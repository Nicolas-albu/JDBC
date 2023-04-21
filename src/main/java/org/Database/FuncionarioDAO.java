package org.Database;

import org.Resources.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    private Connection databaseConnection = null;

    public FuncionarioDAO() {
        this.databaseConnection = ConnectionFactory.create();
    }

    public void addEmployee(Funcionario employee) {
        String insertEmployee = "INSERT INTO TB_EMPLOYEE (\"NAME\", \"USER\", \"PASSWORD\") VALUES (?,?,?)";

        try(PreparedStatement executionInsert = this.databaseConnection.prepareStatement(insertEmployee)) {
            executionInsert.setString(1, employee.getName());
            executionInsert.setString(2, employee.getUser());
            executionInsert.setString(3, employee.getPassword());
            executionInsert.execute();

        } catch (SQLException error) {
            throw new DAOException();
        }
    }
}
