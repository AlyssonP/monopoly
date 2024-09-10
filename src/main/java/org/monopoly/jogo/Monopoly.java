package org.monopoly.jogo;

import java.util.ArrayList;

public class Monopoly {
    private ArrayList<Peao> peaos;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private int jogador_da_vez = 0;

    public Monopoly() {
        this.peaos = new ArrayList<>();
    }

    public void addPeao(Peao peao) {peaos.add(peao)};

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
