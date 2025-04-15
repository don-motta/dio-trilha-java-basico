package com.digitalbank.account;

import com.digitalbank.client.Client;

import java.util.Random;

public abstract class Conta implements ContaInterface{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    private String numeroConta;
    private int agencia;
    private double saldo = 0.0;
    private Client client;
    private String tipoConta;

    public Conta(Client client) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numeroConta = Integer.toString(SEQUENCIAL++) + "-" + new Random().nextInt(10);
        this.client = client;
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato da Conta ===");
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("=========================");
    }

    @Override
    public void consultarDadosdaConta() {
        System.out.println("\n=== Dados da Conta ===");
        System.out.println("Número da Conta: " + this.numeroConta);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Tipo de Conta: " + this.tipoConta);
        System.out.println("Nome do Cliente: "+ this.client.getName());
        System.out.println("CPF do Cliente: "+ this.client.getCpf());
        System.out.println("Data de Nascimento do Cliente: "+ this.client.getDataDeNasc());
        System.out.println("Email do Cliente: "+ this.client.getEmail());
        System.out.println("Telefone do Cliente: "+ this.client.getTelefone());
        System.out.println("=========================");
    }
}
