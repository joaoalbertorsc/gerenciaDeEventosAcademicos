package main.java.com.gerenciadorDeEventosAcademicos.model;

import java.util.ArrayList;

public class Organizador extends Usuario{
    private ArrayList<Evento> eventos = new ArrayList<Evento>();
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

    public Organizador(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    public String toString(){
        return "Organizador: " + getNome() +
                "\nEmail: " + getEmail();
    }

    public void criarEvento(int id){
        Evento evento = new Evento(id);
        eventos.add(evento);
    }
    public void criarEvento(int id, String nome, String descricao, Endereco endereco, Organizador organizador, String dataInicio, String dataFim, String horaInicio){
        Evento evento = new Evento(id, nome,  descricao, endereco, organizador, dataInicio, dataFim, horaInicio);
        eventos.add(evento);
    }
    public void criarEvento(int id, String nome, String descricao, Endereco endereco, Organizador organizador, String dataInicio, String dataFim, String horaInicio, ArrayList<Atividade> atividadesDoEvento, ArrayList<Participante> participantesDoEvento, ArrayList<Palestrante> palestrantesDoEvento){
        Evento evento = new Evento(id, nome,  descricao, endereco, organizador, dataInicio, dataFim, horaInicio, atividadesDoEvento, participantesDoEvento, palestrantesDoEvento);
        eventos.add(evento);
    }

    public void editarEvento(Evento evento){}

    public void excluirEvento(int id){}

    public void criarAtividade(int id){
        Atividade atividade = new Atividade(id);
        atividades.add(atividade);
    }

    public void editarAtividade(Atividade atividade){}

    public void excluirAtividade(Atividade atividade){}

    public void atribuirPalestrante(Palestrante palestrante, Atividade atividade){}

    public void visualizarParticipantes(Evento evento){}

    public void visualizarParticipantes(Atividade atividade, Evento evento){}

    public void visualizarPalestrantes(Evento evento){}

    public void visualizarPalestrantes(Atividade atividade, Evento evento){}

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = atividades;
    }
}
