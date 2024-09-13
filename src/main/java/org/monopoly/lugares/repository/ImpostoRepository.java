package org.monopoly.lugares.repository;

import java.util.ArrayList;

import org.monopoly.lugares.Imposto;
import org.monopoly.lugares.Lugar;
import org.monopoly.lugares.TipoImposto;

public class ImpostoRepository extends LugarRepository{
    
    public static void iniciarImposto(ArrayList<Lugar> lugares){
        TipoImposto tipoRenda = TipoImposto.RENDA;
        TipoImposto tipoRiqueza = TipoImposto.RIQUEZA;
        Imposto impostoRenda = new Imposto("income tax", 4, tipoRenda);
        Imposto impostoRiqueza = new Imposto("luxury tax", 38, tipoRiqueza);
        lugares.add(impostoRenda);
        lugares.add(impostoRiqueza);
    }
}
