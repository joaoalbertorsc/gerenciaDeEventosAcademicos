package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.CadastroView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

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
                model.setUsuarioSistema(usuario);
                model.detachObserver(this);
                break;
        }
    }

    public void tipoUsuario(int tipoUsuario){
        switch (tipoUsuario){
            case 1:
                Usuario usuario1 = new Participante();
                Participante participante = (Participante) usuario1;
                this.usuario = participante;
                model.getParticipantesLista().add(participante);
            case 2:
                Usuario usuario2 = new Palestrante();
                Palestrante palestrante = (Palestrante) usuario2;
                this.usuario = palestrante;
                model.getPalestrantesLista().add(palestrante);

            case 3:
                Usuario usuario3 = new Organizador();
                Organizador organizador = (Organizador) usuario3;
                this.usuario = organizador;
                model.getOrganizadoresLista().add(organizador);
        }
    }

    @Override
    public void update() {

    }
}
