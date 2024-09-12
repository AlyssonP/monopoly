package org.monopoly.lugares;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Cor;

public class LugarRepository {
    
    public BufferedReader lerCsv(String caminho) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(caminho));
            String cabecalho = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    public ArrayList<Lugar> iniciarCofresComunitarios(String caminho, ArrayList<Lugar> lugares){
        String linha;
        try (BufferedReader br = lerCsv(caminho)) {
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        int posicao = Integer.parseInt(valores[0].trim());
                        String nome = valores[1].trim();
                        CofreComunitario cofreComunitario = new CofreComunitario(nome, posicao);
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

    public ArrayList<Lugar> iniciarFerrovias(String caminho, ArrayList<Lugar> lugares){
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

    public ArrayList<Lugar> iniciarServicoPublico(String caminho, ArrayList<Lugar> lugares){
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
    
    public ArrayList<Lugar> iniciarPropriedades(String caminho, ArrayList<Lugar> lugares){
        String linha;
        try (BufferedReader br = lerCsv(caminho)) {
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

    public ArrayList<Lugar> iniciar(){
        ArrayList<Lugar> lugares = new ArrayList<>();
        iniciarPropriedades("./csv/propriedades_coloridas.csv", lugares);
        iniciarCofresComunitarios("./csv/cofres_comunitarios.csv", lugares);
        iniciarFerrovias("./csv/ferrovias.csv", lugares);
        iniciarServicoPublico("./csv/servico_publico.csv", lugares);
        return lugares;
    }
}
