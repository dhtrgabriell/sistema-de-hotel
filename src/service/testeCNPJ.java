package service;

public class testeCNPJ {

    public static void main(String[] args) {
        CNPJValidator v = new CNPJValidator();

        //String cnpj = "59.541.264/0001-03";
                String cnpj = "27.864.629/0001-36";

        //v.validarCNPJ(cnpj);

        if (v.validarCNPJ(cnpj)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
