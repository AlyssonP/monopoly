package org.monopoly.lugares;

import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

public abstract class Lugar {
    private String nome;
    private Jogador proprietario;
    private int posicao;

    public Lugar(String nome, int posicao) {
        this.nome = nome;
        this.posicao = posicao;

        proprietario = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Jogador getProprietario(){
        return this.proprietario;
    }

    public void setProprietario(Jogador proprietario){
        this.proprietario = proprietario;
    }

    public abstract void venderLugar(Jogador jogadorComprador);
    public abstract void ofertarVendaLugar(Jogador jogador);
    public abstract void executarAcao(Peao peao);
}
