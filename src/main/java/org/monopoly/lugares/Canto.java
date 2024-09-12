package org.monopoly.lugares;

import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

public class Canto extends Lugar{
    public Canto(String nome, int posicao) {
        super(nome, posicao);
    }

    @Override
    public void venderLugar(Jogador jogadorComprador) {}

    @Override
    public void ofertarVendaLugar(Jogador jogador){}

    @Override
    public void executarAcao(Peao peao) {}

}
