package SistemaCine.Ingresso;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComprarIngresso {
    private String username;

    public ComprarIngresso(String username) {
        this.username = username;
    }

    public void listarFilmesEmCartaz(int classificacaoIndicativa) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
            String listarFilmesQuery = "SELECT id, titulo, genero, idade_minima FROM filmes WHERE idade_minima <= ?";
            PreparedStatement listarFilmesStatement = connection.prepareStatement(listarFilmesQuery);
            listarFilmesStatement.setInt(1, classificacaoIndicativa);
            ResultSet resultSet = listarFilmesStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                int idadeMinima = resultSet.getInt("idade_minima");

                System.out.println("ID: " + id);
                System.out.println("Título: " + titulo);
                System.out.println("Gênero: " + genero);
                System.out.println("Idade Mínima: " + idadeMinima);
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void visualizarIngressosComprados() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://<hostname>:<port>/database", "username", "password")) {
            String visualizarIngressosQuery = "SELECT f.titulo FROM ingressos i " +
                    "JOIN filmes f ON i.filme_id = f.id " +
                    "WHERE i.cliente_username = ?";
            PreparedStatement visualizarIngressosStatement = connection.prepareStatement(visualizarIngressosQuery);
            visualizarIngressosStatement.setString(1, username);
            ResultSet resultSet = visualizarIngressosStatement.executeQuery();

            System.out.println("Ingressos comprados:");
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                System.out.println("- " + titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ..
}
