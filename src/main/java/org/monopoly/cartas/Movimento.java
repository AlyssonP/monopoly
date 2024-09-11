package org.monopoly.cartas;

public class Movimento extends Carta{
    private int posicao;
    private RegraMovimentacao regraMovimentacao;

    public Movimento(int numero, String nome, String descricao, RegraMovimentacao regraMovimentacao) {
        super(numero, nome, descricao);
        this.regraMovimentacao = regraMovimentacao;
    }

    @Override
    public void executarAcao() {
        // executar ação
    }
}
