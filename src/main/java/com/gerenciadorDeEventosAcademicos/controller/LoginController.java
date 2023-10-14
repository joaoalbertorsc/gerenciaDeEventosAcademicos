package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.LoginView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

public class LoginController implements Observer {

    private Model model;
    private LoginView view;

    public void initLoginTelaController(Model model, LoginView view) { // iniciando controller para login view;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) { // metodo para logar o usuario e levalo para a pagina de eventos apos o login ou voltar para a pagina inicial caso o login seja invalido;
        switch (event) {
            case "OK" :
                Usuario usuario = model.getUsuario();
                if (usuario == null) {
                    view.exibirMensagem("ERRO: Usuario e/ou Senha invalidos!");
                    model.voltarPaginaInicial();
                } else {
                    view.exibirMensagem("SUCESSO: Usuario autenticado!");
                    PaginaEventosView pagina = new PaginaEventosView();
                    pagina.initPaginaEventosView(model);
                }
                model.detachObserver(this);
        }
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public void update(){

    }
}
