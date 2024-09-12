package org.monopoly.lugares;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;

public class PropriedadeRepository {
    
    public ArrayList<Lugar> iniciar(){
        String arquivoCSV = "./monopoly_properties.csv";
        String linha;
        ArrayList<Lugar> lugares = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            
            String cabecalho = br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        int posicao = Integer.parseInt(valores[0].trim());
                        String nome = valores[1].trim();
                        int preco = Integer.parseInt(valores[2]);
                        int[] aluguel = {
                            Integer.parseInt(valores[3]),
                            Integer.parseInt(valores[4]),
                            Integer.parseInt(valores[5]),
                            Integer.parseInt(valores[6]),
                            Integer.parseInt(valores[7]),
                            Integer.parseInt(valores[8])
                        };
                        int hipoteca = Integer.parseInt(valores[9].trim());
                        int precoCasa = Integer.parseInt(valores[10].trim());
                        
                        CorLugar cor = CorLugar.valueOf(valores[11].trim());
    
                        Propriedade propriedade = new Propriedade(nome, posicao, cor, preco, aluguel, hipoteca, precoCasa);
                        lugares.add(propriedade);
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
