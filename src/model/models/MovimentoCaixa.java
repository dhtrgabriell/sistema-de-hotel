package models;

import java.security.Timestamp;

public class MovimentoCaixa {
    private int id;
    
    private Caixa caixa;
    private Receber receber;
    
    private Timestamp dataHoraMovimento;
    private float valor;
    private String decricao;
    private String obs;
    private char status;

    public MovimentoCaixa(int id, Caixa caixa, Receber receber, Timestamp dataHoraMovimento, float valor, String decricao, String obs, char status) {
        this.id = id;
        this.caixa = caixa;
        this.receber = receber;
        this.dataHoraMovimento = dataHoraMovimento;
        this.valor = valor;
        this.decricao = decricao;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public Receber getReceber() {
        return receber;
    }

    public Timestamp getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public float getValor() {
        return valor;
    }

    public String getDecricao() {
        return decricao;
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

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setReceber(Receber receber) {
        this.receber = receber;
    }

    public void setDataHoraMovimento(Timestamp dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
