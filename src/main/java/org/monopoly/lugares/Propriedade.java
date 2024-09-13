package org.monopoly.lugares;

import java.util.Scanner;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;
import org.monopoly.jogo.Jogador;
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

    public int getHipoteca() {return hipoteca;}

    @Override
    public void venderLugar(Jogador jogadorComprador){
        jogadorComprador.comprarTerreno((Propriedade) this);
    }

    public void venderCasa(Jogador jogadorComprador){
        jogadorComprador.comparImovel(this);
    }

    @Override
    public void ofertarVendaLugar(Jogador jogador){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jogador: "+ jogador.getNome()+" \nSaldo: "+jogador.getSaldo());
        System.out.println( getNome()+" \nPosição:"+ getPosicao());
        System.out.println("Você pode comprar essa propriedade, deseja fazer isso ? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")){
            venderLugar(jogador);
        }
    }

    public void ofertarVenderCasa(Jogador jogador){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jogador: "+jogador.getNome()+" \nSaldo: "+jogador.getSaldo());
        System.out.println(getNome()+" \nPosição:"+getPosicao());
        System.out.println("Essa propriedade é sua, deseja comprar um imovel ? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s") && jogador.podeComprarImovel((Propriedade) this)){
            jogador.comparImovel((Propriedade) this);
        }
    }

    @Override
    public void executarAcao(Peao peao) {
        
    //    SE O TERRENO NÃO TEM DONO E O JOGADOR PODE COMPRAR 
       if((getProprietario()==null) && peao.getJogador().podeComprarTerreno((Propriedade) this)){
            ofertarVendaLugar(peao.getJogador());
            
    // SE O TERRENO NA POSIÇÃO ATUAL É DO JOGADOR ATUAL
       }else if(getProprietario()==peao.getJogador()){
            ofertarVenderCasa(peao.getJogador());
       }
    //    PAGAR ALUGUEL
       else if((getProprietario()!=null)&&(getProprietario()!=peao.getJogador())){
            peao.getJogador().pagarAluguelPropriedade((Propriedade) this);
        }
    }
}
