package SistemaCine.controller;

import SistemaCine.View.ClienteView;

public class ClienteController {
    private final ClienteView clienteView;

    public ClienteController() {
        clienteView = new ClienteView();
    }

    public void executar() {
        int opcao;
        do {
            opcao = clienteView.mostrarMenu();

            switch (opcao) {
                case 1:
                    comprarIngressos();
                    break;
                case 2:
                    listarFilmesEmCartaz();
                    break;
                case 3:
                    visualizarIngressosComprados();
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
        } while (true);
    }

    private void comprarIngressos() {
        // Lógica para comprar ingressos
    }

    private void listarFilmesEmCartaz() {
        int classificacaoIndicativa = clienteView.lerClassificacaoIndicativa();
        // Lógica para listar filmes em cartaz
    }

    private void visualizarIngressosComprados() {
        // Lógica para visualizar ingressos comprados
    }
}
