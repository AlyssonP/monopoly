package org.monopoly.lugares.cantos;

import org.monopoly.jogo.Peao;
import org.monopoly.lugares.Canto;

public class PontoPartida extends Canto {
    public PontoPartida(String nome, int posicao) {
        super(nome, posicao);
    }

    @Override
    public void executarAcao(Peao peao) {
        System.out.println("Você caiu no ponto de partida, receba $200.");
        peao.getJogador().acrescentarSaldo(200);
    }
}
