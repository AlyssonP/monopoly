package org.monopoly.jogo;

import java.util.ArrayList;

public class Monopoly {
    private ArrayList<Peao> peaos;
    private Tabuleiro tabuleiro;
    private int jogador_da_vez = 0;

    public Monopoly() {
        peaos = new ArrayList<>();
        tabuleiro = new Tabuleiro();
    }

    public void addPeao(Jogador jogador) {peaos.add(new Peao(jogador, 0));}

    public void jogar(){
       this.tabuleiro.jogar(peaos.get(jogador_da_vez));
       alterar_jogador_da_vez();
    }

    public void alterar_jogador_da_vez(){
        if (this.jogador_da_vez == this.peaos.size()-1){
            this.jogador_da_vez = 0;
        }else{
            this.jogador_da_vez += 1;
        }
    }

}
