package model;

public class AlocacaoVaga {
    private int id;
    private String obs;
    private char status;
    private char sexo2;
    //murilo esteve aqui
    private Check check;
    private Veiculo veiculo;
    private VagaEstacionamento vagaEstacionamento;

    public AlocacaoVaga(int id, String obs, char status, Check check, Veiculo veiculo, VagaEstacionamento vagaEstacionamento) {
        this.id = id;
        this.obs = obs;
        this.status = status;
        this.check = check;
        this.veiculo = veiculo;
        this.vagaEstacionamento = vagaEstacionamento;
    }

    public int getId() {
        return id;
    }

    public String getObs() {
        return obs;
    }

    public char getStatus() {
        return status;
    }

    public Check getCheck() {
        return check;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public VagaEstacionamento getVagaEstacionamento() {
        return vagaEstacionamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setVagaEstacionamento(VagaEstacionamento vagaEstacionamento) {
        this.vagaEstacionamento = vagaEstacionamento;
    }

    @Override
    public String toString() {
        return "Alocacao Vaga" +
                "\nCheck: " + check +
                "\nVeiculo: " + veiculo +
                "\nVaga de Estacionamento: " + vagaEstacionamento +
                "\nObservação: " + obs +
                "\nStatus: " + status;
    }
    
}
