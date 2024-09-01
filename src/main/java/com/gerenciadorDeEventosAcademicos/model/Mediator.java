package com.gerenciadorDeEventosAcademicos.model;

import java.util.Scanner;

public class Mediator {
    private Atividade atividade;
    private Model model;
    private Organizador organizador;
    private Palestrante palestrante;
    private Participante participante;
    private Scanner scanner = new Scanner(System.in);


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

    public void editarAtividade(Model model, Atividade atividade) {
        this.atividade = atividade;
        this.model = model;
        if (model.getUsuario() instanceof Palestrante){
            this.palestrante = (Palestrante) model.getUsuario();
            palestrante.menuEdicaoAtividade();
            int i = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            palestrante.handleEvent(i, model, atividade);
            scanner.close();
        } else {
            this.organizador = (Organizador) model.getUsuario();
            organizador.menuEdicaoAtividade();
            int i = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            organizador.handleEvent(i, model, atividade);
            scanner.close();
        }
    }
}
