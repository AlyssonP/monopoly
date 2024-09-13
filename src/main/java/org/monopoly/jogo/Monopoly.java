package org.monopoly.jogo;

import java.util.ArrayList;
import java.util.Scanner;

import static org.monopoly.GerenciamentoScanner.limparTerminal;

public class Monopoly {
    private ArrayList<Peao> peaos;
    private Tabuleiro tabuleiro;
    private int jogador_da_vez = 0;

    public Monopoly() {
        peaos = new ArrayList<>();
        tabuleiro = new Tabuleiro();
    }

    public void addPeao(Jogador jogador) {peaos.add(new Peao(jogador, 0));}

    public void jogar(){
        Scanner scanner = new Scanner(System.in);
        while (peaos.size() > 1) {
            peaoVez().getComandos();

            tabuleiro.jogar(peaos.get(jogador_da_vez));

            System.out.println("Deseja continuar jogando? (s/n): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                peaos.remove(jogador_da_vez);
            }

            limparTerminal();
            alterar_jogador_da_vez();
        }
        System.out.println("O jogo acabou!");
        scanner.close();
    }

    public Peao peaoVez() {
        return peaos.get(jogador_da_vez);
    }

    public void alterar_jogador_da_vez(){
        if (this.jogador_da_vez == this.peaos.size()-1){
            this.jogador_da_vez = 0;
        }else{
            this.jogador_da_vez += 1;
        }
    }

}
