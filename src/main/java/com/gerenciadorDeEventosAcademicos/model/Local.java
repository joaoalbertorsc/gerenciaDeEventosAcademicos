package com.gerenciadorDeEventosAcademicos.model;

public class Local {

    private String nome;
    private String bloco;
    private int capacidade;
    private String referencia;

    public Local(String nome, String bloco, int capacidade, String referencia) { // metodo contrutor do local (nao utilizado nessa versao);
        this.nome = nome;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "Nome: '" + nome + '\'' +
                ", Bloco: '" + bloco + '\'' +
                ", Capacidade: " + capacidade +
                ", Referencia: '" + referencia + '\'';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
