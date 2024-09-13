package org.monopoly.lugares.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.SorteReves;

public class SorteRevesRepository extends LugarRepository{

    public static ArrayList<Lugar> inciarSorteReves(String caminho, ArrayList<Lugar> lugares){
        String linha;
        try (BufferedReader br = lerCsv(caminho)) {
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        int posicao = Integer.parseInt(valores[0].trim());
                        String nome = valores[1].trim();
                        SorteReves sorteReves = new SorteReves(nome, posicao);
                        lugares.add(sorteReves);
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
