package com.iphone;

public class IPhone implements IPod, Phone, Safari {
    private String musica;
    @Override
    public void tocar() {
        if (musica == null){
            System.out.println("Nenhuma música selecionada. Seleciona uma música para tocar.");
            return;
        }
        System.out.println("Tocando a música "+musica+" no IPod");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando a música "+musica+" no IPod");
    }

    @Override
    public void selecionarMusica(String musica) {
        this.musica = musica;
        System.out.println("Você selecionou a música "+this.musica+" !");
    }


    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo a página "+url+" no IPhone");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada");
    }

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para "+numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo a ligação no IPhone");
    }

    @Override
    public void correioDeVoz() {
        System.out.println("Voce tem uma nova mensagem de voz");
    }
}
