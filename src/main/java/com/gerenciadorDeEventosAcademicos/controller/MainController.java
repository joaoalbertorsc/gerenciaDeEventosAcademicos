package com.gerenciadorDeEventosAcademicos.controller;

import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.view.*;

import java.util.NoSuchElementException;

public class MainController implements Observer {
    private Model model;	// Guarda o modelo a ser utilizado
    private MainView view;	// Guarda a view a ser controlada
    public void initMainViewController(Model model, MainView view) {
        this.model = model;  // Guarda o modelo
        this.view = view;	 // Guarda a view
    }
    public void update() {
    }
    public void handleEvent(String event) throws NoSuchElementException { // metodo para decidir para onde o usuario vai de acordo com a entrada apos a main view;
        switch (event) {
            case "1" :
                if (model.getUsuario() == null) {
                LoginView loginView = new LoginView();
                loginView.initLoginView(model);
            } else {
                model.deslogarUsuario();
                model.voltarPaginaInicial();
            }
                break;
            case "2" :
                if (model.getUsuario() != null){
                    PaginaEventosView view1 = new PaginaEventosView();
                    view1.initPaginaEventosView(model);
                }
                CadastroView view2 = new CadastroView();
                view2.initNewUserView(model);
                break;
            case "3" :
                view.finalizarSistema();
                break;
        }
    }
}
