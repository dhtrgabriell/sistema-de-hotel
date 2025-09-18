package model;

public class VagaEstacionamento {
    private int id;

    private String descricao;
    private String obs;
    private char status;
    private float metragemVaga;

    public VagaEstacionamento() {}

    public VagaEstacionamento(int id, String descricao, String obs, char status, float metragemVaga) {
        this.id = id;
        this.descricao = descricao;
        this.obs = obs;
        this.status = status;
        this.metragemVaga = metragemVaga;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getMetragemVaga() {
        return metragemVaga;
    }

    public void setMetragemVaga(float metragemVaga) {
        this.metragemVaga = metragemVaga;
    }
    
}