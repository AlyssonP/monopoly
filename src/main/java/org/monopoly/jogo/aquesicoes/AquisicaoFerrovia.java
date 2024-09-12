package org.monopoly.jogo.aquesicoes;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Aquisicao;
import org.monopoly.lugares.Ferrovia;

public class AquisicaoFerrovia extends Aquisicao {
    private int corrida;

    public AquisicaoFerrovia(Ferrovia ferrovia) {
        super(ferrovia.getValor(), ferrovia.getHipoteca());
        this.corrida = 15;
    }

    public int getCorrida() {
        return corrida;
    }

}
