package controller;

import java.util.ArrayList;
import model.VagaEstacionamento;

public class ControllerVagaEstacionamento {
    private ArrayList<VagaEstacionamento> vagas = new ArrayList<>();

    public void adicionarVaga(VagaEstacionamento vaga) {
        vagas.add(vaga);
    }

    public ArrayList<VagaEstacionamento> listarVagas() {
        return vagas;
    }
}