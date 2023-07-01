package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Palestrante extends Participante {

    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    private Atividade atividade;
    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", atividades=" + atividades +
                '}';
    }

    public void inscreverseAtividade(Atividade atividade){}
    public void cancelarInscricaoAtividade(Atividade atividade){}
    public void editarAtividade(Atividade atividade){
        this.atividade = atividade;

        System.out.println("Qual atributo da atividade você deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Descrição");
        System.out.println("[3] - Data de Início");
        System.out.println("[4] - Data de Fim");
        System.out.println("[5] - Hora de Início");
        System.out.println("[6] - Hora de Fim");
        System.out.println("Escolha uma opcção:");
        int i = scanner.nextInt();
        handleEvent(i);
        scanner.close();
    }

    public void handleEvent(int i){
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                atividade.setNome(scanner.nextLine());
            case 2:
                System.out.println("Escreva a nova descirção desejada:");
                atividade.setDescricao(scanner.nextLine());
            case 3:
                System.out.println("Defina uma nova data de inicio:");
                atividade.setDataInicio(scanner.nextLine());
            case 4:
                System.out.println("Defina uma nova data de encerramento:");
                atividade.setDataFim(scanner.nextLine());
            case 5:
                System.out.println("Defina um novo horário para inicio:");
                atividade.setHoraInicio(scanner.nextLine());
            case 6:
                System.out.println("Defina um novo horário para encerramento:");
                atividade.setHoraInicio(scanner.nextLine());
            default:
                System.out.println("Opção invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarAtividade(atividade);
        }
    }
    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}