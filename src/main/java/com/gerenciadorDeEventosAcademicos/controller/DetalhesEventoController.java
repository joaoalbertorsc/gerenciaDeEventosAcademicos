package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

import java.util.Scanner;

public class DetalhesEventoController implements Observer {

    private Model model;
    private DetalhesEventoView view;
    private int numeroAtividadeEscolhida;
    private Atividade atividadeEscolhida;

    public void initDetalhesEventoController(Model model, DetalhesEventoView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(int escolhaUsuario, Evento evento){

        switch (escolhaUsuario){
            case 1:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarEvento(evento, model);
                    chamarDetalhesEventoView(model, evento);
                } else {
                    escolherAtividade();
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    if (model.getAtividadesCadastrados().isEmpty()) {
                        view.exibirMensagem(DetalhesEventoView.msgNenhumaAtividadeCadastrada);
                        chamarDetalhesEventoView(model, evento);
                    }
                    escolherAtividade();
                } else {
                    model.voltarPaginaInicial();
                }
            case 3:
                if (model.getUsuario() instanceof Organizador) {
                    Organizador organizador = (Organizador) model.getUsuario();
                    Atividade novaAtividade = organizador.criarAtividade();
                    model.getAtividadesCadastrados().add(novaAtividade);
                    view.exibirMensagem(DetalhesEventoView.msgAtividadeEncontradaSucesso);
                    chamarDetalhesEventoView(model, evento);
                } else {
                    model.deslogarUsuario();
                }
            case 4:
                model.getEventosCadastrados().remove(evento);
                view.exibirMensagem(DetalhesEventoView.msgEventoExcluidoSucesso);
                chamarPaginaEventosView(model);
            case 5:
                model.voltarPaginaInicial();
            case 6:
                model.deslogarUsuario();

        }
    }

    public void chamarPaginaEventosView(Model model){
        PaginaEventosView view1 = new PaginaEventosView();
        view1.initPaginaEventosView(model);
    }
    public void chamarDetalhesEventoView(Model model, Evento evento){
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void escolherAtividade() throws NullPointerException{
        Scanner scanner = new Scanner(System.in);
        view.totalAtividadesDisponiveis();
        view.exibirMensagem(DetalhesEventoView.msgDigiteNumeroCorrespondente);
        numeroAtividadeEscolhida = scanner.nextInt();
        try{
            atividadeEscolhida = model.getAtividadesCadastrados().get(numeroAtividadeEscolhida-1);
            AtividadesView view1 = new AtividadesView();
            view1.initAtividadesView(model, atividadeEscolhida);
        } catch (NullPointerException exception){
            view.exibirMensagem(DetalhesEventoView.msgNenhumaAtividadeCorrespondente);
            DetalhesEventoView view1 = new DetalhesEventoView();
            view1.initDetalhesEventoView(model, view.getEventoEscolhido());
        }
    }
    @Override
    public void update() {

    }
}
