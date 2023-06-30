package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.AtividadesController;
import com.gerenciadorDeEventosAcademicos.controller.DetalhesEventoController;
import com.gerenciadorDeEventosAcademicos.model.Atividade;
import com.gerenciadorDeEventosAcademicos.model.Model;

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

    }

    public void escolherAtividade(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("Detalhes sobre a atividade: " + atividadeEscolhida.getNome());
        System.out.println("============================================");
        atividadeEscolhida.toString();
        System.out.println();
        System.out.println("[1] - Inscrever-se nessa atividade" +
                "\n[2] - Ver participante(s) inscritos" +
                "\n[3] - Voltar a pagina anterior" +
                "\n[4] - Sair do sistema");



        model.detachObserver(this);
    }

    public Atividade getAtividadeEscolhida() {
        return atividadeEscolhida;
    }

    public void setAtividadeEscolhida(Atividade atividadeEscolhida) {
        this.atividadeEscolhida = atividadeEscolhida;
    }

    @Override
    public void update() {

    }
}
