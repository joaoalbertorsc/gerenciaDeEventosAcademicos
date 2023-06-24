package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Evento {

    private int id;
    private String nome;
    private String descricao;
    private Endereco endereco;
    private Organizador organizador;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;

    private ArrayList<Atividade> atividadesDoEvento = new ArrayList<Atividade>();
    private ArrayList<Participante> participantesDoEvento = new ArrayList<Participante>();
    private ArrayList<Palestrante> palestrantesDoEvento = new ArrayList<Palestrante>();

    public Evento(int id) {
        this.id = id;
    }

    public Evento(int id, String nome, String descricao, Endereco endereco, Organizador organizador, String dataInicio, String dataFim, String horaInicio) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.organizador = organizador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
    }

    public Evento(int id, String nome, String descricao, Endereco endereco, Organizador organizador, String dataInicio, String dataFim, String horaInicio, ArrayList<Atividade> atividadesDoEvento, ArrayList<Participante> participantesDoEvento, ArrayList<Palestrante> palestrantesDoEvento) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.organizador = organizador;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.atividadesDoEvento = atividadesDoEvento;
        this.participantesDoEvento = participantesDoEvento;
        this.palestrantesDoEvento = palestrantesDoEvento;
    }

    public String toString(){
        return "-------------------------------------------" +
                "\nEvento: " + nome +
                "\nDescricao: " + descricao +
                "\n-------------------------------------------" +
                "\n" + endereco +
                "\n-------------------------------------------" +
                "\n" + organizador +
                "\n-------------------------------------------" +
                "\nData de inicio: " + dataInicio +
                "\nData de finalizacao: " + dataFim +
                "\n-------------------------------------------" +
                "\nAtividades do evento:\n\n" + atividadesDoEvento +
                "\n-------------------------------------------";

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
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

    public ArrayList<Atividade> getAtividadesDoEvento() {
        return atividadesDoEvento;
    }

    public void setAtividadesDoEvento(ArrayList<Atividade> atividadesDoEvento) {
        this.atividadesDoEvento = atividadesDoEvento;
    }

    public ArrayList<Participante> getParticipantesDoEvento() {
        return participantesDoEvento;
    }

    public void setParticipantesDoEvento(ArrayList<Participante> participantesDoEvento) {
        this.participantesDoEvento = participantesDoEvento;
    }

    public ArrayList<Palestrante> getPalestrantesDoEvento() {
        return palestrantesDoEvento;
    }

    public void setPalestrantesDoEvento(ArrayList<Palestrante> palestrantesDoEvento) {
        this.palestrantesDoEvento = palestrantesDoEvento;
    }

    public void addAtividade(Atividade atividade) {
        atividadesDoEvento.add(atividade);
    }
}
