import com.iphone.IPhone;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        IPhone meuIphone = new IPhone();
        int option = 0;
        while (option != 4) {
            System.out.println("""
                    Digite qual aplicação deseja abrir:
                    1 - iPod;
                    2 - Phone;
                    3 - Safari
                    4 - Sair""");
            option = sc.nextInt();
            switch (option){
                case 1:
                    openIPod(meuIphone);
                    break;
                case 2:
                    openPhone(meuIphone);
                    break;
                case 3:
                    openSafari(meuIphone);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void openIPod(IPhone iphone){
        int option = 0;
        while (option != 4){
            System.out.println("""
                    Digite qual ação deseja realizar:
                    1 - Tocar música;
                    2 - Pausar música;
                    3 - Selecionar música;
                    4 - Voltar""");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    iphone.tocar();
                    break;
                case 2:
                    iphone.pausar();
                    break;
                case 3:
                    System.out.println("Digite o nome da música:");
                    String musica = sc.nextLine();
                    iphone.selecionarMusica(musica);
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            if (option == 4){
                break;
            }
        }
    }

    private static void openPhone(IPhone iPhone){
        int option = 0;
        while (option != 4){
            System.out.println("""
                    Digite qual ação deseja realizar:
                    1 - Ligar;
                    2 - Atender;
                    3 - Correio de voz;
                    4 - Voltar""");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Digite o número para ligar:");
                    String numero = sc.nextLine();
                    iPhone.ligar(numero);
                    break;
                case 2:
                    iPhone.atender();
                    break;
                case 3:
                    iPhone.correioDeVoz();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            if (option == 4){
                break;
            }
        }
    }

    private static void openSafari(IPhone iPhone){
        int option = 0;
        while (option != 4){
            System.out.println("""
                    Digite qual ação deseja realizar:
                    1 - Exibir página;
                    2 - Adicionar nova aba;
                    3 - Atualizar página;
                    4 - Voltar""");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Digite a URL:");
                    String url = sc.nextLine();
                    iPhone.exibirPagina(url);
                    break;
                case 2:
                    iPhone.adicionarNovaAba();
                    break;
                case 3:
                    iPhone.atualizarPagina();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            if (option == 4){
                break;
            }
        }
    }
}
