package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.Scanner;
import java.util.function.Consumer;

public class AtividadesController implements Observer{

    private Model model;
    private AtividadesView view;

    public void initAtividadesController(Model model, AtividadesView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(int escolhaUsuario){
        Scanner scanner = new Scanner(System.in);
        switch (escolhaUsuario){
            case 1:
                if (view.getUsuario() instanceof Participante){
                    if (view.getAtividadeEscolhida().getParticipantesDaAtividade().contains((Participante) model.getUsuarioAutenticado())){
                        ((Participante) model.getUsuarioAutenticado()).cancelarInscricaoAtividade(view.getAtividadeEscolhida());
                    } else {
                        ((Participante) model.getUsuarioAutenticado()).inscreverseAtividade(view.getAtividadeEscolhida());

                    }
                } else if (view.getUsuario() instanceof Palestrante) {
                    Palestrante palestrante = (Palestrante) model.getUsuario();
                    palestrante.editarAtividade(view.getAtividadeEscolhida());
                } else {
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarAtividade(view.getAtividadeEscolhida());
                }

            case 2:
                if (view.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    System.out.println();
                    System.out.println("Palestrantes cadastrados:");
                    for (Palestrante palestrante: model.getPalestrantesLista()) {
                        int i = 1;
                        System.out.println("ID: " + i + " - " + "Nome: " + palestrante.getNome());
                        i++;
                    }
                    System.out.println();
                    System.out.println("Digite o ID correspondente ao palestrante que você deseja atribuir a atividade:" + view.getAtividadeEscolhida().getNome() + ":");
                    int id = scanner.nextInt();
                    id -= 1;
                    organizador.atribuirPalestrante(model.getPalestrantesLista().get(id), view.getAtividadeEscolhida());
                    System.out.println();
                    System.out.println("Palestrante " + model.getPalestrantesLista().get(id).getNome() + " atribuido com sucesso!");
                    System.out.println();
                    AtividadesView view1 = new AtividadesView();
                    view1.initAtividadesView(model, view.getAtividadeEscolhida());
                } else{
                    System.out.println("Participantes inscritos:");
                    view.getAtividadeEscolhida().getParticipantesDaAtividade().forEach(participante -> System.out.println("Participante : " + participante.getNome()));
                    AtividadesView view1 = new AtividadesView();
                    view1.initAtividadesView(model, view.getAtividadeEscolhida());
                }
            case 3:
                if (view.getUsuario() instanceof Organizador){
                    Frequencia frequencia = new Frequencia();
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.realizarFrequencia(view.getAtividadeEscolhida(), frequencia);
                    organizador.gerarCertificado(frequencia, view.getAtividadeEscolhida());
                }
                model.voltarPaginaInicial();
            case 4:
                model.deslogarUsuario();
        }
    }


    @Override
    public void update() {

    }
}
