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
            System.out.printf("A jogada da vez é de %s:\n",peaoVez().getNomeJogador());
            peaoVez().getComandos();
            System.out.print("Digite um dos comandos: ");
            String comando = scanner.nextLine();

            // Implementar padrão command
            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Deseja continuar jogando? (s/n): ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("n")) {
                    peaos.remove(jogador_da_vez);
                }else {
                    alterar_jogador_da_vez();
                }
            } else if (comando.equalsIgnoreCase("jogar")) {
                tabuleiro.jogar(peaos.get(jogador_da_vez));
                alterar_jogador_da_vez();
            } else if (comando.equalsIgnoreCase("status")) {
                Peao peao = peaos.get(jogador_da_vez);
                peao.getStatus(tabuleiro);
            }
        }
        limparTerminal();
        System.out.println("O jogo acabou!");
        System.out.printf("%s ganhou o jogo!!\n",peaoGanhador().getNomeJogador());
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

    public Peao peaoGanhador() {
        return peaos.get(0);
    }

}
