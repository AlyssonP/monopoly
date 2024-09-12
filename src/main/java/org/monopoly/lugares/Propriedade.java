package org.monopoly.lugares;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;
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
    }

    public int getPreco(){
        return this.preco;
    }

    public CorLugar getCor(){
        return this.cor;
    }

    @Override
    public void executarAcao(Peao peao) {
        // executar ação de propriedade
    }
}
