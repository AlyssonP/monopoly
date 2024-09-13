package org.monopoly.lugares;

import org.monopoly.cartas.Carta;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;
import org.monopoly.jogo.Tabuleiro;

import java.util.ArrayList;

public class SorteReves extends Lugar{
    private int indiceCarta;
    private Tabuleiro tabuleiro;

    public SorteReves(String nome, int posicao, Tabuleiro tabuleiro) {
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
        Carta carta = pegarCarta(tabuleiro.getCartaSorteReves());
        carta.executarAcao(peao);
    }
}
