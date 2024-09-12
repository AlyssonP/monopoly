package org.monopoly.lugares.cantos;

import org.monopoly.jogo.Peao;
import org.monopoly.lugares.Canto;

public class VaiParaPrisao extends Canto {
    public VaiParaPrisao(String nome, int posicao) {
        super(nome, posicao);
    }

    @Override
    public void executarAcao(Peao peao) {
        System.out.println("Você vai para prisão");
    }
}
