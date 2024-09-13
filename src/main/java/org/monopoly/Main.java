package org.monopoly;

import org.monopoly.jogo.Cor;
import org.monopoly.jogo.Jogador;
import org.monopoly.jogo.Monopoly;
import org.monopoly.lugares.CofreComunitario;
import org.monopoly.lugares.SorteReves;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com a quantidade de jogadores [2-8]: ");
        int nJogadores = scanner.nextInt();
        scanner.nextLine();

        if (nJogadores < 2 || nJogadores > 8) {
            System.out.println("A quantidade jogadores é inválido. O jogo é necessita de 2 a 8 jogadores.");
            return;
        }

        List<Cor> coresDisponiveis = List.of(Cor.PRETO, Cor.BRANCO, Cor.VERMELHO, Cor.VERDE, Cor.AZUL, Cor.AMARELO, Cor.LARANJA, Cor.ROSA);
        List<Cor> coresUtilizadas = new ArrayList<>();

        for (int i = 1; i <= nJogadores; i++) {
            System.out.printf("Digite o nome do jogador %d : ", i);
            String nome = scanner.nextLine();

            System.out.printf("Jogador %s escolha uma das cores diponíveis abaixo:\n", nome);
            for (Cor cor : coresDisponiveis) {
                if (!coresUtilizadas.contains(cor)) {
                    System.out.printf("[%s]", cor);
                }
            }
            System.out.println();

            boolean deveContinuar = false;
            Cor corEscolhida = null;
            do {
                String corInput = scanner.nextLine().toUpperCase();
                try {
                    corEscolhida = Cor.valueOf(corInput);
                    if (coresUtilizadas.contains(corEscolhida)) {
                        System.out.println("Está cor já está em utilização.");
                    } else {
                        coresUtilizadas.add(corEscolhida);
                        deveContinuar = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Esta cor é inválida, escolha o que contém na lista.");
                }
            } while (!deveContinuar);

            monopoly.addPeao(new Jogador(nome, corEscolhida));
        }

        monopoly.jogar();
        scanner.close();
        GerenciamentoScanner.limparTerminal();
    }
}
