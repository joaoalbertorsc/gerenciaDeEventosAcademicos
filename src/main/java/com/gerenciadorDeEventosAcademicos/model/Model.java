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

    public Usuario autenticarUsuario(String login, String senha) {
        Usuario usuario;
        if (login != null && senha != null) {
            usuario = usuarios.get(login);
            if (usuario != null) {
                if (login.equals(usuario.getId()) && senha.equals(usuario.getSenha())){
                    usuarioAutenticado = usuario;
                }
            }
        }
        return usuarioAutenticado;
    }

    public void deslogarUsuario() {
        usuarioAutenticado = null;
        MainView mainView = new MainView();
        mainView.initMainView(this);
        notifica();
    }

    public void sair(){

    }

    public void voltarPaginaInicial(){
        MainView mainView = new MainView();
        mainView.initMainView(this);
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public Usuario getUsuarioSistema(String id) {
        if (id != null) {
            Usuario usuario = usuarios.get(id);
            return usuario;
        }
        return null;
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

    public void setUsuarioAutenticado(Usuario usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public ArrayList<Participante> getParticipantesLista() {
        return participantesLista;
    }
    public ArrayList<Palestrante> getPalestrantesLista() {
        return palestrantesLista;
    }

    public ArrayList<Organizador> getOrganizadoresLista() {
        return organizadoresLista;
    }

    public ArrayList<Atividade> getAtividadesCadastrados() {
        return atividadesCadastrados;
    }
}
