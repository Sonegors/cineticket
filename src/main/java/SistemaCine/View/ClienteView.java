package SistemaCine.View;

import java.util.Scanner;

public class ClienteView {
    private final Scanner scanner;

    public ClienteView() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("===== MENU CLIENTE =====");
        System.out.println("1. Comprar Ingressos");
        System.out.println("2. Listar Filmes em Cartaz");
        System.out.println("3. Visualizar Ingressos Comprados");
        System.out.println("4. Efetuar Logout");
        System.out.println("0. Sair");

        return scanner.nextInt();
    }

    public int lerClassificacaoIndicativa() {
        System.out.print("Informe a classificação indicativa desejada: ");
        return scanner.nextInt();
    }





    // Outros métodos de interação com o cliente
}
