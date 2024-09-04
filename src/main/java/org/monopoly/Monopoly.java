package org.monopoly;

import java.util.ArrayList;

public class Monopoly {
    private ArrayList<Jogador> jogadores;

    public Monopoly() {
        this.jogadores = new ArrayList<>();
    }

    public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }


}
