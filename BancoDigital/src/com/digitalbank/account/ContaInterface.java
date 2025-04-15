package com.digitalbank.account;

public interface ContaInterface {
    void depositar(double valor);
    void sacar(double valor);
    void transferir(double valor, Conta contaDestino);
    void imprimirExtrato();
    void consultarDadosdaConta();
}
