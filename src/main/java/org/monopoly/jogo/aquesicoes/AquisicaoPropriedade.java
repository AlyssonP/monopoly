package org.monopoly.jogo.aquesicoes;

import org.monopoly.jogo.Aquisicao;
import org.monopoly.lugares.Propriedade;

public class AquisicaoPropriedade extends Aquisicao {
    private int aluguel;

    public AquisicaoPropriedade(Propriedade propriedade) {
        super(propriedade.getPreco(), propriedade.getHipoteca());
        this.aluguel = propriedade.getAluguel();
    }

    public int getAluguel() {
        return aluguel;
    }
}
