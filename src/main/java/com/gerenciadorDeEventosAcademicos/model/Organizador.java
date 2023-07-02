package com.gerenciadorDeEventosAcademicos.model;
import com.gerenciadorDeEventosAcademicos.view.PaginaEventosView;
import java.util.ArrayList;

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
        handleEvent1(i, model);
        scanner.close();
    }

    public void handleEvent1(int i, Model model){
        switch (i){
            case 1:
                System.out.println("Defina o novo nome desejado:");
                evento.setNome(scanner.nextLine());
                editarEvento(evento, model);
            case 2:
                System.out.println("Escreva a nova descirção desejada:");
                evento.setDescricao(scanner.nextLine());
                editarEvento(evento, model);
            case 3:
                editarEndereço(evento.getEndereco());
                editarEvento(evento, model);
            case 4:
                System.out.println("Defina uma nova data de inicio:");
                evento.setDataInicio(scanner.nextLine());
                editarEvento(evento, model);
            case 5:
                System.out.println("Defina uma nova data de encerramento:");
                evento.setDataFim(scanner.nextLine());
                editarEvento(evento, model);
            case 6:
                System.out.println("Defina um novo horário para inicio:");
                evento.setHoraInicio(scanner.nextLine());
                editarEvento(evento, model);
            case 7:
                System.out.println("Defina um novo horário para encerramento:");
                evento.setHoraInicio(scanner.nextLine());
                editarEvento(evento, model);
            case 8:
                PaginaEventosView pagina = new PaginaEventosView();
                pagina.initPaginaEventosView(model);
            default:
                System.out.println("Opção invalida, confira o numero digitado.");
                System.out.println("Tente novamente.");
                editarEvento(evento, model);
        }
        scanner.close();
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
    public void excluirEvento(int id){
        eventosCadastrados.remove(id);
        System.out.println("Evento " + eventosCadastrados.get(id).getNome() + " excluido com sucesso!");
    }

    public Atividade criarAtividade(){
        Atividade atividade = new Atividade(evento);
        atividadesCadastradas.add(atividade);
        System.out.println("Preencha com os dados da atividade >>>");
        System.out.println("Nome:");
        atividade.setNome(scanner.nextLine());
        System.out.println("Descrição:");
        atividade.setDescricao(scanner.nextLine());
        System.out.println("Data de inicio:");
        atividade.setDataInicio(scanner.nextLine());
        System.out.println("Data de finalizacao:");
        atividade.setDataFim(scanner.nextLine());
        System.out.println("Hora de inicio:");
        atividade.setHoraInicio(scanner.nextLine());
        System.out.println("Hora de finalizacao:");
        atividade.setHoraFim(scanner.nextLine());
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
