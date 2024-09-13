package org.monopoly.cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.monopoly.jogo.Tabuleiro;

import java.util.Collections;

public class CartaRepository {
    

    public static ArrayList<Carta> iniciar(String caminho, ArrayList<Carta> lista){
        String arquivoCSV = caminho;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] colunas = linha.split(",");
                try {
                    int numero = Integer.parseInt(colunas[0].trim());
                    String nome = colunas[1].trim();
                    String descricao = colunas[2].trim();
    
                    if (colunas.length > 4) {
                        RegraPagemento regraPagamento = RegraPagemento.valueOf(colunas[3].trim());
                        int valor = Integer.parseInt(colunas[4].trim());
                        Pagamento pagamento = new Pagamento(numero, nome, descricao, regraPagamento, valor);
                        lista.add(pagamento);
                    }  
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao processar a linha: " + linha + ". " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        embaralharCartas(lista);
        return lista;
    }


    public static void embaralharCartas(ArrayList<Carta> cartas) {
        Collections.shuffle(cartas);
    }
}
