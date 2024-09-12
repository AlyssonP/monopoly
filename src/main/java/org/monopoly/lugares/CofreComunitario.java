package org.monopoly.lugares;

import org.monopoly.cartas.Carta;
import org.monopoly.cartas.CartaRepository;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

import java.util.ArrayList;
import java.util.Collections;

public class CofreComunitario extends Lugar {
    private ArrayList<Carta> cartas;
    private int indiceCarta;

    public CofreComunitario(String nome, int posicao) {
        super(nome, posicao);
        inicializarCartas();
        embaralharCartas();
        indiceCarta = 0;
    }

    public void inicializarCartas() {
        CartaRepository repo = new CartaRepository();
        this.cartas = repo.iniciar("./cofresComunitarios.csv");
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
        Carta carta = pegarCarta();
        carta.executarAcao(peao);
    }
}
