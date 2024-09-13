package org.monopoly.lugares.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.ServicoPublico;

public class ServicoPublicoRepository extends LugarRepository{
    
    public static ArrayList<Lugar> iniciarServicoPublico(String caminho, ArrayList<Lugar> lugares){
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
                        ServicoPublico servicoPublico = new ServicoPublico(nome, posicao,preco,hipoteca);
                        lugares.add(servicoPublico);
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
