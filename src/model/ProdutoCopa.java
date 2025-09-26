package model;

public class ProdutoCopa {
    private int id;
    private String descricao;
    private double preco;
    private String obs;
    private char status;

    public ProdutoCopa() {}

    public ProdutoCopa(int id, String descricao, double preco, String obs, char status) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObs() {
        return obs;
    }
    
    public void setObs(String obs) {
        this.obs = obs;
    }

    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
}