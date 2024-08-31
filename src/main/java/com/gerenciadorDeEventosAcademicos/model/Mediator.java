package com.gerenciadorDeEventosAcademicos.model;

public class Mediator {
    private Atividade atividade;
    private Model model;
    private Palestrante palestrante;
    private Participante participante;
    public Mediator() {
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    public void setModel(Model model) {
        this.model = model;
    }
    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public void inscreverseAtividade(Object object, Atividade atividade) {
        setAtividade(atividade);
        if (object != null){
            if (object instanceof Participante){
                Participante p = (Participante) object;
                setParticipante(p);
                atividade.addParticipante(p);
            } else {
                Palestrante p = (Palestrante) object;
                setPalestrante(p);
                atividade.addPalestrante(p);
            }
        }
    }
    public void cancelarInscricaoAtividade(Object object, Atividade atividade) {
        setAtividade(atividade);
        if (object != null){
            atividade.removerParticipante(object, atividade);
        }
    }
}
