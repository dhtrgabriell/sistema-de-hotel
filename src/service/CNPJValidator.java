package service;

public class CNPJValidator {

    public boolean validarCNPJ(String cnpjToValidate) {
        String cnpj = cnpjToValidate.replaceAll("\\D", "");
        String cnpjInv = new StringBuilder(cnpj).reverse().toString();

        if (cnpj.length() != 14) {
            System.out.println("CNPJ Incompleto");
            return false;
        }

        if (cnpj.matches("(\\d)\\1{10}")) {
            System.out.println("CNPJ Invalido");
            return false;
        }

        // Para validar o primeiro dígito a forma mais simples é inverter o nosso 
        //número de CNPJ e adicionar pesos de 2 até 9:
        int soma = 0;
        int peso = 2;

        for (int i = 2; i < 14; i++) {
            int digito = Character.getNumericValue(cnpjInv.charAt(i));
            if (peso > 9) {
                peso = 2;
            }
            soma += digito * peso;
            peso++;
        }
        int resto = soma % 11;
        int primeiroDigito;
        if (resto < 2) {
            primeiroDigito = 0;
        } else {
            primeiroDigito = 11 - resto; // Caso contrário, 11 - resto
        }


        //Segundo digito
        soma = 0;
        peso = 2;
        for (int i = 1; i < 14; i++) {
            int digito;
            if (i < 14) {
                digito = Character.getNumericValue(cnpjInv.charAt(i));
            } else {
                digito = primeiroDigito;
            }
            if (peso > 9) {
                peso = 2;
            }
            soma += digito * peso;
            peso++;
        }
        int segundoDigito;
        resto = soma % 11;
        if (resto < 2) {
            segundoDigito = 0; // Se resto for 0 ou 1, o DV é 0
        } else {
            segundoDigito = 11 - resto; // Caso contrário, 11 - resto
        }

        int primeiroDigitoReal = Character.getNumericValue(cnpj.charAt(12));
        int segundoDigitoReal = Character.getNumericValue(cnpj.charAt(13));

        if (primeiroDigito == primeiroDigitoReal && segundoDigito == segundoDigitoReal) {
            System.out.println("CNPJ Validado: Verdadeiro");
            return true;
        } else {
            System.out.println("CNPJ Validado: Falso");
            return false;
        }

    }

}
