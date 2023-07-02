package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Frequencia {

    private Evento evento;
    private Atividade atividade;
    private ArrayList<Participante> participantesPresentes;

    public void marcarPresenca(Atividade atividade) {
        Scanner sc = new Scanner(System.in);
        this.atividade = atividade;
        System.out.println("[1] - Presente" +
                "[2] - Ausente");
        for (Participante participante: atividade.getParticipantesDaAtividade()) {
            System.out.println("Participante " + participante.getNome() + "esta presente?\n");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("1")){
                participantesPresentes.add(participante);
                System.out.println(participante.getNome() + " esta presente.");
            } else {
                System.out.println(participante.getNome() + " esta ausente.");
            }
        }
        sc.close();
    }

    public void verListaPresenca(){
        System.out.println("Lista de presenca:");
        for (Participante participante: participantesPresentes) {
            System.out.println(participante.getNome());
        }
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public ArrayList<Participante> getParticipantesPresentes() {
        return participantesPresentes;
    }

    public void setParticipantesPresentes(ArrayList<Participante> participantesPresentes) {
        this.participantesPresentes = participantesPresentes;
    }
}
