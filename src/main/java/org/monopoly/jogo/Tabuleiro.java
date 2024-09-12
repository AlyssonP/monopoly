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
        Lugar_old lugar = new Lugar_old();
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
       if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()==null) && peao_da_vez.getJogador().podeComprar((Propriedade) lugares.get(peao_da_vez.getPosicao()-1))){
            System.out.println(lugares.get(peao_da_vez.getPosicao()-1).getNome()+" \nPosição:"+lugares.get(peao_da_vez.getPosicao()-1).getPosicao());
            System.out.println("Você pode comprar essa propriedade, deseja fazer isso ? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                lugares.get(peao_da_vez.getPosicao()-1).setProprietario(peao_da_vez.getJogador());
                peao_da_vez.getJogador().comprar((Propriedade) lugares.get(peao_da_vez.getPosicao()-1));
                System.out.println(peao_da_vez.getJogador().getNome()+" Comprouu!");
            }else{
                System.out.println(peao_da_vez.getJogador().getNome()+" optou por não comprar!");
            }
       }else if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()==peao_da_vez.getJogador())){
            System.out.println("Essa é suaaa!!!!");
       }
   }
}
