package org.monopoly.cartas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartaRepository {
    

    public ArrayList<Carta> iniciar(String caminho){
        String arquivoCSV = caminho;

        ArrayList<Carta> lista = new ArrayList<>();

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
                        System.out.println(colunas[3].trim());
                        System.out.println(colunas[4].trim());
                        lista.add(pagamento);
                    }  
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao processar a linha: " + linha + ". " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
