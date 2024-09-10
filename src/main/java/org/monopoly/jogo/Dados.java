package org.monopoly.jogo;

import java.util.Random;

public class Dados {
    
    public Dados(){
    }

    public int[] jogarDados(){
        Random random = new Random();
        int dado_um = random.nextInt(6)+1;
        int dado_dois = random.nextInt(6)+1;
        return new int[] {dado_um, dado_dois, dado_um+dado_dois};
    }
}
