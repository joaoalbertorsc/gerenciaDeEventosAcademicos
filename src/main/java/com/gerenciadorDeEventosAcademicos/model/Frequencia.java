package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Frequencia {

    private Evento evento;
    private Atividade atividade;
    private ArrayList<Participante> participantesPresentes;

    public Frequencia(Evento evento, Atividade atividade) {
        this.evento = evento;
        this.atividade = atividade;
    }

    public void marcarPresenca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] - Presente" +
                "[2] - Ausente");
        for (Participante participante: atividade.getParticipantesDaAtividade()) {
            System.out.println("Participante " + participante.getNome() + "esta presente ?\n");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("1")){
                participantesPresentes.add(participante);
                System.out.println("Presenca para o " + participante.getNome());
            } else {
                System.out.println("Falta para o " + participante.getNome());
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

    public void gerarCertificados() {
        for (Participante participante: participantesPresentes) {
            Certificado certificado = new Certificado(participante, atividade, evento);
            certificado.emitirCertificado();
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
