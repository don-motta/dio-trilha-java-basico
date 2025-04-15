package com.digitalbank.client;

import com.digitalbank.account.Conta;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private int dataDeNasc;
    private String cpf;
    private String email;
    private String telefone;
    private String password;
    private List<Conta> contas;

    public Client (String name, int idade, String cpf, String email, String telefone, String password) {
        this.name = name;
        this.dataDeNasc = idade;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.password = password;
        this.contas = new ArrayList<>();
    }

    //getters
    public String getName() {
        return name;
    }

    public int getDataDeNasc() {
        return dataDeNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getPassword() {
        return password;
    }

    public List<Conta> getContas() {
        return contas;
    }

    //setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void showClientData() {
        System.out.println("\n=== Dados do Cliente ===");
        System.out.println("Nome: " + name);
        System.out.println("Data de Nascimento: " + dataDeNasc);
        System.out.println("CPF: " + cpf);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }

    public void showContas() {
        for (Conta conta : contas) {
            System.out.println("\n=== Contas do Usuário ===");
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Tipo de Conta: " + conta.getTipoConta());
        }
    }
}
