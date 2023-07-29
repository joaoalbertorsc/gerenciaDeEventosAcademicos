package com.gerenciadorDeEventosAcademicos.view;
import com.gerenciadorDeEventosAcademicos.controller.AtividadesController;
import com.gerenciadorDeEventosAcademicos.model.*;
import java.util.Scanner;

public class AtividadesView implements Observer{

    private Model model;
    private AtividadesController controller;
    private Atividade atividadeEscolhida;
    private int escolhaUsuario;
    private Scanner scanner = new Scanner(System.in);

    public void initAtividadesView(Model model, Atividade atividadeEscolhida) { // iniciando view de atividade
        this.model = model;
        this.atividadeEscolhida = atividadeEscolhida;
        controller = new AtividadesController();
        controller.initAtividadesController(model, this);
        model.attachObserver(this);
        detalhesDaAtividade();

    }

    public void detalhesDaAtividade(){ // view da atividade
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
    public void nenhumPalestranteCadastrado(){
        System.out.println();
        System.out.println("Nenhum palestrante cadastrado...");
        System.out.println();
    }
    public void atribuirPalestrante(Organizador organizador){
        model.palestrantesCadastrados();
        System.out.println("Digite o ID correspondente ao palestrante que você deseja atribuir a atividade:" + getAtividadeEscolhida().getNome() + ":");
        int id = scanner.nextInt();
        organizador.atribuirPalestrante(model.getPalestrantesLista().get(id-1), getAtividadeEscolhida());
        System.out.println();
        System.out.println("Palestrante " + model.getPalestrantesLista().get(id-1).getNome() + " atribuido com sucesso!");
        System.out.println();
    }
    public void palestrantesAtribuidos(){
        int i = 0;
        System.out.println();
        System.out.println("Palestrantes atribuidos:");
        for (Palestrante palestrante : getAtividadeEscolhida().getPalestrantesDaAtividade()) {
            System.out.println("ID: " + i + " - " + "Nome: " + palestrante.getNome());
            i++;
        }
        System.out.println();
    }
    public void removerPalestrante(){
        System.out.println("Digite o ID correspondente ao palestrante que voce deseja remover da atividade:" + getAtividadeEscolhida().getNome() + ":");
    }
    public void participantesInscritos(){
        System.out.println("Participantes inscritos:");
        getAtividadeEscolhida().getParticipantesDaAtividade().forEach(participante -> System.out.println("Participante : " + participante.getNome()));
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
