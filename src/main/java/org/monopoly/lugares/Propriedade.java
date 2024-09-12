package org.monopoly.lugares;

import java.util.Scanner;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;
import org.monopoly.jogo.Peao;

public class Propriedade extends Lugar{
    private CorLugar cor;
    private int preco;
    private int[] aluguel; // Aluguel para 0, 1, 2, 3, 4 casas e hotel
    private int precoCasa;
    private int hipoteca;
    private int casas;

    public Propriedade(String nome, int posicao, CorLugar cor, int preco, int[] aluguel, int hipoteca, int precoCasa) {
        super(nome, posicao);
        this.cor = cor;
        this.preco = preco;
        this.aluguel = aluguel;
        this.hipoteca = hipoteca;
        this.precoCasa = precoCasa;
    }

    public int getPreco(){
        return this.preco;
    }

    public CorLugar getCor(){
        return this.cor;
    }

    public int getCasas(){
        return this.casas;
    }

    public void setCasas(){
        this.casas+=1;
    }

    public int getPrecoCasa(){
        return this.precoCasa;
    }

    public int getAluguel(){
        return this.aluguel[this.casas];
    }

    @Override
    public void executarAcao(Peao peao) {
        Scanner scanner = new Scanner(System.in);
    //    SE O TERRENO NÃO TEM DONO E O JOGADOR PODE COMPRAR 
       if((getProprietario()==null) && peao.getJogador().podeComprarTerreno((Propriedade) this)){
            System.out.println("Jogador: "+ peao.getJogador().getNome()+" \nSaldo: "+peao.getJogador().getSaldo());
            System.out.println( getNome()+" \nPosição:"+ getPosicao());
            System.out.println("Você pode comprar essa propriedade, deseja fazer isso ? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s")){
                peao.getJogador().comprarTerreno((Propriedade) this);
            }
            
    // SE O TERRENO NA POSIÇÃO ATUAL É DO JOGADOR ATUAL
       }else if(getProprietario()==peao.getJogador()){
            System.out.println("Jogador: "+peao.getJogador().getNome()+" \nSaldo: "+peao.getJogador().getSaldo());
            System.out.println(getNome()+" \nPosição:"+getPosicao());

            System.out.println("Essa propriedade é sua, deseja comprar um imovel ? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("s") && peao.getJogador().podeComprarImovel((Propriedade) this)){
                peao.getJogador().comparImovel((Propriedade) this);
            }
       }
    //    PAGAR ALUGUEL
       else if((getProprietario()!=null)&&(getProprietario()!=peao.getJogador())){
            peao.getJogador().pagarAluguel((Propriedade) this);
        }
    }
}
