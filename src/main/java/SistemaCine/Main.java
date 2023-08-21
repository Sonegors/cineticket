package SistemaCine;


import java.util.Scanner;
import SistemaCine.Menu.CadastroUsuario;
import SistemaCine.Menu.Login;
import SistemaCine.Usuario.Cliente;
import SistemaCine.Usuario.Funcionario;

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
                    System.out.println("Chamando Login.efetuarLogin()...");
                    String username = Login.efetuarLogin(); // Efetua login e recebe o username
                    System.out.println("Login concluído.");

                    if (username != null) {
                        // Continuar o fluxo com base no tipo de usuário
                        if (ehCliente(username)) {
                            Cliente cliente = new Cliente(username);
                            // Implementar ações do cliente
                            cliente.comprarIngressos();
                            cliente.listarFilmesEmCartaz(16);
                            cliente.visualizarIngressosComprados();
                        } else if (ehFuncionario(username)) {
                            Funcionario funcionario = new Funcionario(username);
                            // Implementar ações do funcionário
                            funcionario.comprarIngressos();
                            funcionario.listarFilmesEmCartaz(16); // Passar um valor válido de classificação indicativa
                            funcionario.visualizarIngressosComprados();
                            funcionario.excluirFilmeDoCartaz(1); // Passar um ID válido de filme
                        }
                    }
                    break;
                case 2:
                    System.out.println("Chamando CadastroUsuario.cadastrarNovoUsuario()...");
                    CadastroUsuario.cadastrarNovoUsuario(); // Chama a função de cadastro de usuário
                    System.out.println("Cadastro concluído.");
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

    private static boolean ehCliente(String username) {
        // Implemente a lógica para verificar se o username pertence a um cliente
        // Retorne true se for um cliente, ou false se não for
        return false; // Exemplo: retornando sempre false
    }

    private static boolean ehFuncionario(String username) {
        // Implemente a lógica para verificar se o username pertence a um funcionário
        // Retorne true se for um funcionário, ou false se não for
        return false; // Exemplo: retornando sempre false
    }
}
