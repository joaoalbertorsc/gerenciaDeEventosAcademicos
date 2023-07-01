package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.AtividadesController;
import com.gerenciadorDeEventosAcademicos.model.*;

import java.util.Scanner;

public class AtividadesView implements Observer{

    private Model model;
    private AtividadesController controller;
    private Atividade atividadeEscolhida;
    private int escolhaUsuario;
    private Usuario usuario = model.getUsuarioAutenticado();

    public void initAtividadesView(Model model, Atividade atividadeEscolhida) {
        this.model = model;
        this.atividadeEscolhida = atividadeEscolhida;
        controller = new AtividadesController();
        controller.initAtividadesController(model, this);
        model.attachObserver(this);
        detalhesDaAtividade();

    }

    public void detalhesDaAtividade(){
        Scanner scanner = new Scanner(System.in);
        String[] opcoes = { "[1] - Inscrever-se nessa atividade", "[2] - Ver participante(s) inscritos", "[3] - Voltar a pagina inicial", "[4] - Sair do sistema"};
        System.out.println("============================================");
        System.out.println("Detalhes sobre a atividade: " + atividadeEscolhida.getNome());
        System.out.println("============================================");
        atividadeEscolhida.toString();
        System.out.println();
        if (usuario instanceof Participante){
            usuario = (Participante) model.getUsuarioAutenticado();
            if (atividadeEscolhida.getParticipantesDaAtividade().contains((Participante) model.getUsuarioAutenticado())){
                System.out.println("***Voce já está inscrito nessa atividade!***");
                opcoes[0] = "[1] - Cancelar inscrição";
            }
        } else if (usuario instanceof Palestrante || usuario instanceof Organizador) {
            opcoes[0] = "[1] - Editar atividade";
        } else {
            opcoes[1] = "[2] - Atribuir palestrante";
            opcoes[2] = "[3] - Emitir certificados dos participantes";
            opcoes[3] = "[4] - Ver participantes inscritos";
            opcoes[4] = "[5] - Ver palestrantes atribuidos";
            opcoes[5] = "[6] - Excluir atividade";
        }
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println(opcoes[2]);
        System.out.println(opcoes[3]);
        escolhaUsuario = scanner.nextInt();
        controller.handleEvent(escolhaUsuario);
        model.detachObserver(this);

    }

    public void inscricaoRealizada(){
        System.out.println("Inscrição realizada com sucesso!");
    }

    public Atividade getAtividadeEscolhida() {
        return atividadeEscolhida;
    }

    public void setAtividadeEscolhida(Atividade atividadeEscolhida) {
        this.atividadeEscolhida = atividadeEscolhida;
    }

    public int getEscolhaUsuario() {
        return escolhaUsuario;
    }

    public void setEscolhaUsuario(int escolhaUsuario) {
        this.escolhaUsuario = escolhaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void update() {

    }
}
