package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Palestrante extends Usuario {

    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", atividades=" + atividades +
                '}';
    }

    public void inscreverseAtividade(Atividade atividade){}
    public void cancelarInscricaoAtividade(Atividade atividade){}
    public void editarAtividade(Atividade atividae){}

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}