package org.monopoly.lugares.cantos;

import org.monopoly.jogo.Peao;
import org.monopoly.lugares.Canto;

public class ParadaLivre extends Canto {
    public ParadaLivre(String nome, int posicao) {
        super(nome, posicao);
    }

    @Override
    public void executarAcao(Peao peao) {
        System.out.println("Você caiu na Parada Livre, nada acontece.");
    }
}
