package org.monopoly.lugares;

import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

public class ServicoPublico extends Lugar {
    private int preco;
    private int hipoteca;

    public ServicoPublico(String nome, int posicao, int preco, int hipoteca) {
        super(nome, posicao);
        this.preco = preco;
        this.hipoteca = hipoteca;
    }

    public int getPreco() { return preco; }

    public void setPreco(int preco) { this.preco = preco;}

    public int getHipoteca() { return hipoteca; }

    public void setHipoteca(int hipoteca) { this.hipoteca = hipoteca; }

    @Override
    public void venderLugar(Jogador jogadorComprador){}

    @Override
    public void ofertarVendaLugar(Jogador jogador){}

    @Override
    public void executarAcao(Peao peao) {
        // executar ação de propriedade
    }
}
