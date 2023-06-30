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

    public void eventosDisponiveis() throws NullPointerException{

        try {
            System.out.println("Eventos disponiveis: ");
            for (int i = 0; i < view.getListaEventosCadastrados().size(); i++) {
                System.out.println(i + " - " + view.getListaEventosCadastrados().get(i).getNome());
            }
        } catch (NullPointerException exception){
            System.out.println("Nenhum evento cadastrado.");
        }
    }

    public void escolhaUsuario(int escolhaUsuario){

        switch (escolhaUsuario){

            case 1:
                int numEventoDesejado;
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o numero do evento desejado: ");
                numEventoDesejado = sc.nextInt();
                Evento eventoEscolhido = view.getListaEventosCadastrados().get(numEventoDesejado);
                DetalhesEventoView view1 = new DetalhesEventoView();
                view1.initDetalhesEventoView(model, eventoEscolhido);
            case 2:
                model.voltar();
            case 3:
                model.deslogarUsuario();
        }
    }

    public void escolherEvento(){

    }

    @Override
    public void update() {

    }
}
