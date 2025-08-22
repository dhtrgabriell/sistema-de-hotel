package controller;

import model.Hospede;
import java.util.ArrayList;

public class HospedeController {
    private ArrayList<Hospede> hospedes = new ArrayList<>();

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public ArrayList<Hospede> listarHospedes() {
        return hospedes;
    }
}