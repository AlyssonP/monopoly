package org.monopoly.jogo;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.Lugar_old;
import org.monopoly.lugares.Propriedade;
import org.monopoly.lugares.PropriedadeRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {
    Dados dados = new Dados();
    private ArrayList<Lugar> lugares;

    public Tabuleiro(){
        inicializarTabuleiro();
    }

    public void inicializarTabuleiro() {
        PropriedadeRepository repo = new PropriedadeRepository();
        this.lugares = repo.iniciar();
        System.out.println("Inicializando tabuleiro");
    }



   public void jogar(Peao peao_da_vez){
       Scanner scanner = new Scanner(System.in);
       int[] numeros = dados.jogarDados();
       peao_da_vez.setPosicao(numeros[2]);
       lugares.get(peao_da_vez.getPosicao()).executarAcao(peao_da_vez);
   }
}
