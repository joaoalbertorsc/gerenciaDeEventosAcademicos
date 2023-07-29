package com.gerenciadorDeEventosAcademicos.model;

import com.gerenciadorDeEventosAcademicos.view.MainView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {

    private Usuario usuario;
    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>();
    private Usuario usuarioAutenticado;
    private ArrayList<Participante> participantesLista = new ArrayList<Participante>();
    private ArrayList<Palestrante> palestrantesLista = new ArrayList<Palestrante>();
    private ArrayList<Organizador> organizadoresLista = new ArrayList<Organizador>();
    private ArrayList<Evento> eventosCadastrados = new ArrayList<Evento>();
    private ArrayList<Atividade> atividadesCadastrados = new ArrayList<Atividade>();
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public void attachObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }
    public void detachObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }
    public void notifica(){
        for (Observer o: observers) {
            o.update();
        }
    }
    public Usuario autenticarUsuario(String login, String senha) { // metodo para autenticar o usuario;
        Usuario usuario;
        if (login != null && senha != null) {
            usuario = usuarios.get(login);
            if (usuario != null) {
                if (login.equals(usuario.getId()) && senha.equals(usuario.getSenha())){
                    this.usuario = usuario;
                }
            }
        }
        return this.usuario;
    }
    public void deslogarUsuario() { // metodo para deslogar e voltar a pagina inicial do sistema;
        usuario = null;
        MainView mainView = new MainView();
        mainView.initMainView(this);
        notifica();
    }
    public void voltarPaginaInicial() { // metodo para voltaar a pagina inicial do sistema;
        MainView mainView = new MainView();
        mainView.initMainView(this);
    }
    public void setUsuarioSistema(Usuario usuario) {
        if (usuario != null && usuario.getId() != null) {
            usuarios.put(usuario.getId(), usuario);
            notifica();
        }
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Evento> getEventosCadastrados() {
        return eventosCadastrados;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public ArrayList<Participante> getParticipantesLista() {
        return participantesLista;
    }
    public ArrayList<Palestrante> getPalestrantesLista() {
        return palestrantesLista;
    }
    public void palestrantesCadastrados() {
        int i = 0;
        System.out.println();
        System.out.println("Palestrantes cadastrados:");
        for (Palestrante palestrante : getPalestrantesLista()) {
            System.out.println("ID: " + i + " - " + "Nome: " + palestrante.getNome());
            i++;
        }
        System.out.println();
    }

    public ArrayList<Organizador> getOrganizadoresLista() {
        return organizadoresLista;
    }

    public ArrayList<Atividade> getAtividadesCadastrados() {
        return atividadesCadastrados;
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public void setParticipantesLista(ArrayList<Participante> participantesLista) {
        this.participantesLista = participantesLista;
    }

    public void setPalestrantesLista(ArrayList<Palestrante> palestrantesLista) {
        this.palestrantesLista = palestrantesLista;
    }

    public void setOrganizadoresLista(ArrayList<Organizador> organizadoresLista) {
        this.organizadoresLista = organizadoresLista;
    }

    public void setEventosCadastrados(ArrayList<Evento> eventosCadastrados) {
        this.eventosCadastrados = eventosCadastrados;
    }

    public void setAtividadesCadastrados(ArrayList<Atividade> atividadesCadastrados) {
        this.atividadesCadastrados = atividadesCadastrados;
    }
}
