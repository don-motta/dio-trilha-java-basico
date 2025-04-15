package com.digitalbank.account;

import com.digitalbank.client.Client;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Client client) {
        super(client);
        this.setTipoConta("Conta Poupança");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta Poupança ===");
        super.imprimirExtrato();
    }

    @Override
    public void consultarDadosdaConta() {
        System.out.println("=== Dados da Conta Poupança ===");
        super.consultarDadosdaConta();
    }
}
