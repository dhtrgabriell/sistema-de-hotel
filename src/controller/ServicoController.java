package controller;

import models.Servico;
import java.util.ArrayList;

public class ServicoController {
    private ArrayList<Servico> servicos = new ArrayList<>();

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public ArrayList<Servico> listarServicos() {
        return servicos;
    }
}