package service;

import java.util.ArrayList;
import java.util.List;

public class cpfvalidator {

    private String CPFParaValidacao;

    public cpfvalidator() {
    };

    public cpfvalidator(String CPFParaValidacao) {
        CPFParaValidacao = this.CPFParaValidacao;
    }

    public boolean verificarCPF(String CPFParaValidacao) {

        char[] arrayCPF = CPFParaValidacao.toCharArray();
        List<Character> listaDeNumeros = new ArrayList<>();
        List<Integer> listaDeInteiros = new ArrayList<>();
        List<Integer> listaPrimeiroDigito = new ArrayList<>();
        List<Integer> listaSegundoDigito = new ArrayList<>();

        for (char N : arrayCPF) {
            if (Character.isDigit(N)) {
                listaDeNumeros.add(N); // Aqui cria uma lista de só de numeros
            }
        }
        for (Character c : listaDeNumeros) { // Aqui transforma o char pra int
            int numero = Character.getNumericValue(c);
            listaDeInteiros.add(numero);
        }

        int minus = 10;
        int soma = 0;
        for (int i = 0; i != 9; i++) {
            int calc = listaDeInteiros.get(i);
            listaPrimeiroDigito.add(calc * minus);
            minus--;
            soma += (listaPrimeiroDigito.get(i));

        }
        int primeiroDigito = soma % 11;
        primeiroDigito = 11 - primeiroDigito;
        if (primeiroDigito >= 10 && primeiroDigito != 0) {
            System.out.println("valido?"); // Verifica se é 10 ou mais, se for = 0
            primeiroDigito = 0;
        }

        System.out.println("Primeiro digito: " + primeiroDigito);

        //////////////////////// SEGUNDO DIGITO //////////////////
        minus = 11;
        soma = 0;
        listaDeInteiros.add(primeiroDigito);
        for (int i = 0; i != 10; i++) {
            int calc = listaDeInteiros.get(i);
            listaSegundoDigito.add(calc * minus);
            minus--;
            soma += (listaSegundoDigito.get(i));
        }
        int segundoDigito = soma % 11;
        segundoDigito = 11 - segundoDigito;
        if (segundoDigito >= 10 && segundoDigito != 0) {
            System.out.println("valido?"); // Verifica se é 10 ou mais, se for = 0
            segundoDigito = 0;
        }

        System.out.println(primeiroDigito + "" + segundoDigito);

        if (listaDeInteiros.get(9) == primeiroDigito && listaDeInteiros.get(10) == segundoDigito) {
            System.out.println("CPF VALIDO");
            return true;
        } else {
            System.out.println("CPF INVALIDO");
            return false;
        }
    }
}
