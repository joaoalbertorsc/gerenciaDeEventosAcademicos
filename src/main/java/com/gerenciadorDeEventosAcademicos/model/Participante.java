package com.gerenciadorDeEventosAcademicos.model;


import java.util.ArrayList;

public class Participante extends Usuario {

    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    public void inscreverseAtividade(Atividade atividade){}
    public void cancelarInscricaoAtividade(Atividade atividade){}

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}
