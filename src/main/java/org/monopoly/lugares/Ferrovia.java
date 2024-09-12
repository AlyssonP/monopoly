package org.monopoly.lugares;

import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Peao;

import java.util.Scanner;

public class Ferrovia extends Lugar{
    private int valor;
    private int hipoteca;

    public Ferrovia(String nome, int posicao, int valor, int hipoteca) {
        super(nome, posicao);
        this.valor = valor;
        this.hipoteca = hipoteca;
    }

    public int getValor() {return valor;}

    public int getHipoteca() { return  hipoteca;}

    @Override
    public void venderLugar(Jogador jogadorComprador) {
        jogadorComprador.comprarFerrovia(this);
    }

    @Override
    public void ofertarVendaLugar(Jogador jogador) {
        System.out.printf("A título da ferrovia %s está disponível por %d.\n",getNome(),valor);
        System.out.printf("%s, você possui $ %.2f\n",jogador.getNome(), jogador.getSaldo());
        System.out.printf("Você deseja comprar %s (s/n)? ",getNome());
        Scanner scanner = new Scanner(System.in);
        String op = scanner.nextLine();
        if(op.equalsIgnoreCase("s")){
            venderLugar(jogador);
        }
    }

    @Override
    public void executarAcao(Peao peao) {
        if(getProprietario() != null) {
            System.out.println("Está ferrovia tem proprietário.");
            int taxa = 25;
            getProprietario().acrescentarSaldo(taxa);
            System.out.printf("Você teve que pagar uma taxa de %d para %s.\n", taxa, getProprietario().getNome());
        } else {
            ofertarVendaLugar(peao.getJogador());
        }
    }
}
