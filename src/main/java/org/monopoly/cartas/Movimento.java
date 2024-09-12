package org.monopoly.cartas;

import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

public class Movimento extends Carta{
    private int posicao;
    private RegraMovimentacao regraMovimentacao;

    public Movimento(int numero, String nome, String descricao, RegraMovimentacao regraMovimentacao) {
        super(numero, nome, descricao);
        this.regraMovimentacao = regraMovimentacao;
    }

    @Override
    public void executarAcao(Peao peao) {
        // executar ação
    }
}
