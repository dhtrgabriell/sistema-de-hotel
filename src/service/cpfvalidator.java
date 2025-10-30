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

        System.out.println("Executado");

        for (char N : arrayCPF) {
            if (Character.isDigit(N)) {
                listaDeNumeros.add(N); // Aqui cria uma lista de só de numeros

            }
        }
        // transforma em int
        for (Character c : listaDeNumeros) {
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
        System.out.println("Primeiro digito: " +primeiroDigito);

        return true;

    }// final metodo
}
