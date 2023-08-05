package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.MainController;
import com.gerenciadorDeEventosAcademicos.model.Model;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainView implements Observer{

    private Model model;
    private MainController controller;
    private boolean finalizar = false;

    public void finalizarSistema() { // metodo para finalizar o sistema
        System.out.println("Quase finalizando...");
        finalizar = true;
    }

    public void initMainView(Model model) { // iniciando a Main View que e a view inicial do sistema
        this.model = model;
        controller = new MainController();
        controller.initMainViewController(model, this);
        model.attachObserver(this);
        menuPrincipal();
    }

    public void menuPrincipal() throws NoSuchElementException {
        Scanner sc = new Scanner(System.in);
        String[] opcoes = { "[1] - Fazer Login", "[2] - Fazer Cadastro", "[3] - Sair" };
        while (!finalizar) {
            try{
                System.out.println("===========================================");
                System.out.println("|   GERENCIAMENTO DE EVENTOS ACADEMICOS   |");
                System.out.println("===========================================");
                System.out.println("Selecione uma opcao:");
                if (model.getUsuario() != null) {
                    System.out.println("Usuario: " + model.getUsuario().getNome());
                    opcoes[0] = "[1] - Fazer Logout";
                    opcoes[1] = "[2] - Acessar pagina de eventos";
                } else {
                    opcoes[0] = "[1] - Fazer Login";
                }
                System.out.println();
                System.out.println(opcoes[0]);
                System.out.println(opcoes[1]);
                System.out.println(opcoes[2]);
                System.out.println();
                System.out.println("Digite a opcao desejada: ");
                String event = sc.nextLine();
                controller.handleEvent(event); // Repassa o evento (opção digitada) para o controller
            } catch (NoSuchElementException e){
                this.finalizarSistema();
                break;
            }
        }
        sc.close();
    }
    public void exibirMensagem(String mensagem){
        System.out.println();
        System.out.println(mensagem);
        System.out.println();
    }
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public MainController getController() {
        return controller;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public boolean isFinalizar() {
        return finalizar;
    }

    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

    public void update(){
    }
}
