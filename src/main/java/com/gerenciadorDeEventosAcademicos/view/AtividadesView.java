package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.AtividadesController;
import com.gerenciadorDeEventosAcademicos.model.*;

import java.util.Scanner;

public class AtividadesView implements Observer{

    private Model model;
    private AtividadesController controller;
    private Atividade atividadeEscolhida;
    private int escolhaUsuario;

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
        String[] opcoes = { "[1] - Realizar inscricao na atividade", "[2] - Ver participante(s) inscritos", "[3] - Voltar a pagina inicial", "[4] - Sair do sistema", "index-4","index-5","index-6"};
        System.out.println("=========================================");
        System.out.println("| Detalhes sobre a atividade: " + atividadeEscolhida.getNome() + " |");
        System.out.println("=========================================");
        System.out.println(atividadeEscolhida);
        System.out.println();
        if (model.getUsuario() instanceof Participante){
            if (atividadeEscolhida.getParticipantesDaAtividade().contains((Participante) model.getUsuarioAutenticado())){
                System.out.println("***Voce já está inscrito nessa atividade!***");
                opcoes[0] = "[1] - Cancelar inscrição";
            }
        } else if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            opcoes[0] = "[1] - Editar atividade";
        } else {
            opcoes[1] = "[2] - Atribuir palestrante";
            opcoes[2] = "[3] - Remover palestrante";
            opcoes[3] = "[4] - Emitir certificados dos participantes";
            opcoes[4] = "[5] - Ver participantes inscritos";
            opcoes[5] = "[6] - Ver palestrantes atribuidos";
            opcoes[6] = "[7] - Excluir atividade";
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
    @Override
    public void update() {

    }
}
