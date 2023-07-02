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
                escolherAtividade();
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarEvento(evento, model);
                    DetalhesEventoView view1 = new DetalhesEventoView();
                    view1.initDetalhesEventoView(model, evento);
                } else {
                    model.voltarPaginaInicial();
                }
            case 3:
                if (model.getUsuario() instanceof Organizador){
                    model.voltarPaginaInicial();
                } else {
                    model.deslogarUsuario();
                }
            case 4:
                model.deslogarUsuario();
        }
    }

    public void escolherAtividade() throws NullPointerException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero correspondente a atividade desejada: ");

        try{
            numeroAtividadeEscolhida = scanner.nextInt();
            atividadeEscolhida = model.getAtividadesCadastrados().get(numeroAtividadeEscolhida);
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
            if (model.getAtividadesCadastrados().isEmpty()){
                System.out.println("Nenhuma atividade cadastrada.....");
                System.out.println();
            } else {
                for (Atividade atividade: model.getAtividadesCadastrados()) {
                    System.out.println(i + " >>> " + atividade.getNome() + " ID: " + atividade.getId());
                    i++;
                }
            }
        } catch (NullPointerException exception){
            System.out.println("Atividade não encontrada.....");
        }


    }
    @Override
    public void update() {

    }
}
