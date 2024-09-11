package org.monopoly.cartas;

public class Pagamento extends Carta{
    private RegraPagemento regraPagemento;

    public Pagamento(int numero, String nome, String descricao, RegraPagemento regraPagemento) {
        super(numero, nome, descricao);
        this.regraPagemento = regraPagemento;
    }

    @Override
    public void executarAcao() {
        regraPagemento.executarRegra();
    }
}
