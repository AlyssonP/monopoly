package org.monopoly.lugares.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.monopoly.lugares.Canto;
import org.monopoly.lugares.Lugar;


public class LugarRepository {
    
    public static final BufferedReader lerCsv(String caminho) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(caminho));
            String cabecalho = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    public final ArrayList<Lugar> iniciar(){
        ArrayList<Lugar> lugares = new ArrayList<>();
        PropriedadesRepository.iniciarPropriedades("./csv/propriedades_coloridas.csv", lugares);
        CofreComunitarioRepository.iniciarCofresComunitarios("./csv/cofres_comunitarios.csv", lugares);
        FerroviaRepository.iniciarFerrovias("./csv/ferrovias.csv", lugares);
        ServicoPublicoRepository.iniciarServicoPublico("./csv/servico_publico.csv", lugares);
        SorteRevesRepository.inciarSorteReves("./csv/sorte_reves.csv", lugares);
        CantoRepository.iniciarCantos(lugares);
        ImpostoRepository.iniciarImposto(lugares);
        return lugares;
    }
}
