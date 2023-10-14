package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.MainView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

import java.util.Scanner;

public class PaginaEventosController implements Observer {

    private Model model;
    private PaginaEventosView view;
    public void initPaginaEventosController(Model model, PaginaEventosView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario) throws NullPointerException, IndexOutOfBoundsException{

        switch (escolhaUsuario){ // metodo de definicao para o caminho desejado do usuario a partir da view da pagina de eventos;
            case 1 :
                Scanner sc = new Scanner(System.in);
                if (model.getEventosCadastrados().isEmpty()){
                    view.exibirMensagem("Nenhum evento cadastrado...");
                    chamarMainView(model);
                } else {
                    eventosDisponiveis();
                    view.exibirMensagem("Digite o numero do evento desejado: ");
                    int numEvento;
                    numEvento = sc.nextInt();
                    numEvento-=1;
                    try{
                        Evento eventoEscolhido = model.getEventosCadastrados().get(numEvento);
                        chamarDetalhesDoEventoView(model, eventoEscolhido);
                    } catch (NullPointerException | IndexOutOfBoundsException e){
                        view.exibirMensagem("ID invalido.\nConfira o numero e tente novamente.");
                        chamarPaginaEventosView(model);
                    }
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    Evento novoEvento = organizador.criarEvento();
                    model.getEventosCadastrados().add(novoEvento);
                    novoEvento.setOrganizador((Organizador) model.getUsuario());
                    chamarPaginaEventosView(model);
                } else {
                    model.voltarPaginaInicial();
                }

            case 3:
                model.voltarPaginaInicial();
        }
    }
    public void chamarPaginaEventosView(Model model){
        PaginaEventosView pagina = new PaginaEventosView();
        pagina.initPaginaEventosView(model);
    }
    public void chamarMainView(Model model){
        MainView view = new MainView();
        view.initMainView(model);
    }
    public void chamarDetalhesDoEventoView(Model model, Evento eventoEscolhido){
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, eventoEscolhido);
    }
    public void eventosDisponiveis() throws NullPointerException{ // metodo para exibir os eventos disponiveis, caso existam;
        try {
            view.exibirMensagem("Total eventos disponiveis: " + model.getEventosCadastrados().size());
            view.exibirMensagem("Lista de eventos:");
            int i = 1;
            for (Evento evento: model.getEventosCadastrados()) {
                view.exibirMensagem(i + " >>> " + evento.getNome());
                i++;
            }
        } catch (NullPointerException exception){
            view.exibirMensagem("Nenhum evento cadastrado.....");
        }
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public PaginaEventosView getView() {
        return view;
    }
    public void setView(PaginaEventosView view) {
        this.view = view;
    }
    @Override
    public void update() {
    }
}
