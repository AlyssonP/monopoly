package org.monopoly.jogo;

public class Peao {
    private Jogador jogador;
    private int posicao;

    public Peao(Jogador jogador, int posicao) {
        this.jogador = jogador;
        this.posicao = 1;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
