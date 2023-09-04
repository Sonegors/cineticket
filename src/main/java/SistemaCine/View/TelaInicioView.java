package SistemaCine.View;


import java.util.Scanner;

public class TelaInicioView {
    private Scanner scanner;

    public TelaInicioView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuInicial() {
        System.out.println("===== TELA INICIAL =====");
        System.out.println("1. Login");
        System.out.println("2. Cadastro");
        System.out.println("0. Sair");
    }

    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public void mostrarMenuCadastro() {
        System.out.println("===== CADASTRO =====");
        System.out.println("1. Cadastrar como Cliente");
        System.out.println("2. Cadastrar como Funcionário");
        System.out.println("0. Voltar");
    }

    public String lerNome() {
        System.out.print("Nome: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int lerIdade() {
        System.out.print("Idade: ");
        return scanner.nextInt();
    }

    public String lerNovoUsername() {
        System.out.print("Novo Username: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public String lerNovoPassword() {
        System.out.print("Novo Password: ");
        return scanner.nextLine();
    }
}
