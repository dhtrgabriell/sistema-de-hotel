package models;

import java.security.Timestamp;

class ReservaQuarto {
    
    private int id;
    private Timestamp dataHoraInicio;
    private Timestamp dataHoraFim;
    private String obs;
    private char status;
    
    private Quarto quarto;
    private Reserva reserva;

    public ReservaQuarto(int id, Timestamp dataHoraInicio, Timestamp dataHoraFim, String obs, char status, Quarto quarto, Reserva reserva) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.obs = obs;
        this.status = status;
        this.quarto = quarto;
        this.reserva = reserva;
    }

    public int getId() {
        return id;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataHoraInicio(Timestamp dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public void setDataHoraFim(Timestamp dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}
