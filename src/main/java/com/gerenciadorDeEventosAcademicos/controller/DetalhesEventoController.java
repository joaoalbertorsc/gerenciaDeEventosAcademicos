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
                    DetalhesEventoView view1 = new DetalhesEventoView();
                    view1.initDetalhesEventoView(model, evento);
                } else {
                    escolherAtividade();
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    if (model.getAtividadesCadastrados().isEmpty()) {
                        System.out.println("Nenhuma atividade cadastrada...");
                        DetalhesEventoView view2 = new DetalhesEventoView();
                        view2.initDetalhesEventoView(model, evento);
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
                    System.out.println("Atividade cadastrada com sucesso!");;
                    DetalhesEventoView view1 = new DetalhesEventoView();
                    view1.initDetalhesEventoView(model, evento);
                } else {
                    model.deslogarUsuario();
                }
            case 4:
                model.getEventosCadastrados().remove(evento);
                PaginaEventosView view1 = new PaginaEventosView();
                view1.initPaginaEventosView(model);
            case 5:
                model.voltarPaginaInicial();
            case 6:
                model.deslogarUsuario();

        }
    }

    public void escolherAtividade() throws NullPointerException{
        Scanner scanner = new Scanner(System.in);
        atividadesDisponiveis();
        System.out.println("Digite o numero correspondente a atividade desejada: ");
        numeroAtividadeEscolhida = scanner.nextInt();
        try{
            atividadeEscolhida = model.getAtividadesCadastrados().get(numeroAtividadeEscolhida-1);
            AtividadesView view1 = new AtividadesView();
            view1.initAtividadesView(model, atividadeEscolhida);
        } catch (NullPointerException exception){
            System.out.println("Nenhuma atividade correspondente.");
            System.out.println("Tente novamente.");
            DetalhesEventoView view1 = new DetalhesEventoView();
            view1.initDetalhesEventoView(model, view.getEventoEscolhido());
        }
    }
    public void atividadesDisponiveis() throws NullPointerException{
        int i = 1;
        try {
            System.out.println("Total atividades disponiveis: " + model.getAtividadesCadastrados().size());
            System.out.println("Lista de atividades:");
            for (Atividade atividade: model.getAtividadesCadastrados()) {
                System.out.println(i + " >>> " + atividade.getNome() + " ID: " + atividade.getId());
                i++;
                }
        } catch (NullPointerException exception){
            System.out.println("Nenhuma atividade cadastrada.....");
        }


    }
    @Override
    public void update() {

    }
}
