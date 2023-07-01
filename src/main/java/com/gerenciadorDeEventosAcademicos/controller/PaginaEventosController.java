package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.LoginView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;

import java.util.ArrayList;
import java.util.Scanner;

public class PaginaEventosController implements Observer {

    private Model model;
    private PaginaEventosView view;


    public void initPaginaEventosController(Model model, PaginaEventosView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario) throws NullPointerException{

        switch (escolhaUsuario){

            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o ID do evento desejado: ");
                try{
                    int idEventoDesejado;
                    idEventoDesejado = sc.nextInt();
                    Evento eventoEscolhido = view.getListaEventosCadastrados().get(idEventoDesejado);
                    DetalhesEventoView view1 = new DetalhesEventoView();
                    view1.initDetalhesEventoView(model, eventoEscolhido);
                } catch (NullPointerException exception){
                    System.out.println("Nenhum evento correspondente!");
                    System.out.println("Confira o ID digitado, tente novamente.");
                    PaginaEventosView pagina = new PaginaEventosView();
                    pagina.initPaginaEventosView(model);
                }


            case 2:
                model.voltarPaginaInicial();
        }
    }
    public void eventosDisponiveis() throws NullPointerException{
        int i = 1;
        try {
            System.out.println("Total eventos disponiveis: " + view.getListaEventosCadastrados().size());
            System.out.println("Lista de eventos:");
            for (Evento evento: view.getListaEventosCadastrados()) {
                System.out.println(i + "/// ID : " + evento.getId() + " - " + evento.getNome());
                i++;
            }
        } catch (NullPointerException exception){
            System.out.println("Nenhum evento cadastrado.....");
        }
    }
    public void escolherEvento(){

    }

    @Override
    public void update() {

    }
}
