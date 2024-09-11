package org.monopoly.jogo;

public class Aquisicao {
    private String nome;
    private Cor cor;
    private int preco;

    public Aquisicao(String nome, Cor cor, int preco) {
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

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
