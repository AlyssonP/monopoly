package org.monopoly;

import java.util.List;

public class Tabuleiro {
    List<Lugar> lugares;
    Dados dados = new Dados();

    public Tabuleiro(){
        Lugar lugar = new Lugar();
        this.lugares = lugar.criarLugares();
    }

    public void jogar(Jogador jogador_da_vez){
        int[] numeros = dados.jogarDados();
        jogador_da_vez.setPosicao(numeros[2]);
        if((lugares.get(jogador_da_vez.getPosicao()-1).getProprietario()==null) && jogador_da_vez.comprar(lugares.get(jogador_da_vez.getPosicao()-1))){
            lugares.get(jogador_da_vez.getPosicao()-1).setProprietario(jogador_da_vez);
        }
        System.out.println(lugares.get(jogador_da_vez.getPosicao()-1)); 
        System.out.println(jogador_da_vez.toString());
    }
}
