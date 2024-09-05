package org.monopoly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly();

        Jogador jogador1 = new Jogador("wedson", Cor.ROSA);
        Jogador jogador2 = new Jogador("alysson", Cor.PRETO);

        monopoly.addJogador(jogador1);
        monopoly.addJogador(jogador2);

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            monopoly.jogar();

            System.out.println("Deseja continuar jogando? (s/n): ");
            String resposta = scanner.nextLine();
            
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        System.out.println("O jogo acabou!");
        scanner.close();
    }

}
