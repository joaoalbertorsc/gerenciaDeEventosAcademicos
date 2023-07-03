package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.CadastroView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

public class CadastroController implements Observer {
    private Model model;
    private CadastroView view;
    public void initCadastroController(Model model, CadastroView view) { // iniciando o controller para a view de cadastro;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) { // de acordo com os dados inseridos está sendo cadastrado um novo usuario;
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

    public void tipoUsuario(int tipoUsuario){ // metodo para definir o tipo de conta que o usuario deseja criar;
        switch (tipoUsuario){
            case 1:
                Usuario usuario1 = new Participante();
                Participante participante = (Participante) usuario1;
                model.setUsuario(participante);
                model.getParticipantesLista().add(participante);
                break;
            case 2:
                Usuario usuario2 = new Palestrante();
                Palestrante palestrante = (Palestrante) usuario2;
                model.setUsuario(palestrante);
                model.getPalestrantesLista().add(palestrante);
                break;

            case 3:
                Usuario usuario3 = new Organizador();
                Organizador organizador = (Organizador) usuario3;
                model.setUsuario(organizador);
                model.getOrganizadoresLista().add(organizador);
                break;
        }
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public CadastroView getView() {
        return view;
    }
    public void setView(CadastroView view) {
        this.view = view;
    }
    @Override
    public void update() {

    }
}
