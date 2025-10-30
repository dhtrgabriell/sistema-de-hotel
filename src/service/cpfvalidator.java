package service;

import java.util.ArrayList;
import java.util.List;

public class cpfvalidator {

    private String CPFParaValidacao;


    public cpfvalidator(){
    };


    public cpfvalidator(String CPFParaValidacao){
        CPFParaValidacao = this.CPFParaValidacao;
    }


    public boolean verificarCPF(String CPFParaValidacao){

        char[] arrayCPF = CPFParaValidacao.toCharArray();
        List<Character> listaDeNumeros = new ArrayList<>();

        for (char N : arrayCPF) {
            if (Character.isLetter(N)){
                System.out.println(N + " é letra");
            }

        }







        return true;
    }




}
