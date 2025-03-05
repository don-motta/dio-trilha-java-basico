import exceptions.ParametrosInvalidosException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Por favor, digite o primeiro parâmetro: ");
        int parametroUm = sc.nextInt();
        System.out.println("Por favor, digite o segundo parâmetro: ");
        int parametroDois = sc.nextInt();

        try {
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException e) {
            System.out.println("O primeiro segundo parâmetro deve ser maior que o primeiro.");
        }

        sc.close();

    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm < parametroDois) {
            int contagem = parametroDois - parametroUm;
            for (int i = 1; i <= contagem; i++) {
                System.out.println("imprimindo o número " + i);
            }
        } else {
            throw new ParametrosInvalidosException();
        }
    }
}
