package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Atividade {

    private int id;
    private String nome;
    private String descricao;
    private Local local;
    private Palestrante palestrante;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private ArrayList<Participante> participantesDaAtividade = new ArrayList<Participante>();

    public Atividade(int id, String nome, String descricao, Local local, Palestrante palestrante, String dataInicio, String dataFim, String horaInicio, String horaFim, ArrayList<Participante> participantesDaAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.palestrante = palestrante;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.participantesDaAtividade = participantesDaAtividade;
    }

    @Override
    public String toString() {
        return "Nome: ((" + nome +
                "))\n    Descricao: " + descricao +
                "\n    Local: " + local +
                "\n    Palestrante: " + palestrante +
                "\n    Data de Inicio: " + dataInicio +
                "\n    Hora de inicio: " + horaInicio +
                "\n    Hora de fim: " + horaFim +
                "\n    Participantes da atividade: " + participantesDaAtividade +
                "}";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public ArrayList<Participante> getParticipantesDaAtividade() {
        return participantesDaAtividade;
    }

    public void setParticipantesDaAtividade(ArrayList<Participante> participantesDaAtividade) {
        this.participantesDaAtividade = participantesDaAtividade;
    }
}
