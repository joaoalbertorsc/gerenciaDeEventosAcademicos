package com.gerenciadorDeEventosAcademicos.model;


import java.util.ArrayList;

public class Participante extends Usuario {
    private Atividade atividade;
    private ArrayList<Atividade> atividadesInscritas = new ArrayList<Atividade>();
    public void inscreverseAtividade(Atividade atividade){ // metodo para o participante se inscrever na atividade
        this.atividade = atividade;
        this.atividade.addParticipante(this);
    }
    public void cancelarInscricaoAtividade(Atividade atividade){ // metodo para o participante cancelar inscricao de uma atividade
        this.atividade = atividade;
        this.atividade.getParticipantesDaAtividade().remove(this);
    }

    public ArrayList<Atividade> getAtividadesInscritas() {
        return atividadesInscritas;
    }

    public void setAtividadesInscritas(ArrayList<Atividade> atividadesInscritas) {
        this.atividadesInscritas = atividadesInscritas;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}
