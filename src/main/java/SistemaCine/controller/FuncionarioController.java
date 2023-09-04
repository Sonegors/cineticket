package SistemaCine.controller;


import SistemaCine.Model.Filme;
import SistemaCine.View.ClienteView;
import SistemaCine.View.FuncionarioView;

public class FuncionarioController {
    private FuncionarioView funcionarioView;

    public FuncionarioController() {
        funcionarioView = new FuncionarioView();
    }

    public void executar() {
        int opcao;
        do {
            opcao = funcionarioView.mostrarMenu();

            switch (opcao) {
                case 1:
                    cadastrarFilme();
                    break;
                case 2:
                    excluirFilmeDoCartaz();
                    break;
                case 3:
                    listarFilmesEmCartaz();
                    break;
                case 4:
                    System.out.println("Efetuando Logout...");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void cadastrarFilme() {


        Filme filme = new Filme();
        filme.getClass();



        // Lógica para cadastrar filmes
    }

    private void excluirFilmeDoCartaz() {
        // Lógica para excluir filme do cartaz
    }

    private void listarFilmesEmCartaz() {
        // Lógica para listar filmes em cartaz
    }
}
