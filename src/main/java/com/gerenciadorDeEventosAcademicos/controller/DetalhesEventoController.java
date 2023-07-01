package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

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

    public void escolhaUsuario(int escolhaUsuario){

        switch (escolhaUsuario){

            case 1:
                escolherAtividade();
            case 2:
                model.voltarPaginaInicial();
            case 3:
                model.deslogarUsuario();
        }
    }

    public void escolherAtividade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero correspondente a atividade desejada: ");
        numeroAtividadeEscolhida = scanner.nextInt();
        atividadeEscolhida = view.getListaAtividadesCadastradas().get(numeroAtividadeEscolhida);
        AtividadesView view1 = new AtividadesView();
        view1.initAtividadesView(model, atividadeEscolhida);

    }
    public void atividadesDisponiveis(){

        try {
            System.out.println("Eventos disponiveis: ");
            for (int i = 0; i < view.getListaAtividadesCadastradas().size(); i++) {
                System.out.println(i + " - " + view.getListaAtividadesCadastradas().get(i).getNome());
            }
        } catch (NullPointerException exception){
            System.out.println("Nenhuma atividade cadastrada.");
        }


    }
    @Override
    public void update() {

    }
}
