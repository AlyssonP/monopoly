package org.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private double saldo;
    private Cor cor;
    private int posicao;
    private List<Lugar> aquisicoes = new ArrayList<>();

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

    public boolean comprar(Lugar lugar){
        System.out.println(this.saldo + this.nome);
        if(this.saldo>=lugar.getPrecoInicial()){
            aquisicoes.add(lugar);
            this.saldo -= lugar.getPrecoInicial();
            return true;
        }
        return false;

    }
}
