package org.monopoly;

public class Jogador {
    private String nome;
    private double saldo;
    private Cor cor;
    private int posicao;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
        saldo = 1500;
        posicao = 1;
    }

    public void status() {}
}
