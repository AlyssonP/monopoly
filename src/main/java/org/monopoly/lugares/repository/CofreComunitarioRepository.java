package org.monopoly.lugares.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.monopoly.jogo.Tabuleiro;
import org.monopoly.lugares.CofreComunitario;
import org.monopoly.lugares.Lugar;

public class CofreComunitarioRepository extends LugarRepository{
    
    public static ArrayList<Lugar> iniciarCofresComunitarios(String caminho, ArrayList<Lugar> lugares, Tabuleiro tabuleiro){
        String linha;
        try (BufferedReader br = lerCsv(caminho)) {
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        int posicao = Integer.parseInt(valores[0].trim());
                        String nome = valores[1].trim();
                        CofreComunitario cofreComunitario = new CofreComunitario(nome, posicao, tabuleiro);
                        lugares.add(cofreComunitario);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return lugares; 
    }
}
