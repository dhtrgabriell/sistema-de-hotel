package models;

public class Hospede extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private String contato;
    private char status;

    public Hospede() {}

    public Hospede(int id, String nome, String fone, String fone2, String email, String cep, String logradouro,
            String bairro, String cidade, String complemento, String dataCadastro, String cpf, String rg, String obs,
            char status, String razaoSocial, String cnpj, String inscricaoEstadual, String contato, char status2) {
        super(id, nome, fone, fone2, email, cep, logradouro, bairro, cidade, complemento, dataCadastro, cpf, rg, obs,
                status);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.contato = contato;
        status = status2;
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

}