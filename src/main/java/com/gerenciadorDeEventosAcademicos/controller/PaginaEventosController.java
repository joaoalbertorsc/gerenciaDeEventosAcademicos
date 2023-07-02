package com.gerenciadorDeEventosAcademicos.controller;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.Observer;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;
import java.util.Scanner;

public class PaginaEventosController implements Observer {

    private Model model;
    private PaginaEventosView view;


    public void initPaginaEventosController(Model model, PaginaEventosView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(int escolhaUsuario) throws NullPointerException, IndexOutOfBoundsException{

        switch (escolhaUsuario){
            case 1 :
                Scanner sc = new Scanner(System.in);
                eventosDisponiveis();
                System.out.println("Digite o numero do evento desejado: ");
                int numEvento;
                numEvento = sc.nextInt();
                numEvento-=1;
                try{
                    Evento eventoEscolhido = model.getEventosCadastrados().get(numEvento);
                    DetalhesEventoView view1 = new DetalhesEventoView();
                    view1.initDetalhesEventoView(model, eventoEscolhido);
                } catch (NullPointerException | IndexOutOfBoundsException e){
                    System.out.println("ID invalido.");
                    System.out.println("Confira o numero e tente novamente.");
                    PaginaEventosView pagina = new PaginaEventosView();
                    pagina.initPaginaEventosView(model);
                    }
            case 2:
                if (model.getUsuario() instanceof Organizador){
                    Organizador organizador = (Organizador) model.getUsuario();
                    Evento novoEvento = organizador.criarEvento();
                    model.getEventosCadastrados().add(novoEvento);
                    novoEvento.setOrganizador((Organizador) model.getUsuario());
                    PaginaEventosView pagina1 = new PaginaEventosView();
                    pagina1.initPaginaEventosView(model);
                } else {
                    model.voltarPaginaInicial();
                }

            case 3:
                model.voltarPaginaInicial();
        }
    }
    public void eventosDisponiveis() throws NullPointerException{
        try {
            System.out.println("Total eventos disponiveis: " + model.getEventosCadastrados().size());
            System.out.println("Lista de eventos:");
            int i = 1;
            for (Evento evento: model.getEventosCadastrados()) {
                System.out.println(i + " >>> " + evento.getNome());
                i++;
            }
        } catch (NullPointerException exception){
            System.out.println("Nenhum evento cadastrado.....");
        }
    }
    public void escolherEvento(){

    }

    @Override
    public void update() {

    }
}
