package org.monopoly.lugares.repository;

import java.util.ArrayList;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.cantos.ParadaLivre;
import org.monopoly.lugares.cantos.PontoPartida;
import org.monopoly.lugares.cantos.Prisao;
import org.monopoly.lugares.cantos.VaiParaPrisao;

public class CantoRepository {
    
    public static void iniciarCantos(ArrayList<Lugar> lugares){
        ParadaLivre paradaLivre = new ParadaLivre("Free Parking", 20);
        PontoPartida pontoPartida = new PontoPartida("go", 40);
        Prisao prisao = new Prisao("Jail – Just Visiting", 10);
        VaiParaPrisao vaiParaPrisao = new VaiParaPrisao("Go to Jail", 30);
        lugares.add(paradaLivre);
        lugares.add(pontoPartida);
        lugares.add(prisao);
        lugares.add(vaiParaPrisao);
    }
}
