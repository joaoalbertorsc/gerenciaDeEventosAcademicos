package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

public class DetalhesEventoController implements Observer {

    private Model model;
    private DetalhesEventoView view;

    public void initDetalhesEventoController(Model model, PaginaEventosView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    @Override
    public void update() {

    }
}
