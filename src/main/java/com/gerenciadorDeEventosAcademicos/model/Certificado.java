package com.gerenciadorDeEventosAcademicos.model;

public class Certificado {
    private Participante participante;
    private Atividade atividade;
    private Evento evento;

    public Certificado(Participante participante, Atividade atividade, Evento evento) {
        this.participante = participante;
        this.atividade = atividade;
        this.evento = evento;
    }

    public Certificado emitirCertificado(Certificado certificado){
        return certificado;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "Evento: " + evento + '\n' +
                "Atividade= " + atividade + '\'' +
                "Participante='" + participante + '\'' +
                '}';
    }
}

