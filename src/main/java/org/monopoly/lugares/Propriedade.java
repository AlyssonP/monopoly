package org.monopoly.lugares;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

public class Propriedade extends Lugar{
    private CorLugar cor;
    private int preco;
    private int[] aluguel; // Aluguel para 0, 1, 2, 3, 4 casas e hotel
    private int precoCasa;
    private int hipoteca;
    private int casas;

    public Propriedade(String nome, int posicao, CorLugar cor, int preco, int[] aluguel, int hipoteca, int precoCasa) {
        super(nome, posicao);
        this.cor = cor;
        this.preco = preco;
        this.aluguel = aluguel;
        this.hipoteca = hipoteca;
        this.precoCasa = precoCasa;
    }

    public int getPreco(){
        return this.preco;
    }

    public CorLugar getCor(){
        return this.cor;
    }

    public int getCasas(){
        return this.casas;
    }

    public void setCasas(){
        this.casas+=1;
    }

    public int getPrecoCasa(){
        return this.precoCasa;
    }

    public int getAluguel(){
        return this.aluguel[this.casas];
    }

    public int getHipoteca() {return hipoteca;}

    @Override
    public void venderLugar(Jogador jogadorComprador){}

    @Override
    public void ofertarVendaLugar(Jogador jogador){}

    @Override
    public void executarAcao(Peao peao) {
        // executar ação de propriedade
    }
}
