package controller;

import model.Servico;
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