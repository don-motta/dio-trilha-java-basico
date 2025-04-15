package com.digitalbank.database;

import java.util.ArrayList;
import java.util.List;

import com.digitalbank.account.Conta;
import com.digitalbank.client.Client;

public class DataBank {
    private static List<Client> clientList;

    public DataBank () {
        this.clientList = new ArrayList<>();
    }

    public List<Conta> accountList() {
        List<Conta> accountList = new ArrayList<>();
        for (Client c : clientList) {
            if (c.getContas() != null) {
                for (Conta conta : c.getContas()) {
                    accountList.add(conta);
                }
            }
        }
        return accountList;
    }

    public void addClientToList(Client client){
        this.clientList.add(client);
    }

    public List<Client> getClientList () {
        return this.clientList;
    }

    public void alterarCadastroCliente(Client client, String opcaoDeAlteracao, String dado) {
        for (Client c : clientList) {
            if (c == client) {
                switch (opcaoDeAlteracao) {
                    case "email" -> c.setEmail(dado);
                    case "telefone" -> c.setTelefone(dado);
                    case "password" -> c.setPassword(dado);
                }
            }
        }
    }
    public void movimentarConta(Client client, Conta contaUsuario, String tipoMovimentacao, double valor, Conta contaDestino) {
        for(Client c : clientList) {
            if (c == client) {
                for (Conta conta : c.getContas()) {
                    if (conta == contaUsuario) {
                        switch (tipoMovimentacao) {
                            case "depositar" -> conta.depositar(valor);
                            case "sacar" -> conta.sacar(valor);
                            case "transferir" -> conta.transferir(valor, contaDestino);
                        }
                    }
                }
            }
        }
    }
}
