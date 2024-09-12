package org.monopoly.cartas;

import org.monopoly.jogo.Peao;

public class Pagamento extends Carta{
    private RegraPagemento regraPagemento;
    private int valor;

    public Pagamento(int numero, String nome, String descricao, RegraPagemento regraPagemento, int valor) {
        super(numero, nome, descricao);
        this.regraPagemento = regraPagemento;
        this.valor = valor;
    }

    @Override
    public void executarAcao(Peao peao) {
        System.out.println(super.getNome()+" - "+super.getDescricao());
        regraPagemento.executarRegra(peao.getJogador(), valor);
    }
}
