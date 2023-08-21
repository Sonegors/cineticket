package SistemaCine.Usuario;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Funcionario {
    // ...

    public void excluirFilmeDoCartaz(int filmeId) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://<hostname>:<port>/database", "username", "password")) {
            String checkIngressosQuery = "SELECT COUNT(*) FROM ingressos WHERE filme_id = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkIngressosQuery);
            checkStatement.setInt(1, filmeId);
            ResultSet resultSet = checkStatement.executeQuery();
            resultSet.next();
            int numIngressos = resultSet.getInt(1);

            if (numIngressos == 0) {
                String deleteFilmeQuery = "DELETE FROM filmes WHERE id = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteFilmeQuery);
                deleteStatement.setInt(1, filmeId);
                deleteStatement.executeUpdate();
                System.out.println("Filme excluído com sucesso.");
            } else {
                System.out.println("O filme não pode ser excluído, pois ingressos foram vendidos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarFilmesEmCartaz() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://<hostname>:<port>/database", "username", "password")) {
            String listarFilmesQuery = "SELECT id, titulo, genero, idade_minima, tempo, valor, tecnologia, poltronas_disponiveis FROM filmes";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(listarFilmesQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                int idadeMinima = resultSet.getInt("idade_minima");
                int tempo = resultSet.getInt("tempo");
                double valor = resultSet.getDouble("valor");
                String tecnologia = resultSet.getString("tecnologia");
                int poltronasDisponiveis = resultSet.getInt("poltronas_disponiveis");

                System.out.println("ID: " + id);
                System.out.println("Título: " + titulo);
                System.out.println("Gênero: " + genero);
                System.out.println("Idade Mínima: " + idadeMinima);
                System.out.println("Tempo: " + tempo);
                System.out.println("Valor: " + valor);
                System.out.println("Tecnologia: " + tecnologia);
                System.out.println("Poltronas Disponíveis: " + poltronasDisponiveis);
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean efetuarLogin(String username, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://<hostname>:<port>/database", "username", "password")) {
            String loginQuery = "SELECT COUNT(*) FROM funcionarios WHERE user = ? AND password = ?";
            PreparedStatement loginStatement = connection.prepareStatement(loginQuery);
            loginStatement.setString(1, username);
            loginStatement.setString(2, password);
            ResultSet resultSet = loginStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void efetuarLogout() {
        // Implemente a lógica para efetuar logout
    }

    // ...
}
