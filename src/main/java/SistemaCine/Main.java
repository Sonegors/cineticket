package SistemaCine;

import java.util.Scanner;
import SistemaCine.Menu.CadastroUsuario; // Importa a classe CadastroUsuario do pacote sistemaCine.Menu
import SistemaCine.Menu.Login; // Importa a classe Login do pacote sistemaCine.menu

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== MENU INICIAL =====");
            System.out.println("1. Entrar (TELA DE LOGIN)");
            System.out.println("2. Cadastrar (TELA DE CADASTRO)");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    Login.efetuarLogin(); // Chama a função de login
                    break;
                case 2:
                    CadastroUsuario.cadastrarNovoUsuario(); // Chama a função de cadastro de usuário
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
