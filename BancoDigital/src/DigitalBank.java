import com.digitalbank.account.Conta;
import com.digitalbank.account.ContaCorrente;
import com.digitalbank.account.ContaPoupanca;
import com.digitalbank.client.Client;
import com.digitalbank.database.DataBank;

import java.util.Scanner;

public class DigitalBank {
    private static Scanner sc = new Scanner(System.in);
    private static int input = 0;
    private static DataBank dataBank = new DataBank();

    public static void main (String[] args) {
        System.out.println("=== Bem-vindo ao Digital Bank! ===");
        menuDeEntrada();
    }

    public static void menuDeEntrada() {
        System.out.println("""
                \nEscolha uma opção:
                1. Criar uma conta
                2. Acessar conta existente
                3. Encerra o sistema""");
        input = sc.nextInt();
        switch (input) {
            case 1 -> menuDeCadastro();
            case 2 -> login();
            case 3 -> {
                System.out.println("Encerrando o sistema...");
                sc.close();
                exit();
            }
            default -> {
                invaidOption();
                menuDeEntrada();
            }
        }
    }

    public static void menuDeCadastro() {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.println("""
                Escolha uma opção:
                1. Criar conta corrente
                2. Criar conta poupança
                3. Voltar""");
        input = sc.nextInt();
        switch (input) {
            case 1 -> cadastro("corrente");
            case 2 -> cadastro("poupanca");
            case 3 -> menuDeEntrada();
            default -> {
                invaidOption();
                menuDeCadastro();
            }
        }
    }

    public static void login() {
        System.out.println("=== Acesso a Conta ===");
        System.out.println("Digite seu CPF: ");
        String cpf = sc.next();
        System.out.println("Digite sua senha: ");
        String password = sc.next();
        for (Client client : dataBank.getClientList()) {
            if (client.getCpf().equals(cpf) && client.getPassword().equals(password)) {
                System.out.println("\n=== Acesso autorizado! ===");
                client.showClientData();
                client.showContas();
                menuDeAcesso(client);
            } else {
                System.out.println("\n=== Acesso negado! ===");
                System.out.println("CPF ou senha incorretos.");
                menuDeEntrada();
            }
        }
    }

    public static void menuDeAcesso(Client loggedClient) {
        System.out.println("\n=== Acesso a Conta ===");
        System.out.println("""
                Escolha uma opção:
                1. Acessar conta corrente
                2. Acessar conta poupança
                3. Consultar cadastro
                4. Alterar dados
                5. Sair""");
        input = sc.nextInt();
        switch (input) {
            case 1 -> {
                for (Conta conta : loggedClient.getContas()) {
                    if (conta instanceof ContaCorrente) {
                        conta.imprimirExtrato();
                        menuDaConta(loggedClient, conta);
                    }
                }
            }
            case 2 -> {
                for (Conta conta : loggedClient.getContas()) {
                    if (conta instanceof ContaPoupanca) {
                        conta.imprimirExtrato();
                        menuDaConta(loggedClient, conta);
                    }
                }
            }
            case 3 -> loggedClient.showClientData();
            case 4 -> alterarDados(loggedClient);
            case 5 -> {
                System.out.println("\n=== Saindo do sistema... ===");
                menuDeEntrada();
            }
            default -> {
                invaidOption();
                menuDeAcesso(loggedClient);
            }
        }
    }

    public static void menuDaConta (Client loggedClient, Conta conta) {
        for (Client client : dataBank.getClientList()) {
            if (client == loggedClient) {
                System.out.println("\n=== Menu da Conta ===");
                System.out.println("Seu saldo atual é de: " + conta.getSaldo());
                System.out.println("""
                        Escolha uma opção:
                        1. Depositar
                        2. Sacar
                        3. Transferir
                        5. Voltar""");
                input = sc.nextInt();
                switch (input) {
                    case 1 -> {
                        System.out.println("Digite o valor a ser depositado: ");
                        double valor = sc.nextDouble();
                        dataBank.movimentarConta(loggedClient, conta, "depositar", valor, null);
                    }
                    case 2 -> {
                        System.out.println("Digite o valor a ser sacado: ");
                        double valor = sc.nextDouble();
                        dataBank.movimentarConta(loggedClient, conta, "sacar", valor, null);
                    }
                    case 3 -> {
                        System.out.println("Digite o valor a ser transferido: ");
                        double valor = sc.nextDouble();
                        System.out.println("Digite o número da conta de destino: ");
                        String numeroContaDestino = sc.next();
                        for (Conta contaDestino : dataBank.accountList()) {
                            if (contaDestino.getNumeroConta().equals(numeroContaDestino)) {
                                dataBank.movimentarConta(loggedClient, conta, "transferir", valor, contaDestino);
                            } else {
                                System.out.println("=== Conta de destino não encontrada! ===");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("=== Saindo do menu da conta... ===");
                        menuDeAcesso(loggedClient);
                    }
                    default -> {
                        invaidOption();
                        menuDaConta(loggedClient, conta);
                    }
                }
            }
        }

    }

    public static void cadastro(String tipoDeConta) {
        System.out.println("\n=== Cadastro de Cliente ===");
        System.out.print("Digite seu nome: ");
        String nome = sc.next();
        System.out.print("\nDigite sua data de nascimento (ddmmaaaa): ");
        int dataDeNasc = sc.nextInt();
        System.out.print("\nDigite seu CPF: ");
        String cpf = sc.next();
        System.out.print("\nDigite seu e-mail: ");
        String email = sc.next();
        System.out.print("\nDigite seu telefone: ");
        String telefone = sc.next();
        System.out.print("\nDigite sua senha: ");
        String password = sc.next();
        Client newClient = new Client(nome, dataDeNasc, cpf, email, telefone, password);
        System.out.println("\n=== Cadastro realizado com sucesso! ===");
        cadastroConta(tipoDeConta, newClient);
    }

    public static void cadastroConta(String tipoDeConta, Client newClient) {
        if (tipoDeConta.equals("corrente")){
            Conta newAccount = new ContaCorrente(newClient);
            newClient.addConta(newAccount);
            System.out.println("Sua nova conta corrente foi criada com sucesso!");
            System.out.println("Agência: " + newAccount.getAgencia());
            System.out.println("Numero da conta: " + newAccount.getNumeroConta());
        } else if (tipoDeConta.equals("poupanca")) {
            Conta newAccount = new ContaPoupanca(newClient);
            newClient.addConta(newAccount);
            System.out.println("Sua nova conta poupança foi criada com sucesso!");
            System.out.println("Agência: " + newAccount.getAgencia());
            System.out.println("Numero da conta: " + newAccount.getNumeroConta());
        }
        dataBank.addClientToList(newClient);
        newClient.showClientData();
        newClient.showContas();
        menuDeEntrada();
    }

    public static void alterarDados(Client loggedClient) {
        System.out.println("\n=== Alterar Dados ===");
        System.out.println("""
                Escolha uma opção:
                1. Alterar e-mail
                2. Alterar telefone
                3. Alterar senha
                4. Voltar""");
        input = sc.nextInt();
        switch (input) {
            case 1 -> {
                System.out.println("Digite seu novo e-mail: ");
                String novoEmail = sc.next();
                dataBank.alterarCadastroCliente(loggedClient, "email", novoEmail);
                alterarDados(loggedClient);
            }
            case 2 -> {
                System.out.println("Digite seu novo telefone: ");
                String novoTelefone = sc.next();
                dataBank.alterarCadastroCliente(loggedClient, "telefone", novoTelefone);
                alterarDados(loggedClient);
            }
            case 3 -> {
                System.out.println("Digite sua nova senha: ");
                String novaSenha = sc.next();
                dataBank.alterarCadastroCliente(loggedClient, "password", novaSenha);
                alterarDados(loggedClient);
            }
            case 4 -> menuDeAcesso(loggedClient);
            default -> {
                invaidOption();
                alterarDados(loggedClient);
            }
        }

    }

    public static void invaidOption() {
        System.out.println("Opção inválida. Tente novamente.");
    }

    public static void exit() {
        System.out.println("Saindo... Até logo!");
        menuDeEntrada();
    }
}
