package main.java.com.gerenciadorDeEventosAcademicos.model;

public class Certificado {
    private String atividade;
    private String participante;
    private boolean emitido;

    public Certificado(String atividade, String participante) {
        this.atividade = atividade;
        this.participante = participante;
        this.emitido = false;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public boolean isEmitido() {
        return emitido;
    }

    public void emitirCertificado() {
        this.emitido = true;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "atividade='" + atividade + '\'' +
                ", participante='" + participante + '\'' +
                ", emitido=" + emitido +
                '}';
    }
}

