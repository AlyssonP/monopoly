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
    //    peao_da_vez.setPosicao(numeros[2]);
        peao_da_vez.setPosicao(3);
    //    SE O TERRENO NÃO TEM DONO E O JOGADOR PODE COMPRAR 
       if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()==null) && peao_da_vez.getJogador().podeComprarTerreno((Propriedade) lugares.get(peao_da_vez.getPosicao()-1))){
            System.out.println("Jogador: "+peao_da_vez.getJogador().getNome()+" \nSaldo: "+peao_da_vez.getJogador().getSaldo());
            System.out.println(lugares.get(peao_da_vez.getPosicao()-1).getNome()+" \nPosição:"+lugares.get(peao_da_vez.getPosicao()-1).getPosicao());
            System.out.println("Você pode comprar essa propriedade, deseja fazer isso ? (s/n)");
            String resposta = scanner.nextLine();
            peao_da_vez.getJogador().comprarTerreno(resposta, (Propriedade) lugares.get(peao_da_vez.getPosicao()-1));
        // SE O TERRENO NA POSIÇÃO ATUAL É DO JOGADOR ATUAL
       }else if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()==peao_da_vez.getJogador())){
            System.out.println("Jogador: "+peao_da_vez.getJogador().getNome()+" \nSaldo: "+peao_da_vez.getJogador().getSaldo());
            System.out.println(lugares.get(peao_da_vez.getPosicao()-1).getNome()+" \nPosição:"+lugares.get(peao_da_vez.getPosicao()-1).getPosicao());

            System.out.println("Essa propriedade é sua, deseja comprar um imovel ? (s/n)");
            String resposta = scanner.nextLine();
            if (peao_da_vez.getJogador().podeComprarImovel(resposta, (Propriedade) lugares.get(peao_da_vez.getPosicao()-1))){
                peao_da_vez.getJogador().comparImovel((Propriedade) lugares.get(peao_da_vez.getPosicao()-1));
            }
       }
       else if((lugares.get(peao_da_vez.getPosicao()-1).getProprietario()!=null)&&(lugares.get(peao_da_vez.getPosicao()-1).getProprietario()!=peao_da_vez.getJogador())){
            
        peao_da_vez.getJogador().pagarAluguel((Propriedade) lugares.get(peao_da_vez.getPosicao()-1));
    }
       else{
            System.out.println("Jogador: "+peao_da_vez.getJogador().getNome()+" \nSaldo: "+peao_da_vez.getJogador().getSaldo());
            System.out.println(lugares.get(peao_da_vez.getPosicao()-1).getNome()+" \nPosição:"+lugares.get(peao_da_vez.getPosicao()-1).getPosicao());
            lugares.get(peao_da_vez.getPosicao()-1).executarAcao(peao_da_vez);
       }
   }
}
