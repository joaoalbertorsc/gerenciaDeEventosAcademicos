package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.PaginaEventosController;
import com.gerenciadorDeEventosAcademicos.model.*;
import java.util.Scanner;

public class PaginaEventosView implements Observer{

    private Model model;
    private Evento evento;
    private PaginaEventosController controller;
    private int numeroEventoEscolhido;
    private int escolhaUsuario;
    public void initPaginaEventosView(Model model) {  // iniciando a pagina de eventos
        this.model = model;
        controller = new PaginaEventosController();
        controller.initPaginaEventosController(model, this);
        model.attachObserver(this);
        paginaEventos();
    }

    private void paginaEventos() { // view da pagina de eventos
        Scanner scanner = new Scanner(System.in);
        String[] opcoes = {"[1] - Escolher evento", "[2] - Voltar para a pagina inicial","index 2"};
        System.out.println("======================");
        System.out.println("PAGINA DE EVENTOS");
        System.out.println("======================");
        System.out.println();
        controller.eventosDisponiveis();
        if (model.getUsuario() instanceof Organizador){
            opcoes[1] = "[2] - Criar evento";
            opcoes[2] = "[3] - Voltar para a pagina inicial";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
        } else {
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
        }
        System.out.println("Escolha uma opcao: ");
        escolhaUsuario = scanner.nextInt();
        scanner.nextLine();
        controller.handleEvent(escolhaUsuario);
        numeroEventoEscolhido = scanner.nextInt();
        model.detachObserver(this);
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public PaginaEventosController getController() {
        return controller;
    }

    public void setController(PaginaEventosController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
