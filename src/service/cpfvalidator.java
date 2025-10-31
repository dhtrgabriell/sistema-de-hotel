package service;

import javax.swing.JOptionPane;

public class CPFValidator {

    public CPFValidator() {
    }

    public boolean validarCPF(String cpfToValidate) {

        String CPF = cpfToValidate.replaceAll("\\D", "");

        if (CPF.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF Com tamanho inválido.");
            return false;
        }

        if (CPF.matches("(\\d)\\1{10}")) {
            JOptionPane.showMessageDialog(null, "O CPF Informado é Inválido.");
            return false;
        }

        //LOGICA PARA CALCULA 1 
        int soma = 0;
        int peso = 10;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(CPF.charAt(i));
            soma += digito * peso;
            peso--;
        }
        int primeiroDigito;
        int resto = soma % 11;
        if (resto < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - resto; // Caso contrário, 11 - resto
        }

        //SEGUNDO DIGITO
        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            int digito;
            if (i < 9) {
                digito = Character.getNumericValue(CPF.charAt(i));
            } else {
                // Adiciona o primeiro DV calculado no final da sequência para o cálculo do segundo DV
                digito = primeiroDigito;
            }
            soma += digito * peso;
            peso--;
        }
        int segundoDigito;
        resto = soma % 11;
        if (resto < 2) {
            segundoDigito = 0; // Se resto for 0 ou 1, o DV é 0
        } else {
            segundoDigito = 11 - resto; // Caso contrário, 11 - resto
        }

        int primeiroDigitoReal = Character.getNumericValue(CPF.charAt(9));
        int segundoDigitoReal = Character.getNumericValue(CPF.charAt(10));

        if (primeiroDigitoReal == primeiroDigito && segundoDigitoReal == segundoDigito) {
            System.out.println("CPF VÁLIDO");
            return true;
        } else {
            System.out.println("CPF INVÁLIDO");
            JOptionPane.showMessageDialog(null, "O CPF Informado é Inválido.");
            return false;
        }
    }
}






/* 
CODIGO ANTIGO:


package service;

import java.util.ArrayList;
import java.util.List;

public class cpfvalidator {

    private String CPFParaValidacao;

    public cpfvalidator() {
    }

    ;

    public cpfvalidator(String CPFParaValidacao) {
        this.CPFParaValidacao = CPFParaValidacao;
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
]
*/