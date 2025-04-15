package com.digitalbank.verifications;

public class VerifCPF {
    private String cpf;

    public boolean isCPF(String cpf) {
        this.cpf = cpf;
        int sm = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(this.cpf.charAt(i));
            sm += digito * peso;
            peso --;
        }
        int primeiroDigitoVerificador = 11 - (sm % 11);
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        //Verifica o primeiro digito
        if (Character.getNumericValue(this.cpf.charAt(9)) != primeiroDigitoVerificador) {
            return false;
        } else {
            //calcula o segundo digito verificador
            sm = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                int digito = Character.getNumericValue(this.cpf.charAt(i));
                sm += digito * peso;
                peso--;
            }
            int segundoDigitoVerificador = 11-(sm % 11);
            if (segundoDigitoVerificador >= 10) {
                segundoDigitoVerificador = 0;
            }

            //Verifica segundo digito verificador
            return Character.getNumericValue(this.cpf.charAt(10)) == segundoDigitoVerificador;
        }
    }
}
