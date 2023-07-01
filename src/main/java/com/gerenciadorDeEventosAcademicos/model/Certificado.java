package com.gerenciadorDeEventosAcademicos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Certificado {
    private Participante participante;
    private Atividade atividade;
    private Evento evento;

    public Certificado(Participante participante, Atividade atividade) {
        this.participante = participante;
        this.atividade = atividade;
    }

    public void emitirCertificado () {
        String conteudo = "Certificamos que " + participante.getNome() + " participou da atividade " + atividade.getNome() + "no evento " + evento.getNome() + " realizada em " + atividade.getDataInicio() + ".";
        String nomeArquivo = participante.getNome() + "-" + atividade.getNome() + ".txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
            writer.println(conteudo);
            writer.close();
            System.out.println("Certificado para " + participante.getNome() + " salvo com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o certificado de " + participante.getNome() + " no arquivo " + nomeArquivo);
            e.printStackTrace();
        }
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
        return "Participante:'" + participante + '\n' +
                "Evento: " + evento + '\n' +
                "Atividade: " + atividade + '\n';
    }
}

