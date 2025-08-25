package model;

public class CheckHospede {
    private int id;
    
    private Check check;
    private Hospede hospete;
    
    private String tipoHospede;
    private String obs;
    private char status;

    public CheckHospede(int id, Check check, Hospede hospete, String tipoHospede, String obs, char status) {
        this.id = id;
        this.check = check;
        this.hospete = hospete;
        this.tipoHospede = tipoHospede;
        this.obs = obs;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Check getCheck() {
        return check;
    }

    public Hospede getHospete() {
        return hospete;
    }

    public String getTipoHospede() {
        return tipoHospede;
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

    public void setHospete(Hospede hospete) {
        this.hospete = hospete;
    }

    public void setTipoHospede(String tipoHospede) {
        this.tipoHospede = tipoHospede;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Check - Hospede" +
                "\nCheck: " + check +
                "\nHospete: " + hospete +
                "\nTipo de Hospede: " + tipoHospede +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
}
