package org.monopoly.lugares;

import org.monopoly.jogo.Peao;

public class Imposto extends Lugar {
    private TipoImposto tipoImposto;

    public Imposto(String nome, int posicao, TipoImposto tipoImposto) {
        super(nome, posicao);
        this.tipoImposto = tipoImposto;
    }

    @Override
    public void executarAcao(Peao peao) {
        System.out.printf("Você caiu no imposto %s\n, Terá que pagar R$ %d ao banco", tipoImposto.getNome(), tipoImposto.getValor());
        peao.getJogador().descontarSaldo(tipoImposto.getValor());
    }
}
