package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Frequencia {

    private Atividade atividade;
    private ArrayList<Participante> participantesPresentes;

    public Frequencia(Atividade atividade, ArrayList<Participante> participantesPresentes) {
        this.atividade = atividade;
        this.participantesPresentes = participantesPresentes;
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
