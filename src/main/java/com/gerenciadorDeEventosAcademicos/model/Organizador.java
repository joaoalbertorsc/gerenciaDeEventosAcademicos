package com.gerenciadorDeEventosAcademicos.model;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;
import java.util.ArrayList;
import java.util.Scanner;

public class Organizador extends Palestrante{
    private Evento evento;
    private ArrayList<Evento> eventosCadastrados = new ArrayList<Evento>();
    private ArrayList<Atividade> atividadesCadastradas = new ArrayList<Atividade>();

    public String toString(){
        return "Organizador: " + getNome() +
                "\nEmail: " + getEmail();
    }
    public void realizarFrequencia(Atividade atividade, Frequencia frequencia){
        frequencia.marcarPresenca(atividade);
    }
    public void gerarCertificado(Frequencia frequencia, Atividade atividade){
        Certificado certificado = new Certificado(atividade);
        for (Participante participante: frequencia.getParticipantesPresentes()) {
            certificado.emitirCertificado(participante);
        }
        System.out.println("Certificado(s) gerado(s) com sucesso!");
    }

    public Evento criarEvento(){
        Evento evento = new Evento();
        eventosCadastrados.add(evento);
        System.out.println("Preencha os dados para a criacao do evento:");
        System.out.println("Nome:");
        evento.setNome(scanner.nextLine());
        System.out.println("Descrição:");
        evento.setDescricao(scanner.nextLine());
        System.out.println("---------------------------------------------------------");
        System.out.println("Endereço >>> ");
        evento.criarEndereco();
        System.out.println("Data de Início:");
        evento.setDataInicio(scanner.nextLine());
        System.out.println("Data de Fim:");
        evento.setDataFim(scanner.nextLine());
        System.out.println("Hora de Início:");
        evento.setHoraInicio(scanner.nextLine());
        return evento;
    }

    public void editarEvento(Evento evento, Model model){
        this.evento = evento;
        System.out.println("Qual atributo do evento você deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Descrição");
        System.out.println("[3] - Endereço");
        System.out.println("[4] - Data de Início");
        System.out.println("[5] - Data de Fim");
        System.out.println("[6] - Hora de Início");
        System.out.println("[7] - Hora de Fim");
        System.out.println("[8] - Voltar a tela anterior");
        System.out.println("Escolha uma opcção:");
        int i = scanner.nextInt();
        scanner.nextLine();
        handleEvent1(i, model);
        scanner.close();
    }

    public void handleEvent1(int i, Model model){
        Scanner sc = new Scanner(System.in);
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                String nome = sc.nextLine();
                evento.setNome(nome);
                DetalhesEventoView view = new DetalhesEventoView();
                view.initDetalhesEventoView(model, evento);
            case 2:
                System.out.println("Escreva a nova descirção desejada:");
                String descricao = sc.nextLine();
                evento.setDescricao(descricao);
                DetalhesEventoView view0 = new DetalhesEventoView();
                view0.initDetalhesEventoView(model, evento);
            case 3:
                editarEndereço(evento.getEndereco());
                DetalhesEventoView view1 = new DetalhesEventoView();
                view1.initDetalhesEventoView(model, evento);
            case 4:
                System.out.println("Defina uma nova data de inicio:");
                String dataInicio = sc.nextLine();
                evento.setDataInicio(dataInicio);
                DetalhesEventoView view2 = new DetalhesEventoView();
                view2.initDetalhesEventoView(model, evento);
            case 5:
                System.out.println("Defina uma nova data de encerramento:");
                String dataFim = sc.nextLine();
                evento.setDataFim(dataFim);
                DetalhesEventoView view3 = new DetalhesEventoView();
                view3.initDetalhesEventoView(model, evento);
            case 6:
                System.out.println("Defina um novo horário para inicio:");
                String horarioInicio = sc.nextLine();
                evento.setHoraInicio(horarioInicio);
                DetalhesEventoView view4 = new DetalhesEventoView();
                view4.initDetalhesEventoView(model, evento);
            case 7:
                System.out.println("Defina um novo horário para encerramento:");
                String horarioFim = sc.nextLine();
                evento.setHoraInicio(horarioFim);
                DetalhesEventoView view5 = new DetalhesEventoView();
                view5.initDetalhesEventoView(model, evento);
            case 8:
                DetalhesEventoView view6 = new DetalhesEventoView();
                view6.initDetalhesEventoView(model, evento);
            default:
                System.out.println("Opção invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarEvento(evento, model);
        }
    }

    public void editarEndereço(Endereco endereco){
        System.out.println("Qual informação você deseja alterar?");
        String[] opcoes = {"[1] - Rua", "[2] - Numero", "[3] - Cidade", "[4] - Referencia"};
        System.out.println(opcoes[0]);
        System.out.println(opcoes[1]);
        System.out.println(opcoes[2]);
        System.out.println(opcoes[3]);
        System.out.println("Digite o numero da opcao desejada:");
        int i = scanner.nextInt();
        handleEvent2(i, endereco);
        scanner.close();
    }

    public void handleEvent2(int i, Endereco endereco){

        switch (i){
            case 1:
                System.out.println("Defina o novo nome da Rua:");
                endereco.setRua(scanner.nextLine());
            case 2:
                System.out.println("Defina o novo Numero do endereco:");
                endereco.setNumero(scanner.nextLine());
            case 3:
                System.out.println("Defina o novo nome da cidade:");
                endereco.setCidade(scanner.nextLine());
            case 4:
                System.out.println("Descreva a nova referencia:");
                endereco.setReferencia(scanner.nextLine());
        }

    }
    public void excluirEvento(Evento evento){
        eventosCadastrados.remove(evento);
        System.out.println("Evento " + evento.getNome() + " excluido com sucesso!");
    }

    public Atividade criarAtividade(){
        Atividade atividade = new Atividade(evento);
        atividadesCadastradas.add(atividade);
        System.out.println("Preencha com os dados da atividade >>>");
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        atividade.setNome(nome);
        System.out.println("Descrição:");
        String descricao = scanner.nextLine();
        atividade.setDescricao(descricao);
        System.out.println("Data de inicio:");
        String dataInicio = scanner.nextLine();
        atividade.setDataInicio(dataInicio);
        System.out.println("Data de finalizacao:");
        String dataFim = scanner.nextLine();
        atividade.setDataFim(dataFim);
        System.out.println("Hora de inicio:");
        String horaInicio = scanner.nextLine();
        atividade.setHoraInicio(horaInicio);
        System.out.println("Hora de finalizacao:");
        String horaFim = scanner.nextLine();
        atividade.setHoraFim(horaFim);
        return atividade;
    }

    public void removerPalestrante(Atividade atividade, Palestrante palestrante){
        atividade.getPalestrantesDaAtividade().remove(palestrante.getId());
        System.out.println();
        System.out.println("Palestrante " + palestrante.getNome() + " removido com sucesso!");
        System.out.println();
    }

    public void editarAtividade(Atividade atividade){}

    public void excluirAtividade(Atividade atividade){
        atividadesCadastradas.remove(atividade);
        System.out.println("Atividade " + atividade.getNome() + " excluida com sucesso!");
    }

    public void atribuirPalestrante(Palestrante palestrante, Atividade atividade){
        atividade.addPalestrante(palestrante);
    }

    public void visualizarParticipantes(Evento evento){}

    public void visualizarParticipantes(Atividade atividade, Evento evento){}

    public void visualizarPalestrantes(Evento evento){}

    public void visualizarPalestrantes(Atividade atividade, Evento evento){}

    public ArrayList<Evento> getEventos() {
        return eventosCadastrados;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventosCadastrados = eventos;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividadesCadastradas;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividadesCadastradas = atividades;
    }
}
