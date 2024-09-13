package org.monopoly.jogo;

public class Peao {
    private Jogador jogador;
    private int posicao;

    public Peao(Jogador jogador, int posicao) {
        this.jogador = jogador;
        this.posicao = 40;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public String getNomeJogador() {
        return jogador.getNome();
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        if((this.posicao+posicao)>40){
            this.posicao+=posicao;
            this.posicao-=40;
        }else{
            this.posicao+=posicao;
        }
    }

    public void getComandos() {
        System.out.println("[jogar][status][sair]");
    }

    public void getStatus(Tabuleiro tabuleiro) {
        System.out.printf("O status de %s - %s é o seguinte:\n", jogador.getNome(), jogador.getNomeCor());
        System.out.printf("Sistuado na posição %d - %s\n", posicao, tabuleiro.getLugar(posicao).getNome());
        System.out.println("Títulos:");
        jogador.imprimirAquisicoes();
    }

    @Override
   public String toString() {
       return "Jogador:"+this.jogador.getNome()+"    Posição:"+this.posicao;
   }
}
