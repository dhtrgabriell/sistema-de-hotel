package models;

import java.security.Timestamp;

class Receber {
    private int id;
    
    private Check check;
    
    private Timestamp dataHoraCadastro;
    private float valorOriginal;
    private float desconto;
    private float acrescismo;
    private float valorPago;
    private String obs;
    private char status;

    public Receber(int id, Check check, Timestamp dataHoraCadastro, float valorOriginal, float desconto, float acrescismo, float valorPago, String obs, char status) {
        this.id = id;
        this.check = check;
        this.dataHoraCadastro = dataHoraCadastro;
        this.valorOriginal = valorOriginal;
        this.desconto = desconto;
        this.acrescismo = acrescismo;
        this.valorPago = valorPago;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Check getCheck() {
        return check;
    }

    public Timestamp getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public float getValorOriginal() {
        return valorOriginal;
    }

    public float getDesconto() {
        return desconto;
    }

    public float getAcrescismo() {
        return acrescismo;
    }

    public float getValorPago() {
        return valorPago;
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

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setDataHoraCadastro(Timestamp dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public void setValorOriginal(float valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public void setAcrescismo(float acrescismo) {
        this.acrescismo = acrescismo;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Receber" +
                "\nCheck: " + check +
                "\nData/Hora - Cadastro: " + dataHoraCadastro +
                "\nValor Original: " + valorOriginal +
                "\nDesconto: " + desconto +
                "\nAcrescismo: " + acrescismo +
                "\nValor Pago: " + valorPago +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
}
