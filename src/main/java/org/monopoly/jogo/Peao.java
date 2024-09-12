package org.monopoly.jogo;

public class Peao {
    private Jogador jogador;
    private int posicao;

    public Peao(Jogador jogador, int posicao) {
        this.jogador = jogador;
        this.posicao = 5;
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
        this.posicao = posicao;
    }
    @Override
   public String toString() {
       return "Jogador:"+this.jogador.getNome()+"    Posição:"+this.posicao;
   }
}
