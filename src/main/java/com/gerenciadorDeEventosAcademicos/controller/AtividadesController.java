package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.*;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.Scanner;

public class AtividadesController implements Observer{
    private Model model;
    private AtividadesView view;
    Scanner scanner = new Scanner(System.in);
    public void initAtividadesController(Model model, AtividadesView view) { // iniciando controller da view atividade;
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario){ // de acordo com a escolha do usuario eh chamada o caso que sera executado

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
                        ((Participante) model.getUsuario()).cancelarInscricaoAtividade((Participante) model.getUsuario(), view.getAtividadeEscolhida());
                    } else {
                        ((Participante) model.getUsuario()).inscreverseEmAtividade(model.getUsuario(), view.getAtividadeEscolhida());
                    }
                }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    if (model.getPalestrantesLista().isEmpty()){
                        view.exibirMensagem(AtividadesView.msgNenhumPalestranteEncontrado);
                        chamarAtividadesView(model, view);
                    } else {
                        Organizador organizador = (Organizador) model.getUsuario();
                        view.atribuirPalestrante(organizador);
                        chamarAtividadesView(model, view);
                    }
                } else{
                    view.participantesInscritos();
                    chamarAtividadesView(model, view);
                }
            case 3:
                if (model.getUsuario() instanceof Organizador) {
                    removerPalestrante();
                    chamarAtividadesView(model, view);
                } else {
                    model.voltarPaginaInicial();
                }

            case 4:
                if (model.getUsuario() instanceof Organizador){
//                    Frequencia frequencia = new Frequencia();
//                    Organizador organizador = (Organizador) model.getUsuario();
//                    organizador.realizarFrequencia(view.getAtividadeEscolhida(), frequencia);
//                    organizador.gerarCertificado(frequencia, view.getAtividadeEscolhida());
                    chamarAtividadesView(model, view);
                } else {
                    model.deslogarUsuario();
                }
            case 5:
                view.participantesInscritos();
                chamarAtividadesView(model, view);
            case 6:
                view.palestrantesAtribuidos();
                chamarAtividadesView(model, view);
            case 7:
                Organizador organizador = (Organizador) model.getUsuario();
                organizador.excluirAtividade(view.getAtividadeEscolhida());
                chamarAtividadesView(model, view);
            case 8:
                model.voltarPaginaInicial();;
            case 9:
                model.deslogarUsuario();
        }
    }
    public void removerPalestrante(){
        view.palestrantesAtribuidos();
        view.exibirMensagem(AtividadesView.msgIdRemoverPalestrante + view.getAtividadeEscolhida().getNome() + AtividadesView.msgDoisPontos);
        Organizador organizador = (Organizador) model.getUsuario();
        int id = scanner.nextInt();
        organizador.removerPalestrante(view.getAtividadeEscolhida(), model.getPalestrantesLista().get(id - 1));
    }
    public void atribuirPalestrante(Organizador organizador, int id){
        organizador.atribuirPalestrante(model.getPalestrantesLista().get(id-1), view.getAtividadeEscolhida());

    }
    public void chamarAtividadesView(Model model, AtividadesView view){
        AtividadesView view1 = new AtividadesView();
        view1.initAtividadesView(model, view.getAtividadeEscolhida());
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
