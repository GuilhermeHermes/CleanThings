package com.guilhermehermes.cleanthings.domain.valueobjects;

public class Cpf {

    private String cpf;

    public Cpf(String cpf) {
        if(!isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
    }

    public static boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (caso inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcular o primeiro dígito verificador
            int digito1 = calcularDigitoVerificador(cpf, 10);
            // Calcular o segundo dígito verificador
            int digito2 = calcularDigitoVerificador(cpf, 11);

            // Verifica se os dígitos calculados são iguais aos do CPF fornecido
            return (digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                    digito2 == Character.getNumericValue(cpf.charAt(10)));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int calcularDigitoVerificador(String cpf, int pesoInicial) {
        int soma = 0;

        for (int i = 0; i < pesoInicial - 1; i++) {
            int num = Character.getNumericValue(cpf.charAt(i));
            soma += num * (pesoInicial - i);
        }

        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
