package SistemaCine.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Funcionario {
    private String username;

    public Funcionario(String username) {
        this.username = username;
    }

    public void comprarIngressos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ID do filme: ");
        int filmeId = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
            String verificarFilmeQuery = "SELECT COUNT(*) FROM filmes WHERE id = ?";
            PreparedStatement verificarFilmeStatement = connection.prepareStatement(verificarFilmeQuery);
            verificarFilmeStatement.setInt(1, filmeId);
            ResultSet filmeResultSet = verificarFilmeStatement.executeQuery();
            filmeResultSet.next();
            int count = filmeResultSet.getInt(1);

            if (count > 0) {
                String comprarIngressoQuery = "INSERT INTO ingressos (cliente_username, filme_id) VALUES (?, ?)";
                PreparedStatement comprarIngressoStatement = connection.prepareStatement(comprarIngressoQuery);
                comprarIngressoStatement.setString(1, username);
                comprarIngressoStatement.setInt(2, filmeId);
                comprarIngressoStatement.executeUpdate();
                System.out.println("Ingresso comprado com sucesso!");
            } else {
                System.out.println("Filme não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
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

    public void excluirFilmeDoCartaz(int filmeId) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
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
}
