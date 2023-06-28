package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.LoginTelaView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

public class LoginTelaController implements Observer {

    private Model model;
    private LoginTelaView view;

    public void tipoUsuario(int tipoUsuario){
        switch (tipoUsuario){
            case 1:
                this.usuario = ((Organizador) usuario);
            case 2:
                this.usuario = ((Palestrante) usuario);
            case 3:
                this.usuario = ((Participante) usuario);
            default:
                ;
        }
    }
    public void initLoginTelaController(Model model, LoginTelaView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                Usuario usuario = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if (usuario == null) {
                    view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
                } else {
                    view.exibeMSG("SUCESSO: Usuario autenticado!");
                }
                model.detachObserver(this);
                break;
        }
    }

    public void update(){

    }
}
