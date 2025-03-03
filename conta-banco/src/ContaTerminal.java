import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        int numeroConta;
        String agencia;
        String nomeCliente;
        double saldo;

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, digite seu nome:");
        nomeCliente = sc.nextLine();

        System.out.println("Por favor, digite o número da agência:");
        agencia = sc.nextLine();

        System.out.println("Por favor, digite o número da conta:");
        numeroConta = sc.nextInt();

        System.out.println("Por favor, digite o saldo da conta:");
        saldo = sc.nextDouble();

        System.out.println("\nOlá, " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + ", e seu saldo R$ " + saldo + " já está disponível para saque.");

        sc.close();
    }
}
