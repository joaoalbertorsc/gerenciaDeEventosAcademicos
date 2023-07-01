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

    public void initLoginView(Model model){
        this.model = model;
        controller = new LoginController();
        controller.initLoginTelaController(model, this);
        model.attachObserver(this);
        logarUsuario();

    }

    private void logarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============");
        System.out.println("TELA DE LOGIN");
        System.out.println("=============");
        System.out.println();
        System.out.print("Digite o seu ID: ");
        login = scanner.nextLine();
        System.out.print("Digite a sua senha: ");
        senha = scanner.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
    public void update(){
    }
}
