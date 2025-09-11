package models;

import java.security.Timestamp;

public class OrdemServico {
    
    private int id;
    private Timestamp dataHoraCadastro;
    private Timestamp dataHoraInicio;
    private Timestamp dataHoraTermino;
    private String obs;
    private char status;
    
    private Servico servico;
    private Quarto quarto;
    private Check check;

    public OrdemServico(int id, Timestamp dataHoraCadastro, Timestamp dataHoraInicio, Timestamp dataHoraTermino, String obs, char status, Servico servico, Quarto quarto, Check check) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraTermino = dataHoraTermino;
        this.obs = obs;
        this.status = status;
        this.servico = servico;
        this.quarto = quarto;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Timestamp getDataHoraTermino() {
        return dataHoraTermino;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public Servico getServico() {
        return servico;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Check getCheck() {
        return check;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHoraCadastro(Timestamp dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public void setDataHoraInicio(Timestamp dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public void setDataHoraTermino(Timestamp dataHoraTermino) {
        this.dataHoraTermino = dataHoraTermino;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
    
    
    
}
