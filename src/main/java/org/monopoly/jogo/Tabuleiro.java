package org.monopoly.jogo;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.Lugar_old;

import java.util.ArrayList;

public class Tabuleiro {
    Dados dados = new Dados();
    private ArrayList<Lugar> lugares;

    public Tabuleiro(){
        Lugar_old lugar = new Lugar_old();
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        // Adicionar logica para inicialização
        System.out.println("Inicializando tabuleiro");
    }

//    public void jogar(Peao peao_da_vez){
//        int[] numeros = dados.jogarDados();
//        peao_da_vez.setPosicao(numeros[2]);
//        if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()==null) && jogador_da_vez.comprar(lugares.get(peao_da_vez.getPosicao()-1))){
//            lugares.get(peao_da_vez.getPosicao()-1).setProprietario(peao_da_vez);
//        }
//        System.out.println(lugares.get(peao_da_vez.getPosicao()-1));
//        System.out.println(peao_da_vez.toString());
//    }
}
