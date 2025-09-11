package controller;

import models.VagaEstacionamento;
import java.util.ArrayList;

public class VagaEstacionamentoController {
    private ArrayList<VagaEstacionamento> vagas = new ArrayList<>();

    public void adicionarVaga(VagaEstacionamento vaga) {
        vagas.add(vaga);
    }

    public ArrayList<VagaEstacionamento> listarVagas() {
        return vagas;
    }
}