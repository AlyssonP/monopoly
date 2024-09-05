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

    @Override
    public String toString() {
        return "Jogador:"+this.nome+"    Posição:"+this.posicao;
    }
    public void setPosicao(int posicao){
        if ((this.posicao+posicao)>40){
            this.posicao = (this.posicao+=posicao)-40;
        }else{
            this.posicao += posicao;
        }
        
    }

    public int getPosicao(){
        return this.posicao;
    }
}
