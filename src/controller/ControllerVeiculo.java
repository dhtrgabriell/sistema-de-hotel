package controller;

import java.util.ArrayList;
import model.Veiculo;

public class ControllerVeiculo {
        public static int codigo;

    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public ArrayList<Veiculo> listarVeiculos() {
        return veiculos;
    }
}