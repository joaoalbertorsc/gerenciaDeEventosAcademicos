package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.CadastroView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

public class CadastroController implements Observer {

    private Model model;
    private CadastroView view;



    public void initCadastroController(Model model, CadastroView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                tipoUsuario(view.getTipoUsuario());
                model.getUsuario().setId(view.getId());
                model.getUsuario().setEmail(view.getEmail());
                model.getUsuario().setNome(view.getNome());
                model.getUsuario().setSenha(view.getSenha());
                model.setUsuarioSistema(model.getUsuario());
                model.detachObserver(this);
                break;
        }
    }

    public void tipoUsuario(int tipoUsuario){
        switch (tipoUsuario){
            case 1:
                Usuario usuario1 = new Participante();
                Participante participante = (Participante) usuario1;
                model.setUsuario(participante);
                model.getParticipantesLista().add(participante);
            case 2:
                Usuario usuario2 = new Palestrante();
                Palestrante palestrante = (Palestrante) usuario2;
                model.setUsuario(palestrante);
                model.getPalestrantesLista().add(palestrante);

            case 3:
                Usuario usuario3 = new Organizador();
                Organizador organizador = (Organizador) usuario3;
                model.setUsuario(organizador);
                model.getOrganizadoresLista().add(organizador);
        }
    }

    @Override
    public void update() {

    }
}
