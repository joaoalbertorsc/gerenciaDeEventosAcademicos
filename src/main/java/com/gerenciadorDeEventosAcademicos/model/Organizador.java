package com.gerenciadorDeEventosAcademicos.model;

public class Organizador extends Palestrante {
    private Mediator mediator = new Mediator();

    public String toString() {
        return "Organizador: " + getNome() +
                "\nEmail: " + getEmail();
    }

    public void realizarFrequencia(Atividade atividade, Frequencia frequencia) { // metodo para o organizador realizar a frequencia (nao ativo nessa versao);
        frequencia.marcarPresenca(atividade);
    }

    public void gerarCertificado(Frequencia frequencia, Atividade atividade) { // metodo para gerar certificados para todos os participanttes presentes em uma determinada atividade;
        Certificado certificado = new Certificado(atividade);
        for (Participante participante : frequencia.getParticipantesPresentes()) {
            certificado.emitirCertificado(participante);
        }
        System.out.println("Certificado(s) gerado(s) com sucesso!");
    }

    public Evento criarEvento() { // metodo para criar evento;
        return mediator.criarEvento();
    }

    public void editarEvento(Model model, Evento evento) { // metodo para editar um evento existente;
        mediator.editarEvento(model, evento);
    }

    public void handleEvent(int i, Model model, Evento evento) { // metodo para de acordo com a escolha do usuario fazer determinada funcao;
        switch (i) {
            case 1:
                mediator.definirNomeDoEvento(model, evento);
            case 2:
                mediator.definirDescricaoDoEvento(model, evento);
            case 3:
                mediator.editarEnderecoEvento(model, evento);
            case 4:
                mediator.editarDataInicioEvento(model, evento);
            case 5:
                mediator.editarDataEncerramentoEvento(model, evento);
            case 6:
                mediator.editarHorarioInicioEvento(model, evento);
            case 7:
                mediator.editarHorarioEncerramentoEvento(model, evento);
            case 8:
                mediator.telaDeDetalhesDoEvento(model, evento);
            default:
                mediator.erroAoSelecionarOpcaoDeEdicao(model, evento);
        }
    }

    public Atividade criarAtividade(Model model, Evento evento) { // metodo para criar uma atividade;
        return mediator.criarAtividade(model, evento);
    }

    public void removerPalestrante(Atividade atividade, Palestrante palestrante) { // metodo para remover um palestrante de uma atividade;
        mediator.removerPalestrate(atividade, palestrante);
    }

    public void excluirEvento(Evento evento) {
        mediator.excluirEvento(evento);
    }

    public void editarAtividade(Model model, Atividade atividade) { // metodo para editar uma atividade existente;
        super.editarAtividade(model, atividade);
    }

    public void excluirAtividade(Atividade atividade) { // metodo para excluir uma atividade existente;
        mediator.excluirAtividade(atividade);
    }

    public void atribuirPalestrante(Palestrante palestrante, Atividade atividade) { // metodo para atribuir um palestrante a uma atividade existente;
        mediator.atribuirPalestrante(palestrante, atividade);
    }
}
