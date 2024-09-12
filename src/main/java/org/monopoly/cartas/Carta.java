package org.monopoly.cartas;

import org.monopoly.jogo.Peao;

public abstract class Carta {
    private int numero;
    private String nome;
    private String descricao;

    public Carta(int numero, String nome, String descricao) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract void executarAcao(Peao peao);
}
