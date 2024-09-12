package org.monopoly.jogo;

import org.monopoly.CorLugar;

public class Aquisicao {
    private String nome;
    private CorLugar cor;
    private int preco;

    public Aquisicao(String nome, CorLugar cor, int preco) {
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CorLugar getCor() {
        return cor;
    }

    public void setCor(CorLugar cor) {
        this.cor = cor;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
