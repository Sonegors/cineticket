package SistemaCine;

import SistemaCine.Model.Filme;
import SistemaCine.Model.Usuario;
import SistemaCine.View.TelaInicioView;
import SistemaCine.controller.ClienteController;
import SistemaCine.View.ClienteView;
import SistemaCine.View.FuncionarioView;



public class Main {
    public static void main(String[] args) {


         // Usuario usuario = new Usuario();
        //  Usuario.cadastrarNovoUsuario();

       // Filme cadastro = new Filme();
        //Filme.cadastrarNovoFilme();


        TelaInicioView telaInicioView = new TelaInicioView();
        telaInicioView.mostrarMenuInicial();

        TelaInicioView telaInicio = new TelaInicioView();
        telaInicio.lerOpcao();


        //ClienteView clienteView = new ClienteView();
        //clienteView.mostrarMenu();


        //FuncionarioView funcionarioView = new FuncionarioView();
        //funcionarioView.mostrarMenu();

       // ClienteController clientecontroller = new ClienteController();
        //clientecontroller.executar();




    }
}
