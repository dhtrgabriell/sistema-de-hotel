package models;

import java.security.Timestamp;

public class Caixa {
    private int id;
    
    private Fornecedor fornecedor;
    
    private float valorDeAbertura;
    private float valorDeFechamento;
    private Timestamp dataHoraAbertura;
    private Timestamp dataHoraFechamento;
    private String obs;
    private char status;

    public Caixa(int id, Fornecedor fornecedor, float valorDeAbertura, float valorDeFechamento, Timestamp dataHoraAbertura, Timestamp dataHoraFechamento, String obs, char status) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.valorDeAbertura = valorDeAbertura;
        this.valorDeFechamento = valorDeFechamento;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public float getValorDeAbertura() {
        return valorDeAbertura;
    }

    public float getValorDeFechamento() {
        return valorDeFechamento;
    }

    public Timestamp getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public Timestamp getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setValorDeAbertura(float valorDeAbertura) {
        this.valorDeAbertura = valorDeAbertura;
    }

    public void setValorDeFechamento(float valorDeFechamento) {
        this.valorDeFechamento = valorDeFechamento;
    }

    public void setDataHoraAbertura(Timestamp dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public void setDataHoraFechamento(Timestamp dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Caixa" +
                "\nFornecedor: " + fornecedor +
                "\nValor de Abertura: " + valorDeAbertura +
                "\nValor de Fechamento: " + valorDeFechamento +
                "\nData/Hora Abertura: " + dataHoraAbertura +
                "\nData/Hora Fechamento: " + dataHoraFechamento +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
    
}
