package com.digitalbank.account;

import com.digitalbank.client.Client;

public class ContaCorrente extends Conta {
    public ContaCorrente(Client client) {
        super(client);
        this.setTipoConta("Conta Corrente");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato da Conta Corrente ===");
        super.imprimirExtrato();
    }

    @Override
    public void consultarDadosdaConta() {
        System.out.println("=== Dados da Conta Corrente ===");
        super.consultarDadosdaConta();
    }
}
