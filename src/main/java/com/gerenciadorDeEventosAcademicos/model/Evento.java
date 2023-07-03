package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;
import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);
    public String toString(){
        return "\nEvento: " + nome +
                "\nDescricao: " + descricao +
                "\n" + endereco +
                "\n" + organizador +
                "\n*********************************" +
                "\nData de inicio: " + dataInicio +
                "\nData de finalizacao: " + dataFim +
                "\n*********************************";
    }
    public void criarEndereco() { // metodo para criar endereco quando a criacao de um evento eh chamada;
        Scanner sc = new Scanner(System.in);
        String rua, numero, cidade, referencia;
        System.out.println("Escreva abaixo os dados referentes ao endereco do evento:");
        System.out.println("Nome da rua:");
        rua = sc.nextLine();
        System.out.println("Digite o numero do local:");
        numero = sc.nextLine();
        System.out.println("Nome da cidade:");
        cidade = sc.nextLine();
        System.out.println("Escreva a referencia para o endereco:");
        referencia = sc.nextLine();
        System.out.println("---------------------------------------------------------");
        endereco = new Endereco(rua, numero, cidade, referencia);
        this.endereco = endereco;
    }
    public void setId(int id){
        if (id >= 0 && id <= 999999){ // verificacao do dado de entrada do usuario;
            this.id = id;
        } else {
            System.out.println("O id informado não esta entre o intervalo de 0 a 999999 \n Tente novamente");
        }
    }
    public void setDataFim(String dataFim) {
        if (dataFim.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            this.dataFim = dataFim;
        } else {
            System.out.println("O formato da data do fim informada esta incoreto.\nTente novamente passando a data no formato xx/xx/xxxx");
            this.setDataFim(scanner.nextLine());
        }
    }
    public void setDataInicio(String dataInicio) {
        if (dataInicio.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            this.dataInicio = dataInicio;
        } else {
            System.out.println("O formato da data de inicio informada esta incoreto.\nTente novamente passando a data no formato xx/xx/xxxx");
            this.setDataInicio(scanner.nextLine());
        }
    }
    public void setHoraInicio(String horaInicio) {
        if (horaInicio.matches("\\d{1,2}:\\d{2}")) {
            this.horaInicio = horaInicio;
        }
        else {
            System.out.println("O formato da hora de inicio informada esta incoreto.\nTente novamente passando a hora no formato xx:xx");
            this.setHoraInicio(scanner.nextLine());
        }
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
    public Organizador getOrganizador() {
        return organizador;
    }
    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public String getHoraInicio() {
        return horaInicio;
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
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
