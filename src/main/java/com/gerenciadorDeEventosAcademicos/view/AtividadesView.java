package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.AtividadesController;
import com.gerenciadorDeEventosAcademicos.model.*;
import java.util.Scanner;

public class AtividadesView implements Observer{

    private Model model;
    private AtividadesController controller;
    private Atividade atividadeEscolhida;
    private int escolhaUsuario;

    public void initAtividadesView(Model model, Atividade atividadeEscolhida) { // iniciando view de atividade
        this.model = model;
        this.atividadeEscolhida = atividadeEscolhida;
        controller = new AtividadesController();
        controller.initAtividadesController(model, this);
        model.attachObserver(this);
        detalhesDaAtividade();

    }

    public void detalhesDaAtividade(){ // view da atividade
        Scanner scanner = new Scanner(System.in);
        String[] opcoes = { "[1] - Realizar inscricao na atividade", "[2] - Ver participante(s) inscritos", "[3] - Voltar a pagina inicial", "[4] - Sair do sistema", "index-4","index-5","index-6", "index-7", "index-8"};
        System.out.println("=========================================");
        System.out.println("| Detalhes sobre a atividade: " + atividadeEscolhida.getNome() + " |");
        System.out.println("=========================================");
        System.out.println(atividadeEscolhida);
        System.out.println();
        if (model.getUsuario() instanceof Organizador){
            opcoes[0] = "[1] - Editar atividade";
            opcoes[1] = "[2] - Atribuir palestrante";
            opcoes[2] = "[3] - Remover palestrante";
            opcoes[3] = "[4] - Emitir certificados dos participantes";
            opcoes[4] = "[5] - Ver participantes inscritos";
            opcoes[5] = "[6] - Ver palestrantes atribuidos";
            opcoes[6] = "[7] - Excluir atividade";
            opcoes[7] = "[8] - Voltar a pagina inicial";
            opcoes[8] = "[9] - Sair";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println(opcoes[4]);
            System.out.println(opcoes[5]);
            System.out.println(opcoes[6]);
            System.out.println(opcoes[7]);
            System.out.println(opcoes[8]);
        } else if (model.getUsuario() instanceof Palestrante) {
            opcoes[0] = "[1] - Editar atividade";
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
        } else {
            if (atividadeEscolhida.getParticipantesDaAtividade().contains((Participante) model.getUsuario())){
                System.out.println("***Voce ja esta inscrito nessa atividade!***");
                opcoes[0] = "[1] - Cancelar inscricao";
            }
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
        }
        System.out.println("Escolha uma opcao: ");
        escolhaUsuario = scanner.nextInt();
        controller.handleEvent(escolhaUsuario);
        model.detachObserver(this);

    }

    public void inscricaoRealizada(){
        System.out.println("Inscricao realizada com sucesso!");
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public AtividadesController getController() {
        return controller;
    }

    public void setController(AtividadesController controller) {
        this.controller = controller;
    }

    @Override
    public void update() {

    }
}
