package org.monopoly.lugares;

import org.monopoly.jogo.Dados;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;
import java.util.Scanner;

public class ServicoPublico extends Lugar {
    private int preco;
    private int hipoteca;

    public ServicoPublico(String nome, int posicao, int preco, int hipoteca) {
        super(nome, posicao);
        this.preco = preco;
        this.hipoteca = hipoteca;
    }

    public int getPreco() { return preco; }

    public void setPreco(int preco) { this.preco = preco;}

    public int getHipoteca() { return hipoteca; }

    public void setHipoteca(int hipoteca) { this.hipoteca = hipoteca; }

    @Override
    public void venderLugar(Jogador jogadorComprador){
        jogadorComprador.comprarServicoPublico(this);
    }

    @Override
    public void ofertarVendaLugar(Jogador jogador){
        System.out.println("Serviço publico "+getNome()+" esta disponivel por "+getPreco());
            System.out.println("Deseja comprar? (s/n)");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();
            if(resposta.equalsIgnoreCase("s")){
                venderLugar(jogador);
            }
    }

    @Override
    public void executarAcao(Peao peao) {
        if(getProprietario()==null){
            ofertarVendaLugar(peao.getJogador());
        }else{
            Dados dados = new Dados();
            int[] numeros = dados.jogarDados();
            System.out.println("Você pagará o valor (aluguel x numero do dado)");
            System.out.println("Você pagará "+getPreco()*numeros[1]+" à "+getProprietario().getNome());
            System.out.println("Aluguel: "+getPreco());
            System.out.println("Numero do dado:"+numeros[1]);
            peao.getJogador().pagarAluguelServicoPublico(this);
        }
    }
}
