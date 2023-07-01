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
    public void editarAtividade(Atividade atividae){

        System.out.println("Qual atributo da atividade você deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Descrição");
        System.out.println("[3] - Data de Início");
        System.out.println("[4] - Data de Fim");
        System.out.println("[5] - Hora de Início");
        System.out.println("[6] - Hora de Fim");


    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}