package com.gerenciadorDeEventosAcademicos.model;

public class Palestrante extends Participante {
    private Mediator mediator = new Mediator();

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", atividades: " + mediator.getAtividadesCadastradas() +
                '}';
    }

    public void inscreverseEmAtividade(Object object, Atividade atividade) {
        super.inscreverseEmAtividade(object, atividade);
    }

    public void cancelarInscricaoAtividade(Object object, Atividade atividade) {
        super.cancelarInscricaoAtividade(object, atividade);
    }

    public void editarAtividade(Model model, Atividade atividade) {
        mediator.editarAtividade(model, atividade);
    }

    public void handleEvent(int i, Model model, Atividade atividade) {
        switch (i) {
            case 1:
                mediator.definirNomeDaAtividade(model, atividade);
            case 2:
                mediator.definirDescricaoDaAtividade(model, atividade);
            case 3:
                mediator.definirDataDeInicioDaAtividade(model, atividade);
            case 4:
                mediator.definirDataDeEncerramentoDaAtividade(model, atividade);
            case 5:
                mediator.definirHorarioDeInicioDaAtividade(model, atividade);
            case 6:
                mediator.definirHorarioDeEncerramentoDaAtividade(model, atividade);
            default:
                mediator.erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }
}