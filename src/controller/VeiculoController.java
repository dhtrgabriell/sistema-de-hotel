package controller;

import models.Veiculo;
import java.util.ArrayList;

public class VeiculoController {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return veiculos;
    }
}