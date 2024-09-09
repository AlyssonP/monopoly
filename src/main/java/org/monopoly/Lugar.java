package org.monopoly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lugar {
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

    public Lugar(int posicao, String endereco, float preco_inicial, float aluguel_sem_casa,
                float aluguel_casa_um, float aluguel_casa_dois, float aluguel_casa_tres,
                float aluguel_casa_quatro, float aluguel_hotel, float hipoteca,
                float preco_comprar_casa) {
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
    }

    public Lugar(int posicao, String endereco){
        this.posicao = posicao;
        this.endereco = endereco;
    }

    public Lugar(){
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "posicao=" + posicao +
                ", endereco='" + endereco + '\'' +
                ", preco_inicial=" + preco_inicial +
                ", aluguel_sem_casa=" + aluguel_sem_casa +
                ", aluguel_casa_um=" + aluguel_casa_um +
                ", aluguel_casa_dois=" + aluguel_casa_dois +
                ", aluguel_casa_tres=" + aluguel_casa_tres +
                ", aluguel_casa_quatro=" + aluguel_casa_quatro +
                ", aluguel_hotel=" + aluguel_hotel +
                ", hipoteca=" + hipoteca +
                ", preco_comprar_casa=" + preco_comprar_casa +
                '}';
    }


    public List<Lugar> criarLugares(){
        String arquivoCSV = "./monopoly_properties.csv";
        String linha;
        List<Lugar> lugares = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            
            String cabecalho = br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(",");
                if (valores.length >= 11) {
                    Lugar lugar = new Lugar(
                        Integer.parseInt(valores[0]),
                        valores[1],
                        Float.parseFloat(valores[2]),
                        Float.parseFloat(valores[3]),
                        Float.parseFloat(valores[4]),
                        Float.parseFloat(valores[5]),
                        Float.parseFloat(valores[6]),
                        Float.parseFloat(valores[7]),
                        Float.parseFloat(valores[8]),
                        Float.parseFloat(valores[9]),
                        Float.parseFloat(valores[10])
                    );
                    lugares.add(lugar);
                } else {
                    Lugar lugar = new Lugar( Integer.parseInt(valores[0]), valores[1]);
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
