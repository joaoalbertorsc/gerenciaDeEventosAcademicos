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
        System.out.println("TELA DE LOGIN");
        System.out.println("======================");
        System.out.println();
        System.out.print("Login: ");
        login = scanner.nextLine();
        System.out.print("Senha: ");
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

    public void update(){

    }
    public void handleEvent(String event){

        switch (event){
            case "OK":

        }

    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
}
