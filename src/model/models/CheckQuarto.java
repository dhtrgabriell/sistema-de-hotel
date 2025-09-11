package models;

import java.security.Timestamp;

class CheckQuarto {
    
    private int id;
    private Timestamp dataHoraInicio;
    private Timestamp dataHoraFim;
    private String obs;
    private char status;
    
    private Quarto quarto;
    private Check check;
    private ReservaQuarto reservaQuarto;

    public CheckQuarto(int id, Timestamp dataHoraInicio, Timestamp dataHoraFim, String obs, char status, Quarto quarto, Check check, ReservaQuarto reservaQuarto) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.obs = obs;
        this.status = status;
        this.quarto = quarto;
        this.check = check;
        this.reservaQuarto = reservaQuarto;
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

    public Check getCheck() {
        return check;
    }

    public ReservaQuarto getReservaQuarto() {
        return reservaQuarto;
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

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setReservaQuarto(ReservaQuarto reservaQuarto) {
        this.reservaQuarto = reservaQuarto;
    }

    @Override
    public String toString() {
        return "CheckQuarto: " +
                "\nQuarto: " + quarto +
                "\nCheck: " + check +
                "\nReserva de Quarto: " + reservaQuarto + 
                "\nData/Hora Inicio: " + dataHoraInicio +
                "\nData/Hora Fim: " + dataHoraFim +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
    
}
