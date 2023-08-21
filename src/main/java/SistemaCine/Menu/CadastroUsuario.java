package SistemaCine.Menu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        String password = scanner.nextLine();

        // Criptografar a senha antes de salvar
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://postgres:TeEupmjFClfn7Ppvn1jk@containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
            String cadastrarUsuarioQuery = "INSERT INTO usuarios (nome, role, idade, username, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement cadastrarUsuarioStatement = connection.prepareStatement(cadastrarUsuarioQuery);
            cadastrarUsuarioStatement.setString(1, nome);
            cadastrarUsuarioStatement.setString(2, role);
            cadastrarUsuarioStatement.setInt(3, idade);
            cadastrarUsuarioStatement.setString(4, username);
            cadastrarUsuarioStatement.setString(5, hashedPassword);
            cadastrarUsuarioStatement.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
}
