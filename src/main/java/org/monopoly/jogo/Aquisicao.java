package org.monopoly.jogo;

public abstract class Aquisicao {
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
}
