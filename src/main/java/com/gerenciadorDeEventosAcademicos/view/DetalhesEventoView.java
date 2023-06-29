package com.gerenciadorDeEventosAcademicos.view;

import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.controller.PaginaEventosController;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;

import java.util.ArrayList;

public class DetalhesEventoView implements Observer{

    private Model model;
    private DetalhesEventoController controller;
    private Evento eventoEscolhido;
    private ArrayList<Atividade> atividadesEvento;

    public void initPaginaEventosView(Model model, Evento evento) {
        this.model = model;
        this.eventoEscolhido = eventoEscolhido;
        controller = new DetalhesEventoController();
        controller.initDetalhesEventoController(model, this);
        model.attachObserver(this);
        evento.toString();
        atividadesDisponiveis();

    }

    public void atividadesDisponiveis(){
        atividadesEvento = eventoEscolhido.getAtividadesDoEvento();
        for (int i = 0; i < atividadesEvento.size(); i++) {
            System.out.println(i + " - " + atividadesEvento.get(i).getNome());
        }
    }

    public void escolherAtividade(){

    }

    @Override
    public void update() {

    }
}
