package com.gerenciadorDeEventosAcademicos.view;

import com.gerenciadorDeEventosAcademicos.controller.CadastroController;
import com.gerenciadorDeEventosAcademicos.model.Model;
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
    private String email;

    public void initNewUserView(Model model) {
        this.model = model;
        controller = new CadastroController();
        controller.initCadastroController(model, this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("|   CADASTRAR USUARIO   |");
        System.out.println("=========================");
        System.out.println("Qual tipo de conta deseja criar? " +
                "\n[1] Participante;" +
                "\n[2] Palestrante;" +
                "\n[3] Organizador;");
        System.out.println("Digite o numero correspondente: ");
        tipoUsuario = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Insira os dados para a realizacao do cadastro: ");
        System.out.println("Digite seu nome: ");
        nome = scanner.nextLine();
        System.out.println("Defina seu email: ");
        email = scanner.nextLine();
        System.out.println("Defina seu ID: ");
        id = scanner.nextLine();
        System.out.println("Defina sua senha: ");
        senha = scanner.nextLine();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update() {

    }
}
