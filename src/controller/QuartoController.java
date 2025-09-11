package controller;

import models.Quarto;
import java.util.ArrayList;

public class QuartoController {
    private ArrayList<Quarto> quartos = new ArrayList<>();

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public ArrayList<Quarto> listarQuartos() {
        return quartos;
    }
}