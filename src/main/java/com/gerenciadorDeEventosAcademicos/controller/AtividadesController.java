package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.Scanner;

public class AtividadesController implements Observer{
    private Model model;
    private AtividadesView view;
    public void initAtividadesController(Model model, AtividadesView view) { // iniciando controller da view atividade;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario){ // de acordo com a escolha do usuario eh chamada o caso que sera executado
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        switch (escolhaUsuario){
            case 1:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    organizador.editarAtividade(model, view.getAtividadeEscolhida());
                } else if (model.getUsuario() instanceof Palestrante) {
                    Palestrante palestrante = (Palestrante) model.getUsuario();
                    palestrante.editarAtividade(model, view.getAtividadeEscolhida());
                } else {
                    if (view.getAtividadeEscolhida().getParticipantesDaAtividade().contains((Participante) model.getUsuario())){
                        ((Participante) model.getUsuario()).cancelarInscricaoAtividade(view.getAtividadeEscolhida());
                    } else {
                        ((Participante) model.getUsuario()).inscreverseAtividade(view.getAtividadeEscolhida());
                    }
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){

                    if (model.getPalestrantesLista().isEmpty()){
                        System.out.println();
                        System.out.println("Nenhum palestrante cadastrado...");
                        System.out.println();
                        AtividadesView view1 = new AtividadesView();
                        view1.initAtividadesView(model, view.getAtividadeEscolhida());
                    } else {
                        Organizador organizador = (Organizador) model.getUsuario();
                        System.out.println();
                        System.out.println("Palestrantes cadastrados:");
                        for (Palestrante palestrante: model.getPalestrantesLista()) {
                            System.out.println("ID: " + i + " - " + "Nome: " + palestrante.getNome());
                            i++;
                        }
                        System.out.println();
                        System.out.println("Digite o ID correspondente ao palestrante que você deseja atribuir a atividade:" + view.getAtividadeEscolhida().getNome() + ":");
                        int id = scanner.nextInt();
                        organizador.atribuirPalestrante(model.getPalestrantesLista().get(id-1), view.getAtividadeEscolhida());
                        System.out.println();
                        System.out.println("Palestrante " + model.getPalestrantesLista().get(id-1).getNome() + " atribuido com sucesso!");
                        System.out.println();
                        AtividadesView view1 = new AtividadesView();
                        view1.initAtividadesView(model, view.getAtividadeEscolhida());
                    }
                } else{
                    System.out.println("Participantes inscritos:");
                    view.getAtividadeEscolhida().getParticipantesDaAtividade().forEach(participante -> System.out.println("Participante : " + participante.getNome()));
                    AtividadesView view1 = new AtividadesView();
                    view1.initAtividadesView(model, view.getAtividadeEscolhida());
                }
            case 3:
                if (model.getUsuario() instanceof Organizador) {
                    Organizador organizador = (Organizador) model.getUsuario();
                    System.out.println();
                    System.out.println("Palestrantes atribuidos:");
                    for (Palestrante palestrante : view.getAtividadeEscolhida().getPalestrantesDaAtividade()) {
                        System.out.println("ID: " + i + " - " + "Nome: " + palestrante.getNome());
                        i++;
                    }
                    System.out.println();
                    System.out.println("Digite o ID correspondente ao palestrante que voce deseja remover da atividade:" + view.getAtividadeEscolhida().getNome() + ":");
                    int id = scanner.nextInt();
                    organizador.removerPalestrante(view.getAtividadeEscolhida(), model.getPalestrantesLista().get(id - 1));
                    AtividadesView view1 = new AtividadesView();
                    view1.initAtividadesView(model, view.getAtividadeEscolhida());
                } else {
                    model.voltarPaginaInicial();
                }

            case 4:
                if (model.getUsuario() instanceof Organizador){
//                    Frequencia frequencia = new Frequencia();
//                    Organizador organizador = (Organizador) model.getUsuario();
//                    organizador.realizarFrequencia(view.getAtividadeEscolhida(), frequencia);
//                    organizador.gerarCertificado(frequencia, view.getAtividadeEscolhida());
                    AtividadesView view1 = new AtividadesView();
                    view1.initAtividadesView(model, view.getAtividadeEscolhida());
                } else {
                    model.deslogarUsuario();
                }
            case 5:
                System.out.println("Lista de participantes inscritos:");
                for (Participante participante:view.getAtividadeEscolhida().getParticipantesDaAtividade()) {
                    System.out.println(i + " - " + participante.getNome());
                    i++;
                }
                AtividadesView view1 = new AtividadesView();
                view1.initAtividadesView(model, view.getAtividadeEscolhida());
            case 6:
                System.out.println("Lista de palestrantes atribuidos:");
                for (Palestrante palestrante:view.getAtividadeEscolhida().getPalestrantesDaAtividade()) {
                    System.out.println(i + " - " + palestrante.getNome());
                    i++;
                }
                AtividadesView view2 = new AtividadesView();
                view2.initAtividadesView(model, view.getAtividadeEscolhida());
            case 7:
                Organizador organizador = (Organizador) model.getUsuario();
                organizador.excluirAtividade(view.getAtividadeEscolhida());
                AtividadesView view3 = new AtividadesView();
                view3.initAtividadesView(model, view.getAtividadeEscolhida());
            case 8:
                model.voltarPaginaInicial();;
            case 9:
                model.deslogarUsuario();
        }
    }
    public Model getModel() {
        return model;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public AtividadesView getView() {
        return view;
    }
    public void setView(AtividadesView view) {
        this.view = view;
    }
    @Override
    public void update() {

    }
}
