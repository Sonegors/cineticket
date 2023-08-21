package SistemaCine.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

public class CadastroUsuario {
    public static void cadastrarNovoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Role (cliente/funcionario): ");
        String role = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String userPassword = scanner.nextLine();

        // Criptografar a senha antes de salvar
        String hashedPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://containers-us-west-83.railway.app:7123/railway";
            String user = "postgres";
            String dbPassword = "TeEupmjFClfn7Ppvn1jk";

            Connection connection = DriverManager.getConnection(url, user, dbPassword);

            String criarTabelaUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id SERIAL PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL," +
                    "role VARCHAR(20) NOT NULL," +
                    "idade INT NOT NULL," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(60) NOT NULL" +
                    ")";

            String cadastrarUsuarioQuery = "INSERT INTO usuarios (nome, role, idade, username, password) VALUES (?, ?, ?, ?, ?)";

            // Criar a tabela "usuarios" se ela não existir
            try (PreparedStatement createTableStatement = connection.prepareStatement(criarTabelaUsuarios)) {
                createTableStatement.executeUpdate();
            }

            PreparedStatement cadastrarUsuarioStatement = connection.prepareStatement(cadastrarUsuarioQuery);
            cadastrarUsuarioStatement.setString(1, nome);
            cadastrarUsuarioStatement.setString(2, role);
            cadastrarUsuarioStatement.setInt(3, idade);
            cadastrarUsuarioStatement.setString(4, username);
            cadastrarUsuarioStatement.setString(5, hashedPassword);
            cadastrarUsuarioStatement.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
}
