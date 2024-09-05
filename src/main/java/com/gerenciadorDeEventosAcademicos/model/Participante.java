package com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Participante extends Usuario {
    private Mediator mediator = new Mediator();
    private ArrayList<Atividade> atividadesInscritas = new ArrayList<Atividade>();

    public void inscreverseEmAtividade(Object object, Atividade atividade) { // metodo para o participante se inscrever na atividade
        mediator.inscreverseAtividade(object, atividade);
    }

    public void cancelarInscricaoAtividade(Object object, Atividade atividade) { // metodo para o participante cancelar inscricao de uma atividade
        mediator.cancelarInscricaoAtividade(object, atividade);
    }

    public ArrayList<Atividade> getAtividadesInscritas() {
        return atividadesInscritas;
    }

    public void setAtividadesInscritas(ArrayList<Atividade> atividadesInscritas) {
        this.atividadesInscritas = atividadesInscritas;
    }
}
