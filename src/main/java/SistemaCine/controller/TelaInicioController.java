package SistemaCine.controller;

import SistemaCine.Model.Usuario;
import SistemaCine.View.ClienteView;
import SistemaCine.View.FuncionarioView;
import SistemaCine.View.TelaInicioView;

public class TelaInicioController {
    private TelaInicioView telaInicioView;

    public TelaInicioController(TelaInicioView telaInicioView) {
        this.telaInicioView = telaInicioView;
    }

    public void iniciar() {
        int opcao;
        do {
            telaInicioView.mostrarMenuInicial();
            opcao = telaInicioView.lerOpcao();

            switch (opcao) {
                case 1:
                    // Lógica para efetuar login
                    // ...
                    // Exemplo: se login for bem-sucedido
                    boolean isCliente = true; // Define se é um cliente ou funcionário
                    if (isCliente) {
                        ClienteView telaClienteView = new ClienteView();
                        ClienteController clienteController = new ClienteController();
                        clienteController.executar();
                    } else {
                        FuncionarioView telaFuncionarioView = new FuncionarioView();
                        FuncionarioController funcionarioController = new FuncionarioController();
                        funcionarioController.executar();
                    }
                    break;
                case 2:
                    mostrarMenuCadastro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void mostrarMenuCadastro() {
        // ...
    }

    // ... outras funções
}
