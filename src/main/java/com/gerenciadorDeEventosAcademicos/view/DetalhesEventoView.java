package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Evento;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Organizador;
import java.util.Scanner;

public class DetalhesEventoView implements Observer{

    private Model model;
    private DetalhesEventoController controller;
    private Evento eventoEscolhido;
    private int escolhaUsuario;
    public void initDetalhesEventoView(Model model, Evento eventoEscolhido) { // iniciando a tela de detalhes do evento
        this.model = model;
        this.eventoEscolhido = eventoEscolhido;
        controller = new DetalhesEventoController();
        controller.initDetalhesEventoController(model, this);
        model.attachObserver(this);
        detalhesDoEvento();

    }
    public void detalhesDoEvento(){ // view detalhes do evento
        Scanner scanner = new Scanner(System.in);
        String[] opcoes = {"[1] - Escolher atividade", "[2] - Voltar a pagina inicial", "[3] - Sair", "index 3", "index 4", "index 5"};
        System.out.println("=================================");
        System.out.println("|       Detalhes do evento      |");
        System.out.println("=================================");
        System.out.println(eventoEscolhido);
        System.out.println("Total atividades cadastradas: " + model.getAtividadesCadastrados().size());
        System.out.println();
        if (model.getAtividadesCadastrados().isEmpty()){
            System.out.println("Nenhuma atividade cadastrada....");
        } else {
            int i = 0;
            System.out.println("Lista de atividades cadastradas >>>");
            for (Atividade atividade: model.getAtividadesCadastrados()) {
                System.out.println(i + " - " + atividade.getNome() + " - " + atividade.getDescricao());
                i++;
            }
        }
        System.out.println();
        if (model.getUsuario() instanceof Organizador){
            opcoes[0] = "[1] - Editar dados do evento";
            opcoes[1] = "[2] - Escolher atividade";
            opcoes[2] = "[3] - Criar atividade";
            opcoes[3] = "[4] - ExcLuir evento";
            opcoes[4] = "[5] - Voltar a pagina inicial";
            opcoes[5] = "[6] - Sair";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println(opcoes[4]);
            System.out.println(opcoes[5]);
        } else {
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
        }
        System.out.println("Escolha uma opcao");
        int escolhaUsuario = scanner.nextInt();
        scanner.nextLine();
        controller.handleEvent(escolhaUsuario, eventoEscolhido);
        model.detachObserver(this);
    }
    public void exibirMensagem(String mensagem) {
        System.out.println();
        System.out.println(mensagem);
        System.out.println();
    }
    public void totalAtividadesDisponiveis() throws NullPointerException{
        int i = 1;
        try {
            exibirMensagem("Total atividades disponiveis: " + model.getAtividadesCadastrados().size());
            exibirMensagem("Lista de atividades:");
            for (Atividade atividade: model.getAtividadesCadastrados()) {
                System.out.println(i + " >>> " + atividade.getNome() + " ID: " + atividade.getId());
                i++;
            }
        } catch (NullPointerException exception){
            exibirMensagem("Nenhuma atividade cadastrada.....");
        }
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public DetalhesEventoController getController() {
        return controller;
    }

    public void setController(DetalhesEventoController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
