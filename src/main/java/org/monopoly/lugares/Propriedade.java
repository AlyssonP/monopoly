package org.monopoly.lugares;

import org.monopoly.jogo.Cor;

public class Propriedade extends Lugar{
    private Cor cor;
    private int preco;
    private int precoAluguel;

    public Propriedade(String nome, int posicao, Cor cor, int preco, int precoAluguel) {
        super(nome, posicao);
        this.cor = cor;
        this.preco = preco;
        this.precoAluguel = precoAluguel;
    }

    @Override
    public void executarAcao() {
        // executar ação de propriedade
    }
}
