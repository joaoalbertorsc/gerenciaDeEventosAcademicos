package com.gerenciadorDeEventosAcademicos.model;


import java.util.ArrayList;

public class Participante extends Usuario {

    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    public Participante(int id, String nome, String email, String senha, ArrayList<Atividade> atividades) {
        super(id, nome, email, senha);
        this.atividades = atividades;
    }

    public void inscreverseAtividade(Atividade atividade){}
    public void cancelarInscricaoAtividade(Atividade atividade){}

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}