package com.gerenciadorDeEventosAcademicos.model;

import com.gerenciadorDeEventosAcademicos.view.LoginView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class Model {


    private HashMap<String,Usuario> usuarios = new HashMap<String, Usuario>();
    private Usuario usuarioAutenticado;
    private ArrayList<Evento> totalEventos;
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
        LoginView view = new LoginView();
        view.initLoginView(this);
        notifica();
    }

    public void voltar(){
        LoginView loginView = new LoginView();
        loginView.initLoginView(this);
    }

    public Usuario getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public int getTotalUsuarios() {
        return usuarios.size();
    }

    public Usuario getUsuario(String id) {
        if (id != null) {
            Usuario usuario = usuarios.get(id);
            return usuario;
        }
        return null;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario != null && usuario.getId() != null) {
            usuarios.put(usuario.getId(), usuario);
            notifica();
        }
    }

    public ArrayList<Evento> getTotalEventos() {
        return totalEventos;
    }

    public void setTotalEventos(ArrayList<Evento> totalEventos) {
        this.totalEventos = totalEventos;
    }
}
