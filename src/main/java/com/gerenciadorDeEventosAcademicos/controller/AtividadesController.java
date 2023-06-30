package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Participante;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.function.Consumer;

public class AtividadesController implements Observer{

    private Model model;
    private AtividadesView view;

    public void initAtividadesController(Model model, AtividadesView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void escolhaUsuario(int escolhaUsuario){

        switch (escolhaUsuario){

            case 1:
                view.getAtividadeEscolhida().getParticipantesDaAtividade().add((Participante) model.getUsuarioAutenticado());
            case 2:
                view.getAtividadeEscolhida().getParticipantesDaAtividade().forEach(participante -> System.out.println("Participante : " + participante.getNome()));
            case 3:
                model.voltar();
            case 4:
                model.deslogarUsuario();
        }
    }


    @Override
    public void update() {

    }
}
