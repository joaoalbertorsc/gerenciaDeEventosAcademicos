package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.LoginController;
import com.gerenciadorDeEventosAcademicos.controller.PaginaEventosController;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;

import java.util.ArrayList;
import java.util.Scanner;

public class PaginaEventosView implements Observer{

    private Model model;
    private PaginaEventosController controller;
    private ArrayList<Evento> listaEventosCadastrados;
    private int numeroEventoEscolhido;
    private int escolhaUsuario;

    public void initPaginaEventosView(Model model) {
        this.model = model;
        controller = new PaginaEventosController();
        controller.initPaginaEventosController(model, this);
        model.attachObserver(this);
        escolherEvento();
    }

    private void escolherEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("PAGINA DE EVENTOS");
        System.out.println("======================");
        System.out.println();
        controller.eventosDisponiveis();
        System.out.print("[1] - Escoilher evento" +
                "\n[2] - Voltar" +
                "\n[3] - Sair");
        escolhaUsuario = scanner.nextInt();
        controller.escolhaUsuario(escolhaUsuario);
        numeroEventoEscolhido = scanner.nextInt();
        model.detachObserver(this);
    }

    public ArrayList<Evento> getListaEventosCadastrados() {
        return listaEventosCadastrados;
    }

    public void setListaEventosCadastrados(ArrayList<Evento> listaEventosCadastrados) {
        this.listaEventosCadastrados = listaEventosCadastrados;
    }

    public int getNumeroEventoEscolhido() {
        return numeroEventoEscolhido;
    }

    public void setNumeroEventoEscolhido(int numeroEventoEscolhido) {
        this.numeroEventoEscolhido = numeroEventoEscolhido;
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
