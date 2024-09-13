package org.monopoly.lugares;

import org.monopoly.cartas.Carta;
import org.monopoly.cartas.CartaRepository;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;
import org.monopoly.jogo.Tabuleiro;

import java.util.ArrayList;
import java.util.Collections;

public class CofreComunitario extends Lugar {
    private Tabuleiro tabuleiro;
    private int indiceCarta;

    public CofreComunitario(String nome, int posicao, Tabuleiro tabuleiro) {
        super(nome, posicao);
        indiceCarta = 0;
        this.tabuleiro = tabuleiro;
    }

    public Carta pegarCarta(ArrayList<Carta> cartas) {
        if(indiceCarta >= cartas.size()) {
            indiceCarta = 0;
        }
        Carta cartaVez = cartas.get(indiceCarta);
        indiceCarta++;
        return cartaVez;
    }

    // public void mostrarCarta(){
    //     for (Carta c: cartas){
    //         System.out.println(c);
    //     }
    // }

    @Override
    public void venderLugar(Jogador jogadorComprador){}

    @Override
    public void ofertarVendaLugar(Jogador jogador){}

    @Override
    public void executarAcao(Peao peao) {
        Carta carta = pegarCarta(tabuleiro.getCartasCofreComunitarios());
        carta.executarAcao(peao);
    }

    public int getIndiceCarta(){
        return this.indiceCarta;
    }
}
