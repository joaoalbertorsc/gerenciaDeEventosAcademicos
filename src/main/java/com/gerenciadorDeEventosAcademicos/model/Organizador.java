package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Organizador extends Usuario{
    private ArrayList<Evento> eventos = new ArrayList<Evento>();
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    public String toString(){
        return "Organizador: " + getNome() +
                "\nEmail: " + getEmail();
    }

    public void criarEvento(){
        Evento evento = new Evento();
        eventos.add(evento);
    }

    public void editarEvento(Evento evento){}

    public void excluirEvento(int id){}

    public void criarAtividade(int id, String atividade01, String primeira_atividade, Local local01, Palestrante palestrante01, String s, String s1, String s2, String s3, ArrayList<Participante> participantes){
        Atividade atividade = new Atividade(id, atividade01, primeira_atividade,local01, palestrante01, s, s1, s2, s3, participantes);
        atividades.add(atividade);
    }

    public void editarAtividade(Atividade atividade){}

    public void excluirAtividade(Atividade atividade){}

    public void atribuirPalestrante(Palestrante palestrante, Atividade atividade){}

    public void visualizarParticipantes(Evento evento){}

    public void visualizarParticipantes(Atividade atividade, Evento evento){}

    public void visualizarPalestrantes(Evento evento){}

    public void visualizarPalestrantes(Atividade atividade, Evento evento){}

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}
