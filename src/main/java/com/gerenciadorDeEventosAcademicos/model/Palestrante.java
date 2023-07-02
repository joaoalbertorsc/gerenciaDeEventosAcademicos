package com.gerenciadorDeEventosAcademicos.model;
import com.gerenciadorDeEventosAcademicos.view.AtividadesView;

import java.util.ArrayList;
import java.util.Scanner;

public class Palestrante extends Participante {

    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    private Atividade atividade;
    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", atividades: " + atividades +
                '}';
    }

    public void inscreverseAtividade(Atividade atividade){}
    public void cancelarInscricaoAtividade(Atividade atividade){}
    public void editarAtividade(Model model, Atividade atividade){
        this.atividade = atividade;
        System.out.println("Qual atributo da atividade voce deseja editar?");
        System.out.println("----------------------------------------------");
        System.out.println("[1] - Nome:");
        System.out.println("[2] - Descrição:");
        System.out.println("[3] - Data de inicio:");
        System.out.println("[4] - Data de fim:");
        System.out.println("[5] - Hora de inicio:");
        System.out.println("[6] - Hora de fim:");
        System.out.println("----------------------------------------------");
        System.out.println("Escolha uma opcao:");
        int i = scanner.nextInt();
        scanner.nextLine();
        handleEvent(i, model, atividade);
        scanner.close();
    }

    public void handleEvent(int i, Model model, Atividade atividade){
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                atividade.setNome(scanner.nextLine());
                AtividadesView view = new AtividadesView();
                view.initAtividadesView(model, atividade);
            case 2:
                System.out.println("Escreva a nova descricao desejada:");
                atividade.setDescricao(scanner.nextLine());
                AtividadesView view1 = new AtividadesView();
                view1.initAtividadesView(model, atividade);
            case 3:
                System.out.println("Defina uma nova data de inicio:");
                atividade.setDataInicio(scanner.nextLine());
                AtividadesView view2 = new AtividadesView();
                view2.initAtividadesView(model, atividade);
            case 4:
                System.out.println("Defina uma nova data de encerramento:");
                atividade.setDataFim(scanner.nextLine());
                AtividadesView view3 = new AtividadesView();
                view3.initAtividadesView(model, atividade);
            case 5:
                System.out.println("Defina um novo horario para inicio:");
                atividade.setHoraInicio(scanner.nextLine());
                AtividadesView view4 = new AtividadesView();
                view4.initAtividadesView(model, atividade);
            case 6:
                System.out.println("Defina um novo horario para encerramento:");
                atividade.setHoraInicio(scanner.nextLine());
                AtividadesView view5 = new AtividadesView();
                view5.initAtividadesView(model, atividade);
            default:
                System.out.println("Opcao invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarAtividade(model, atividade);
        }
    }
    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}