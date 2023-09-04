package SistemaCine.View;

import java.util.Scanner;

public class FuncionarioView {
    private Scanner scanner;

    public FuncionarioView() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("===== MENU FUNCIONÁRIO =====");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Excluir Filme do Cartaz");
        System.out.println("3. Listar Filmes em Cartaz");
        System.out.println("4. Efetuar Logout");
        System.out.println("0. Sair");

        return scanner.nextInt();
    }

    // Outros métodos de interação com o funcionário
}
