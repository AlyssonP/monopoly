package org.monopoly.lugares.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.monopoly.lugares.Ferrovia;
import org.monopoly.lugares.Lugar;

public class FerroviaRepository extends LugarRepository{
    
    public static ArrayList<Lugar> iniciarFerrovias(String caminho, ArrayList<Lugar> lugares){
        String linha;
        try (BufferedReader br = lerCsv(caminho)) {
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        int posicao = Integer.parseInt(valores[0].trim());
                        String nome = valores[1].trim();
                        int preco = Integer.parseInt(valores[2].trim());
                        int hipoteca = Integer.parseInt(valores[9].trim());
                        Ferrovia ferrovia = new Ferrovia(nome, posicao,preco,hipoteca);
                        lugares.add(ferrovia);
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
