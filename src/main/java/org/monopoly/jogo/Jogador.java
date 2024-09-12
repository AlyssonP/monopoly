package org.monopoly.jogo;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.Propriedade;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private double saldo;
    private Cor cor;
    private List<Aquisicao> aquisicoes;

    public Jogador(String nome, Cor cor) {
        this.nome = nome;
        this.cor = cor;
        saldo = 1500;
        aquisicoes = new ArrayList<>();
    }

    public void acrescentarSaldo(int valor) {
        saldo+=valor;
    }

    public void descontarSaldo(int valor) {
        saldo-=valor;
    }

    public void addAquisicao(Aquisicao aquisicao) {
        aquisicoes.add(aquisicao);
    }

    public void comprarLugar(Lugar lugar) {

    }

    public String getNome(){
        return this.nome;
    }

//    @Override
//    public String toString() {
//        return "Jogador:"+this.nome+"    Posição:"+this.posicao;
//    }
//    public void setPosicao(int posicao){
//        if ((this.posicao+posicao)>40){
//            this.posicao = (this.posicao+=posicao)-40;
//        }else{
//            this.posicao += posicao;
//        }
//
//    }

   public boolean podeComprar(Propriedade lugar){
       System.out.println(this.saldo + this.nome);
       if(this.saldo>=lugar.getPreco()){
           aquisicoes.add(new Aquisicao(lugar.getNome(), lugar.getCor(), lugar.getPreco()));
           return true;
       }
       return false;

   }
   public void comprar(Propriedade lugar){
        this.saldo -= lugar.getPreco();
   }
}
