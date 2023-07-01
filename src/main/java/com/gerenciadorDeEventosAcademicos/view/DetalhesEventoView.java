package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class DetalhesEventoView implements Observer{

    private Model model;
    private DetalhesEventoController controller;
    private Evento eventoEscolhido;
    private ArrayList<Atividade> listaAtividadesCadastradas;
    private int escolhaUsuario;
    public void initDetalhesEventoView(Model model, Evento eventoEscolhido) {
        this.model = model;
        this.eventoEscolhido = eventoEscolhido;
        controller = new DetalhesEventoController();
        controller.initDetalhesEventoController(model, this);
        model.attachObserver(this);
        detalhesDoEvento();

    }
    public void detalhesDoEvento(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("Detalhes do evento " + eventoEscolhido.getNome());
        System.out.println("======================================");
        System.out.println();
        controller.atividadesDisponiveis();
        System.out.print(
                "[1] - Escoilher atividade" +
                "\n[2] - Voltar a pagina anterior" +
                "\n[3] - Sair");
        escolhaUsuario = scanner.nextInt();
        controller.handleEvent(escolhaUsuario);
        model.detachObserver(this);
    }
    public Evento getEventoEscolhido() {
        return eventoEscolhido;
    }
    public void setEventoEscolhido(Evento eventoEscolhido) {
        this.eventoEscolhido = eventoEscolhido;
    }
    public ArrayList<Atividade> getListaAtividadesCadastradas() {
        return listaAtividadesCadastradas;
    }
    public void setListaAtividadesCadastradas(ArrayList<Atividade> listaAtividadesCadastradas) {
        this.listaAtividadesCadastradas = listaAtividadesCadastradas;
    }
    public int getEscolhaUsuario() {
        return escolhaUsuario;
    }
    public void setEscolhaUsuario(int escolhaUsuario) {
        this.escolhaUsuario = escolhaUsuario;
    }
    @Override
    public void update() {

    }
}
