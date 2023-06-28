package com.gerenciadorDeEventosAcademicos.view;

import com.gerenciadorDeEventosAcademicos.controller.LoginTelaController;
import com.gerenciadorDeEventosAcademicos.model.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

public class LoginTelaView implements Observer{
    private Model model;
    private LoginTelaController controller;
    private String login;
    private String senha;
    private Usuario usuario;

    public void initLoginTelaView(Model model){
        this.model = model;
        controller = new LoginTelaController();
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

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
}
