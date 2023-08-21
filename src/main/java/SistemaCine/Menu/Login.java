package SistemaCine.Menu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

public class Login {
    public static void efetuarLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://postgres:TeEupmjFClfn7Ppvn1jk@containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
            String buscarUsuarioQuery = "SELECT password FROM usuarios WHERE username = ?";
            PreparedStatement buscarUsuarioStatement = connection.prepareStatement(buscarUsuarioQuery);
            buscarUsuarioStatement.setString(1, username);
            ResultSet resultSet = buscarUsuarioStatement.executeQuery();

            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("password");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    System.out.println("Login bem-sucedido!");

                    // Implemente a lógica para direcionar para a tela de cliente ou funcionário
                } else {
                    System.out.println("Senha incorreta.");
                }
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
}
