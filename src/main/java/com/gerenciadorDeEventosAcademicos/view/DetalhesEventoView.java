package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class DetalhesEventoView implements Observer{

    private Model model;
    private DetalhesEventoController controller;
    private Evento eventoEscolhido;
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
        String[] opcoes = {"[1] - Escolher atividade", "[2] - Voltar a pagina inicial", "[3] - Sair"};
        System.out.println("======================================");
        System.out.println("Detalhes do evento " + eventoEscolhido.getNome());
        System.out.println("======================================");
        System.out.println(eventoEscolhido);
        if (model.getUsuario() instanceof Organizador){
            opcoes[1] = "[2] - Editar evento";
            opcoes[2] = "[3] - Voltar a pagina inicial";
            opcoes[3] = "[4] - Sair";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
        } else {
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
        }
        int escolhaUsuario = scanner.nextInt();
        controller.handleEvent(escolhaUsuario, eventoEscolhido);
        model.detachObserver(this);
    }
    public Evento getEventoEscolhido() {
        return eventoEscolhido;
    }
    public void setEventoEscolhido(Evento eventoEscolhido) {
        this.eventoEscolhido = eventoEscolhido;
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
