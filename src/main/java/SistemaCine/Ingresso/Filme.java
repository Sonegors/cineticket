package SistemaCine.Ingresso;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Filme {
    public static void cadastrarNovoFilme() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Gênero: ");
        String genero = scanner.nextLine();

        System.out.print("Idade Mínima: ");
        int idadeMinima = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tempo: ");
        int tempo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tecnologia (2D/3D): ");
        String tecnologia = scanner.nextLine();

        System.out.print("Poltronas Disponíveis: ");
        int poltronasDisponiveis = scanner.nextInt();
        scanner.nextLine();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://containers-us-west-83.railway.app:7123/railway", "postgres", "TeEupmjFClfn7Ppvn1jk")) {
            String cadastrarFilmeQuery = "INSERT INTO filmes (titulo, genero, idade_minima, tempo, valor, tecnologia, poltronas_disponiveis) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cadastrarFilmeStatement = connection.prepareStatement(cadastrarFilmeQuery);
            cadastrarFilmeStatement.setString(1, titulo);
            cadastrarFilmeStatement.setString(2, genero);
            cadastrarFilmeStatement.setInt(3, idadeMinima);
            cadastrarFilmeStatement.setInt(4, tempo);
            cadastrarFilmeStatement.setDouble(5, valor);
            cadastrarFilmeStatement.setString(6, tecnologia);
            cadastrarFilmeStatement.setInt(7, poltronasDisponiveis);
            cadastrarFilmeStatement.executeUpdate();

            System.out.println("Filme cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ...
}
