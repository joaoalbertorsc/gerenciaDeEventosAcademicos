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
    private int totalEventosCadastrados;
    private ArrayList<Evento> listaEventosCadastrados;
    private int numeroEventoEscolhido;

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
        System.out.println("Total eventos cadastrados: " + totalEventosCadastrados);
        eventosDaLista();
        System.out.println();
        System.out.print("Digite o numero do evento: ");
        numeroEventoEscolhido = scanner.nextInt();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void eventosDaLista(){
        System.out.println("Eventos disponiveis: ");
        for (int i = 0; i < listaEventosCadastrados.size(); i++) {
            System.out.println(i + " - " + listaEventosCadastrados.get(i).getNome());
        }
    }

    public int getTotalEventosCadastrados() {
        return totalEventosCadastrados;
    }

    public void setTotalEventosCadastrados(int totalEventosCadastrados) {
        this.totalEventosCadastrados = totalEventosCadastrados;
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

    //    tipoUsuario(int tipoUsuario) {
//    }
    @Override
    public void update() {

    }
}
