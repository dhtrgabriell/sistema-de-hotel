package model;

import model.Pessoa;

public class Hospede extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private String contato;
    private char status;
    private char sexo;

    public Hospede() {}

    public Hospede(int id, String nome, String fone, String fone2, String email, String cep, String logradouro,
            String bairro, String cidade, String complemento, String dataCadastro, String cpf, String rg, String obs,
            char status, char sexo, String razaoSocial, String cnpj, String inscricaoEstadual, String contato) {
        super(id, nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, dataCadastro, cpf, rg, obs,
                status);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.contato = contato;
        this.status = status;
        this.sexo = sexo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}