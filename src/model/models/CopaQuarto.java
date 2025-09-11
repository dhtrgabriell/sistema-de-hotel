package models;

import java.security.Timestamp;

public class CopaQuarto {
    
    private int id;
    private float quantidade;
    private Timestamp dataHoraPedido;
    private String obs;
    private char status;
    
    private ProdutoCopa produto;

    public CopaQuarto(int id, float quantidade, Timestamp dataHoraPedido, String obs, char status, ProdutoCopa produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataHoraPedido = dataHoraPedido;
        this.obs = obs;
        this.status = status;
        
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public Timestamp getDataHoraPedido() {
        return dataHoraPedido;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public ProdutoCopa getProduto() {
        return produto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQunatidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataHoraPedido(Timestamp dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setProdutos(ProdutoCopa produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Copa Quarto " +
               "\nProduto: " + produto +
               "\nQuantidade: " + quantidade +
               "\nData e Hora: " + dataHoraPedido +
               "\nObservação: " + obs +
               "\nStatus: " + status;
    }

    
    
}
