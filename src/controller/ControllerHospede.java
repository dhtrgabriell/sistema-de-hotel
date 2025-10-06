package controller;

import java.util.ArrayList;
import model.Hospede;

public class ControllerHospede {
    private ArrayList<Hospede> hospedes = new ArrayList<>();

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public ArrayList<Hospede> listarHospedes() {
        return hospedes;
    }
}