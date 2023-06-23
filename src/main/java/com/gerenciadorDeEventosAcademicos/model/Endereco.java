package main.java.com.gerenciadorDeEventosAcademicos.model;

public class Endereco {

    private String rua;
    private String numero;
    private String cidade;
    private String referencia;

    public String toString(){

        return "Rua: " + rua +
                "\nNumero: " + numero +
                "\nCidade: " + cidade +
                "\nReferncia: " + referencia;

    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
