package org.monopoly.cartas;

import org.monopoly.jogo.Jogador;

public enum RegraPagemento {
    PAGAR {
      public void executarRegra(Jogador jogador, int valor) {
          jogador.descontarSaldo(valor);
      }
    },
    RECEBER {
        public void executarRegra(Jogador jogador, int valor) {
            jogador.acrescentarSaldo(valor);
        }
    };

    public abstract void executarRegra(Jogador jogador, int valor);
}
