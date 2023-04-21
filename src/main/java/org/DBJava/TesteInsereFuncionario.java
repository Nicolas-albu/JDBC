package org.DBJava;

import org.Database.Funcionario;
import org.Database.FuncionarioDAO;

import java.util.Scanner;

public class TesteInsereFuncionario {
    private static Scanner readInputs = new Scanner(System.in);

    public static void main(String[] args) {
        FuncionarioDAO DAO = new FuncionarioDAO();
        DAO.addEmployee(getEmployee());

        readInputs.close();
    }

    private static String tryGetData(String message) {
        String nameEmployee = null;
        while (true) {
            System.out.print(message);
            nameEmployee = readInputs.nextLine();
            if (nameEmployee.isEmpty()) {
                System.out.println("Não pode ficar sem inserir.\n");
                continue;
            }
            break;
        }

        return nameEmployee;
    }

    private static Funcionario getEmployee() {
        Funcionario newEmployee = new Funcionario();
        newEmployee.setName(tryGetData("Insira o seu nome: "));
        newEmployee.setUser(tryGetData("Insira o seu usuário: "));
        newEmployee.setPassword(tryGetData("Insira uma senha: "));

        return newEmployee;
    }
}
