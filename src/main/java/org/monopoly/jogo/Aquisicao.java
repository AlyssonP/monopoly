package org.monopoly.jogo;

import org.monopoly.lugares.Ferrovia;

public abstract class Aquisicao implements AquisicaoInterface{
    private int preco;
    private int hipoteca;

    public Aquisicao(int preco, int hipoteca) {
        this.preco = preco;
        this.hipoteca = hipoteca;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public int getValorEspecifico() {
        return preco;
    }
}
