package com.gerenciadorDeEventosAcademicos.model;

import com.gerenciadorDeEventosAcademicos.view.AtividadesView;
import com.gerenciadorDeEventosAcademicos.view.DetalhesEventoView;

import java.util.ArrayList;
import java.util.Scanner;

public class Mediator {
    private Atividade atividade;
    private ArrayList<Atividade> atividadesCadastradas = new ArrayList<Atividade>();
    private Evento evento;
    private ArrayList<Evento> eventosCadastrados = new ArrayList<Evento>();
    private Model model;
    private Organizador organizador;
    private Palestrante palestrante;
    private Participante participante;
    private Scanner scanner;

    public Mediator() {
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public ArrayList<Atividade> getAtividadesCadastradas() {
        return atividadesCadastradas;
    }

    public Evento getEvento() {
        return evento;
    }

    public ArrayList<Evento> getEventosCadastrados() {
        return eventosCadastrados;
    }

    public void inscreverseAtividade(Object object, Atividade atividade) {
        setAtividade(atividade);
        if (object != null) {
            if (object instanceof Participante) {
                Participante p = (Participante) object;
                setParticipante(p);
                p.getAtividadesInscritas().add(atividade);
                atividade.addParticipante(p);
            } else {
                Palestrante p = (Palestrante) object;
                setPalestrante(p);
                p.getAtividadesInscritas().add(atividade);
                atividade.addPalestrante(p);
            }
        }
    }

    public void cancelarInscricaoAtividade(Object object, Atividade atividade) {
        setAtividade(atividade);
        if (object != null) {
            atividade.removerParticipante(object, atividade);
        }
    }

    public void editarAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        setAtividade(atividade);
        setModel(model);
        if (model.getUsuario() instanceof Palestrante) {
            setPalestrante((Palestrante) model.getUsuario());
            menuEdicaoAtividade();
            int i = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            palestrante.handleEvent(i, model, atividade);
        } else {
            setOrganizador((Organizador) model.getUsuario());
            menuEdicaoAtividade();
            int i = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            organizador.handleEvent(i, model, atividade);
        }

    }

    public void menuEdicaoAtividade() {
        System.out.println("Qual atributo da atividade voce deseja editar?");
        System.out.println("----------------------------------------------");
        System.out.println("[1] - Nome:");
        System.out.println("[2] - Descrição:");
        System.out.println("[3] - Data de inicio:");
        System.out.println("[4] - Data de fim:");
        System.out.println("[5] - Hora de inicio:");
        System.out.println("[6] - Hora de fim:");
        System.out.println("----------------------------------------------");
        System.out.println("Escolha uma opcao:");
    }

    public void definirNomeDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Defina o novo nome desejado:");
            atividade.setNome(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void definirDescricaoDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Escreva a nova descricao desejada:");
            atividade.setDescricao(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void definirDataDeInicioDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Defina uma nova data de inicio:");
            atividade.setDataInicio(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void definirDataDeEncerramentoDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Defina uma nova data de encerramento:");
            atividade.setDataFim(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void definirHorarioDeInicioDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Defina um novo horario para inicio:");
            atividade.setHoraInicio(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void definirHorarioDeEncerramentoDaAtividade(Model model, Atividade atividade) {
        this.scanner = new Scanner(System.in);
        if (model.getUsuario() instanceof Palestrante || model.getUsuario() instanceof Organizador) {
            System.out.println("Defina um novo horario para encerramento:");
            atividade.setHoraInicio(scanner.nextLine());
            AtividadesView view = new AtividadesView();
            view.initAtividadesView(model, atividade);
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, atividade);
        }
    }

    public void erroAoSelecionarOpcaoDeEdicao(Model model, Atividade atividade) {
        System.out.println("Opcao invalida, confira o numero digitado.");
        System.out.println("Tente novamente.");
        editarAtividade(model, atividade);
    }

    public void erroAoSelecionarOpcaoDeEdicao(Model model, Evento evento) {
        System.out.println("Opcao invalida, confira o numero digitado.");
        System.out.println("Tente novamente.");
        editarEvento(model, evento);
    }

    public Evento criarEvento() {
        this.scanner = new Scanner(System.in);
        Evento evento = new Evento();
        eventosCadastrados.add(evento);

        System.out.println("Preencha os dados para a criacao do evento:");
        System.out.println("Nome:");
        evento.setNome(scanner.nextLine());
        System.out.println("Descricao:");
        evento.setDescricao(scanner.nextLine());
        System.out.println("---------------------------------------------------------");
        System.out.println("Endereco >>> ");
        evento.criarEndereco();
        System.out.println("Data de Inicio:");
        evento.setDataInicio(evento.definirDataInicio(scanner.nextLine()));
        System.out.println("Data de Fim:");
        evento.setDataFim(evento.definirDataEncerramento(scanner.nextLine()));
        System.out.println("Hora de Inicio:");
        evento.setHoraInicio(evento.definirHorarioInicio(scanner.nextLine()));

        return evento;
    }

    public void editarEvento(Model model, Evento evento) {
        this.scanner = new Scanner(System.in);
        this.evento = evento;

        if (model.getUsuario() instanceof Organizador) {
            this.organizador = (Organizador) model.getUsuario();
        } else {
            erroAoSelecionarOpcaoDeEdicao(model, evento);
        }
        menuEdicaoEvento();
        int i = scanner.nextInt();
        scanner.nextLine();
        organizador.handleEvent(i, model, evento);

    }

    private void menuEdicaoEvento() {
        System.out.println("Qual atributo do evento você deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - Descricao");
        System.out.println("[3] - Endereco");
        System.out.println("[4] - Data de inicio");
        System.out.println("[5] - Data de fim");
        System.out.println("[6] - Hora de inicio");
        System.out.println("[7] - Hora de fim");
        System.out.println("[8] - Voltar a tela anterior");
        System.out.println("Escolha uma opcao:");
    }

    public void definirNomeDoEvento(Model model, Evento evento) {
        this.scanner = new Scanner(System.in);
        System.out.println("Defina o novo nome desejado:");
        String nome = scanner.nextLine();

        evento.setNome(nome);
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void definirDescricaoDoEvento(Model model, Evento evento) {
        this.scanner = new Scanner(System.in);
        System.out.println("Escreva a nova descricao desejada:");
        String descricao = scanner.nextLine();

        evento.setDescricao(descricao);
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void editarEnderecoEvento(Model model, Evento evento) {
        this.scanner = new Scanner(System.in);
        menuEdicaoEndereco();
        int i = Integer.parseInt(scanner.nextLine());
        editarOpcaoDesejada(i, evento);

        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    private void menuEdicaoEndereco() {
        System.out.println("Qual informacao voce deseja alterar?");
        System.out.println("-----------------------------------");
        System.out.println("[1] - Rua");
        System.out.println("[2] - Numero");
        System.out.println("[3] - Cidade");
        System.out.println("[4] - Referencia");
        System.out.println("-----------------------------------");
        System.out.println("Digite o numero da opcao desejada:");
    }

    public void editarOpcaoDesejada(int i, Evento evento) { // metodo para de acordo com a entrada do usuario, realizar as alteracoes do endereco;
        this.scanner = new Scanner(System.in);
        this.evento = evento;
        switch (i) {
            case 1:
                System.out.println("Defina o novo nome da rua:");
                evento.getEndereco().setRua(scanner.nextLine());
            case 2:
                System.out.println("Defina o novo numero do endereco:");
                evento.getEndereco().setNumero(scanner.nextLine());
            case 3:
                System.out.println("Defina o novo nome da cidade:");
                evento.getEndereco().setCidade(scanner.nextLine());
            case 4:
                System.out.println("Descreva a nova referencia:");
                evento.getEndereco().setReferencia(scanner.nextLine());
        }

    }

    public void editarDataInicioEvento(Model model, Evento evento) {
        this.model = model;
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        System.out.println("Defina uma nova data de inicio:");
        String dataInicio = scanner.nextLine();

        evento.setDataInicio(dataInicio);
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void editarDataEncerramentoEvento(Model model, Evento evento) {
        this.model = model;
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        System.out.println("Defina uma nova data de encerramento:");
        String dataFim = scanner.nextLine();

        evento.setDataFim(dataFim);
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(this.model, this.evento);
    }

    public void editarHorarioInicioEvento(Model model, Evento evento) {
        this.model = model;
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        System.out.println("Defina um novo horario para inicio:");
        String horarioInicio = scanner.nextLine();

        evento.setHoraInicio(horarioInicio);
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public void editarHorarioEncerramentoEvento(Model model, Evento evento) {
        this.model = model;
        this.evento = evento;
        this.scanner = new Scanner(System.in);
        System.out.println("Defina um novo horario para encerramento:");
        String horarioFim = scanner.nextLine();

        evento.setHoraInicio(horarioFim);
        DetalhesEventoView view5 = new DetalhesEventoView();
        view5.initDetalhesEventoView(model, evento);
    }

    public void telaDeDetalhesDoEvento(Model model, Evento evento) {
        DetalhesEventoView view = new DetalhesEventoView();
        view.initDetalhesEventoView(model, evento);
    }

    public Atividade criarAtividade(Model model, Evento evento) {
        this.model = model;
        this.scanner = new Scanner(System.in);
        this.organizador = (Organizador) model.getUsuario();

        Atividade atividade = new Atividade();
        atividade.setEvento(evento);
        atividadesCadastradas.add(atividade);

        System.out.println("Preencha com os dados da atividade >>>");
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        atividade.setNome(nome);
        System.out.println("Descricao:");
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

    public void removerPalestrate(Atividade atividade, Palestrante palestrante) {
        this.atividade = atividade;
        this.palestrante = palestrante;
        ArrayList<Palestrante> listaAntigaDePalestrantes;
        ArrayList<Palestrante> listaAtualDePalestrantes;

        listaAntigaDePalestrantes = atividade.getPalestrantesDaAtividade();
        listaAntigaDePalestrantes.remove(palestrante);
        listaAtualDePalestrantes = listaAntigaDePalestrantes;
        atividade.setPalestrantesDaAtividade(listaAtualDePalestrantes);

        System.out.println();
        System.out.println("Palestrante " + palestrante.getNome() + " removido com sucesso!");
        System.out.println();
    }

    public void excluirEvento(Evento evento) {
        eventosCadastrados.remove(evento);
        System.out.println();
        System.out.println("Evento removido com sucesso!");
        System.out.println();
    }

    public void excluirAtividade(Atividade atividade) {
        atividadesCadastradas.remove(atividade);
        System.out.println("Atividade " + atividade.getNome() + " excluida com sucesso!");
    }

    public void atribuirPalestrante(Palestrante palestrante, Atividade atividade) {
        atividade.addPalestrante(palestrante);
    }
}
