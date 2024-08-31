package com.gerenciadorDeEventosAcademicos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Certificado {
    private Atividade atividade;
    public Certificado(Atividade atividade) {
        this.atividade = atividade;
    }
    public void emitirCertificado (Participante participante) { // metodo para emissao dos certificados dos participantes (nao ativo nessa versao);
        String conteudo = "Certificamos que " + participante.getNome() + " participou da atividade " + atividade.getNome() + " realizada em " + atividade.getDataInicio() + ".";
        String nomeArquivo = participante.getNome() + "-" + atividade.getNome() + ".txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo));
            writer.println(conteudo);
            writer.close();
            System.out.println("Certificado para " + participante.getNome() + " salvo com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o certificado de " + participante.getNome() + " no arquivo " + nomeArquivo);
            e.printStackTrace();
        }
    }
    public Atividade getAtividade() {
        return atividade;
    }
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
}

