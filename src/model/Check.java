package model;

import java.security.Timestamp;

class Check {
    
    private int id;
    private Timestamp dataHoraCadastro;
    private Timestamp dataHoraEntrada;
    private Timestamp dataHoraSaida;
    private String obs;
    private char status;
    
    private Reserva reserva;

    public Check(int id, Timestamp dataHoraCadastro, Timestamp dataHoraEntrada, Timestamp dataHoraSaida, String obs, char status, Reserva reserva) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.obs = obs;
        this.status = status;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public Timestamp getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public Timestamp getDataHoraSaida() {
        return dataHoraSaida;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHoraCadastro(Timestamp dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public void setDataHoraEntrada(Timestamp dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public void setDataHoraSaida(Timestamp dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Check" +
                "\nReserva: " + reserva +
                "\nData/Hora de Cadastro: " + dataHoraCadastro +
                "\nData/Hora de Entrada: " + dataHoraEntrada +
                "\nData/Hora de Saida: " + dataHoraSaida +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
    
}
