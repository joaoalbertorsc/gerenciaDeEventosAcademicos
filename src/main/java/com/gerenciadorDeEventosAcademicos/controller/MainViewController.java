package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.CadastroView;
import com.gerenciadorDeEventosAcademicos.view.LoginView;
import com.gerenciadorDeEventosAcademicos.view.MainView;
import com.gerenciadorDeEventosAcademicos.view.Observer;

public class MainViewController implements Observer {

    private Model model;	// Guarda o modelo a ser utilizado
    private MainView view;	// Guarda a view a ser controlada

    /*
     * Inicialização do controller da view principal
     */
    public void initMainViewController(Model model, MainView view) {
        this.model = model;  // Guarda o modelo
        this.view = view;	 // Guarda a view
    }

    /*
     * O controller só implementa o update se for necessário
     */
    public void update() {

    }
    public void handleEvent(String event) {
        switch (event) {
            case "1" : if (model.getUsuarioAutenticado() == null) {
                LoginView loginView = new LoginView();
                loginView.initLoginView(model);
            } else {
                model.deslogarUsuario();
                model.voltarPaginaInicial();
            }
                break;
            case "2" : CadastroView view2 = new CadastroView();
                view2.initNewUserView(model);
                break;
            case "3" : view.finalizarSistema(); break;
        }
    }
}
