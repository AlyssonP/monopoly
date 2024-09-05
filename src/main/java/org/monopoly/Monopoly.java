package org.monopoly;

import java.util.ArrayList;

public class Monopoly {
    private ArrayList<Jogador> jogadores;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private int jogador_da_vez = 0;

    public Monopoly() {
        this.jogadores = new ArrayList<>();
    }

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void jogar(){
        this.tabuleiro.jogar(jogadores.get(jogador_da_vez));
        alterar_jogador_da_vez();
    }

    public void alterar_jogador_da_vez(){
        if (this.jogador_da_vez == this.jogadores.size()-1){
            this.jogador_da_vez = 0;
        }else{
            this.jogador_da_vez += 1;
        }
    }

}
