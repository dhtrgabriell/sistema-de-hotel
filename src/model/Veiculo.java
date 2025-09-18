package model;

import model.Hospede;

public class Veiculo {
    private int id;

    private String placa;
    private String cor;
    private char status;

    private Modelo modelo;

    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private Hospede hospede;

    public Veiculo() {}

    public Veiculo(int id, String placa, String cor, char status, Modelo modelo, Funcionario funcionario, Fornecedor fornecedor, Hospede hospede) {
        this.id = id;

        this.placa = placa;
        this.cor = cor;
        this.status = status;

        this.modelo = modelo;

        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.hospede = hospede;
    }

    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}