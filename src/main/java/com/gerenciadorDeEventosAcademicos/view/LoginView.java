package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.LoginController;
import com.gerenciadorDeEventosAcademicos.model.*;
import java.util.Scanner;

public class LoginView implements Observer{
    private Model model;
    private LoginController controller;
    private String login;
    private String senha;
    private Usuario usuario;

    public void initLoginView(Model model){ // iniciando a view de login
        this.model = model;
        controller = new LoginController();
        controller.initLoginTelaController(model, this);
        model.attachObserver(this);
        logarUsuario();

    }

    private void logarUsuario() { // view de login
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("|       TELA DE LOGIN       |");
        System.out.println("=============================");
        System.out.println();
        System.out.print("Digite o seu ID: ");
        login = scanner.nextLine();
        System.out.print("Digite a sua senha: ");
        senha = scanner.nextLine();
        model.autenticarUsuario(login, senha);
        controller.handleEvent("OK");
        model.detachObserver(this);
    }
    public static String msgErroUsuarioSenhaInvalido = "ERRO: Usuario e/ou Senha invalidos!";
    public static String msgSucessoUsuarioAutenticado = "SUCESSO: Usuario autenticado!";
    public void exibirMensagem(String mensagem) { // Exibir menagem de erro ou sucesso dependendo do resultado do login
        System.out.println();
        System.out.println(mensagem);
        System.out.println();
    }
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public LoginController getController() {
        return controller;
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void update(){
    }
}
