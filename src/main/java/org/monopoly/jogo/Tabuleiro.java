package org.monopoly.jogo;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.Lugar_old;
import org.monopoly.lugares.Propriedade;
import org.monopoly.lugares.repository.LugarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tabuleiro {
    Dados dados = new Dados();
    private ArrayList<Lugar> lugares;

    public Tabuleiro(){
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        LugarRepository repo = new LugarRepository();
        this.lugares = repo.iniciar();
        System.out.println("Inicializando tabuleiro");
    }

    public Lugar getLugar(int posicao) {
        return lugares.get(posicao);
    }

    public void jogar(Peao peao_da_vez){
        Scanner scanner = new Scanner(System.in);
        int[] numeros = dados.jogarDados();
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
}
