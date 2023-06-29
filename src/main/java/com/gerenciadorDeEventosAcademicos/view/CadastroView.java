package com.gerenciadorDeEventosAcademicos.view;

import com.gerenciadorDeEventosAcademicos.controller.CadastroController;
import com.gerenciadorDeEventosAcademicos.controller.LoginController;
import com.gerenciadorDeEventosAcademicos.model.Model;
import com.gerenciadorDeEventosAcademicos.model.Participante;
import com.gerenciadorDeEventosAcademicos.model.Usuario;

import java.util.Scanner;

public class CadastroView implements Observer{

    private Model model;
    private CadastroController controller;
    private Usuario usuario;
    private int tipoUsuario;
    private String nome;
    private String id;
    private String senha;

    public void initNewUserView(Model model) {
        this.model = model;
        controller = new CadastroController();
        controller.initCadastroController(model, this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("CADASTRAR USUARIO");
        System.out.println("======================");
        System.out.println();
        System.out.println("TIPO DE CONTA: " +
                "\n[1] Participante;" +
                "\n[2] Palestrante;" +
                "\n[3] Organizador;");
        System.out.print("Digite a conta desejada: ");
        tipoUsuario = sc.nextInt();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Login: ");
        id = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public CadastroController getController() {
        return controller;
    }

    public void setController(CadastroController controller) {
        this.controller = controller;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String login) {
        this.id = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void update() {

    }
}
