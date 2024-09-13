package org.monopoly.jogo;

import org.monopoly.jogo.aquesicoes.AquisicaoFerrovia;
import org.monopoly.jogo.aquesicoes.AquisicaoPropriedade;
import org.monopoly.lugares.Ferrovia;
import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.Propriedade;
import org.monopoly.lugares.ServicoPublico;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private double saldo;
    private Cor cor;
    private List<AquisicaoInterface> aquisicoes;

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

    public List<AquisicaoInterface> getAquisicoes() {
        return aquisicoes;
    }

//    public List<AquisicaoFerrovia> getAquisicoesFerrovia() {
//        List<AquisicaoFerrovia> ferrovias = new ArrayList<>();
//        for(AquisicaoInterface aquisicao: aquisicoes) {
//            if(aquisicao instanceof AquisicaoFerrovia) {
//                ferrovias.add(new AquisicaoFerrovia());
//            }
//        }
//        return ferrovias;
//    }
    public void comprarLugar(Lugar lugar) {

    }

    public String getNome(){
        return this.nome;
    }

    public String getNomeCor() {
        return cor.getNome();
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public void imprimirAquisicoes() {
        System.out.println("Aquisições");
    }

    public boolean podeComprarTerreno(Propriedade lugar){
       if(this.saldo>=lugar.getPreco()){
           aquisicoes.add(new AquisicaoPropriedade(lugar));
           return true;
       }
       return false;

    }

    public void comprarTerreno(Propriedade lugar){
        lugar.setProprietario(this);
        descontarSaldo(lugar.getPreco());
        System.out.println(getNome()+" Comprouu!");
    }

    public boolean podeComprarImovel(Propriedade lugar){
        if(this.saldo>=lugar.getPrecoCasa() && lugar.getCasas()<5){
            return true;
        }
        return false;
    };

    public void comparImovel(Propriedade lugar){
        lugar.setCasas();
        this.saldo -= lugar.getPrecoCasa();
    }

    public void pagarAluguelPropriedade(Propriedade lugar){
        descontarSaldo(lugar.getAluguel());
        lugar.getProprietario().acrescentarSaldo(lugar.getAluguel());
    }

    public void pagarAluguelServicoPublico(ServicoPublico lugar){
        this.descontarSaldo(lugar.getPreco());
        lugar.getProprietario().acrescentarSaldo(lugar.getPreco());
    }

    public void comprarFerrovia(Ferrovia ferrovia) {
        descontarSaldo(ferrovia.getValor());
        aquisicoes.add(new AquisicaoFerrovia(ferrovia));
    }

    public void comprarServicoPublico(ServicoPublico lugar){
        descontarSaldo(lugar.getPreco());
        lugar.setProprietario(this);
    }
}
