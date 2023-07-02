package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.LoginView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

public class LoginController implements Observer {

    private Model model;
    private LoginView view;

    public void initLoginTelaController(Model model, LoginView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                Usuario usuario = model.getUsuario();
                if (usuario == null) {
                    view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
                    model.voltarPaginaInicial();
                } else {
                    view.exibeMSG("SUCESSO: Usuario autenticado!");
                    PaginaEventosView pagina = new PaginaEventosView();
                    pagina.initPaginaEventosView(model);
                }
                model.detachObserver(this);
        }
    }
    public void update(){

    }
}
