package org.monopoly.lugares;

import org.monopoly.cartas.Carta;
import org.monopoly.jogo.Peao;

import java.util.ArrayList;
import java.util.Collections;

public class SorteReves extends Lugar{
    private ArrayList<Carta> cartas;
    private int indiceCarta;

    private SorteReves(String nome, int posicao) {
        super(nome, posicao);
        inicializarCartas();
        embaralharCartas();
        indiceCarta = 0;
    }

    public void inicializarCartas() {
        // Logica de inicialização
    }

    public void embaralharCartas() {
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() {
        if(indiceCarta >= cartas.size()) {
            indiceCarta = 0;
        }
        Carta cartaVez = cartas.get(indiceCarta);
        indiceCarta++;
        return cartaVez;
    }

    @Override
    public void executarAcao(Peao peao) {
        Carta carta = pegarCarta();
        carta.executarAcao(peao);
    }
}
