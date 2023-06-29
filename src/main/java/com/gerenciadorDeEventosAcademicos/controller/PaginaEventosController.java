package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

import java.util.ArrayList;

public class PaginaEventosController implements Observer {

    private Model model;
    private PaginaEventosView view;
    private Evento eventoEscolhido;


    public void initPaginaEventosController(Model model, PaginaEventosView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                view.getListaEventosCadastrados().get(view.getNumeroEventoEscolhido());
                eventoEscolhido = view.getListaEventosCadastrados().get(view.getNumeroEventoEscolhido();
                initDetalhesEventosView(Model model, Evento eventoEscolhido);
        }
    }


    @Override
    public void update() {

    }
}
