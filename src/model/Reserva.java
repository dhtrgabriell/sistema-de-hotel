package model;

import java.security.Timestamp;
import java.util.Date;

class Reserva {
    
    private int id;
    private Timestamp dataHoraReserva;
    private Date dataPrevistaEntrada;
    private Date dataPrevistaSaida;
    private String obs;
    private char status;

    public Reserva(int id, Timestamp dataHoraReserva, Date dataPrevistaEntrada, Date dataPrevistaSaida, String obs, char status) {
        this.id = id;
        this.dataHoraReserva = dataHoraReserva;
        this.dataPrevistaEntrada = dataPrevistaEntrada;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDataHoraReserva() {
        return dataHoraReserva;
    }

    public Date getDataPrevistaEntrada() {
        return dataPrevistaEntrada;
    }

    public Date getDataPrevistaSaida() {
        return dataPrevistaSaida;
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

    public void setDataHoraReserva(Timestamp dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public void setDataPrevistaEntrada(Date dataPrevistaEntrada) {
        this.dataPrevistaEntrada = dataPrevistaEntrada;
    }

    public void setDataPrevistaSaida(Date dataPrevistaSaida) {
        this.dataPrevistaSaida = dataPrevistaSaida;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva" +
                "\nData/Hora: " + dataHoraReserva +
                "\nData Prevista de Entrada: " + dataPrevistaEntrada +
                "\nData Prevista de Saida: " + dataPrevistaSaida +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
    
}
