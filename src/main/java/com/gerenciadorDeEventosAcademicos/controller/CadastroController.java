package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.CadastroView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import javax.script.SimpleScriptContext;

public class CadastroController implements Observer {

    private Model model;
    private CadastroView view;
    private Usuario usuario;

    public void initCadastroController(Model model, CadastroView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                tipoUsuario(view.getTipoUsuario());
                usuario.setId(view.getId());
                usuario.setEmail(view.getEmail());
                usuario.setNome(view.getNome());
                usuario.setSenha(view.getSenha());
                model.setUsuario(usuario);
                model.detachObserver(this);
                break;
        }
    }

    public void tipoUsuario(int tipoUsuario){
        switch (tipoUsuario){
            case 1:
                usuario = new Participante();
            case 2:
                usuario = new Palestrante();
            case 3:
                usuario = new Organizador();

        }
    }

    @Override
    public void update() {

    }
}
