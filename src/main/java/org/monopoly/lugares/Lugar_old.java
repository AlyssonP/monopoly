package org.monopoly.lugares;

import org.monopoly.CorLugar;
import org.monopoly.jogo.Jogador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lugar_old {
    private int posicao;
    private String endereco;
    private float preco_inicial;
    private float aluguel_sem_casa;
    private float aluguel_casa_um;
    private float aluguel_casa_dois;
    private float aluguel_casa_tres;
    private float aluguel_casa_quatro;
    private float aluguel_hotel;
    private float hipoteca;
    private float preco_comprar_casa;
    private Jogador proprietario;
    private CorLugar corlugar;

    public Lugar_old(int posicao, String endereco, float preco_inicial, float aluguel_sem_casa,
                     float aluguel_casa_um, float aluguel_casa_dois, float aluguel_casa_tres,
                     float aluguel_casa_quatro, float aluguel_hotel, float hipoteca,
                     float preco_comprar_casa, CorLugar corlugar) {
        this.posicao = posicao;
        this.endereco = endereco;
        this.preco_inicial = preco_inicial;
        this.aluguel_sem_casa = aluguel_sem_casa;
        this.aluguel_casa_um = aluguel_casa_um;
        this.aluguel_casa_dois = aluguel_casa_dois;
        this.aluguel_casa_tres = aluguel_casa_tres;
        this.aluguel_casa_quatro = aluguel_casa_quatro;
        this.aluguel_hotel = aluguel_hotel;
        this.hipoteca = hipoteca;
        this.preco_comprar_casa = preco_comprar_casa;
        this.corlugar = corlugar;
    }

    public Lugar_old(int posicao, String endereco){
        this.posicao = posicao;
        this.endereco = endereco;
    }

    public Lugar_old(){
    }

    @Override
    public String toString() {
        return "Lugar{" + '\''+
                "posicao=" + posicao + '\''+
                ", endereco='" + endereco + '\'' +
                ", preco_inicial=" + preco_inicial+ '\'' +
                ", aluguel_sem_casa=" + aluguel_sem_casa+ '\'' +
                ", aluguel_casa_um=" + aluguel_casa_um+ '\'' +
                ", aluguel_casa_dois=" + aluguel_casa_dois+ '\'' +
                ", aluguel_casa_tres=" + aluguel_casa_tres+ '\'' +
                ", aluguel_casa_quatro=" + aluguel_casa_quatro+ '\'' +
                ", aluguel_hotel=" + aluguel_hotel + '\''+
                ", hipoteca=" + hipoteca + '\''+
                ", preco_comprar_casa=" + preco_comprar_casa+ '\'' +
                ", Cor=" + corlugar+ '\'' +
                '}';
    }


    public List<Lugar_old> criarLugares(){
        String arquivoCSV = "./monopoly_properties.csv";
        String linha;
        List<Lugar_old> lugares = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            
            String cabecalho = br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    try {
                        
                     
                        // Tenta obter a cor se ela existir
                        CorLugar corLugar = valores.length > 11 ? CorLugar.valueOf(valores[11].trim().toUpperCase()) : CorLugar.BRANCO;
                        
                        // faz parsing dos campos numericos
                        float preco = !valores[2].isEmpty() ? Float.parseFloat(valores[2]) : 0;
                        float aluguelSemCasa = valores.length > 3 && !valores[3].isEmpty() ? Float.parseFloat(valores[3]) : 0;
                        float umaCasa = valores.length > 4 && !valores[4].isEmpty() ? Float.parseFloat(valores[4]) : 0;
                        float duasCasas = valores.length > 5 && !valores[5].isEmpty() ? Float.parseFloat(valores[5]) : 0;
                        float tresCasas = valores.length > 6 && !valores[6].isEmpty() ? Float.parseFloat(valores[6]) : 0;
                        float quatroCasas = valores.length > 7 && !valores[7].isEmpty() ? Float.parseFloat(valores[7]) : 0;
                        float hotel = valores.length > 8 && !valores[8].isEmpty() ? Float.parseFloat(valores[8]) : 0;
                        float hipoteca = valores.length > 9 && !valores[9].isEmpty() ? Float.parseFloat(valores[9]) : 0;
                        float precoCasa = valores.length > 10 && !valores[10].isEmpty() ? Float.parseFloat(valores[10]) : 0;
    
                        Lugar_old lugar = new Lugar_old(
                            Integer.parseInt(valores[0]),
                            valores[1],
                            preco,
                            aluguelSemCasa,
                            umaCasa,
                            duasCasas,
                            tresCasas,
                            quatroCasas,
                            hotel,
                            hipoteca,
                            precoCasa,
                            corLugar
                        );
                    lugares.add(lugar);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Lugar_old lugar = new Lugar_old( Integer.parseInt(valores[0]), valores[1]);
                    lugares.add(lugar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lugares;
    }

    public float getPrecoInicial(){
        return this.preco_inicial;
    }

    public void setProprietario(Jogador proprietario){
        this.proprietario = proprietario;
    }

    public Jogador getProprietario(){
        return this.proprietario;
    }
}
