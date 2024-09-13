package org.monopoly.jogo;

import org.monopoly.cartas.Carta;
import org.monopoly.cartas.CartaRepository;
import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.repository.LugarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    Dados dados = new Dados();
    private ArrayList<Lugar> lugares = new ArrayList<>();
    private ArrayList<Carta> cartasCofreComunitario = new ArrayList<>();
    private ArrayList<Carta> cartaSorteReves= new ArrayList<>();

    public Tabuleiro(){
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        this.lugares = LugarRepository.iniciar(this);
        this.cartasCofreComunitario = CartaRepository.iniciar("./csv/cofres_comunitarios_cartas.csv", cartasCofreComunitario);
        this.cartaSorteReves = CartaRepository.iniciar("./csv/sorte_reves_cartas.csv", cartaSorteReves);
        System.out.println("Inicializando tabuleiro");
    }

    public Lugar getLugar(int posicao) {
        return lugares.get(posicao);
    }

    public void jogar(Peao peao_da_vez){
        Scanner scanner = new Scanner(System.in);
        int[] numeros = dados.jogarDados();
        System.out.printf("Jogou os dados: %d + %d = %d\n", numeros[0], numeros[1], numeros[2]);
        peao_da_vez.setPosicao(numeros[2]);
        Lugar lugar = buscarLugarPorPosicao(lugares, peao_da_vez.getPosicao());
        lugar.executarAcao(peao_da_vez);
    }
    public Lugar buscarLugarPorPosicao(List<Lugar> lugares, int posicao) {
        for (Lugar lugar : lugares) {
            if (lugar.getPosicao() == posicao) {
                return lugar;
            }
        }
        return null;
    }

    public ArrayList<Carta> getCartaSorteReves(){
        return this.cartaSorteReves;
    }

    public ArrayList<Carta> getCartasCofreComunitarios(){
        return this.cartasCofreComunitario;
    }
}
