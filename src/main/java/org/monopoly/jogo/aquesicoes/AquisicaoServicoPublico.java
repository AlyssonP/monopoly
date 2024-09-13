package org.monopoly.jogo.aquesicoes;

import org.monopoly.jogo.Aquisicao;
import org.monopoly.lugares.ServicoPublico;

public class AquisicaoServicoPublico extends Aquisicao {
    public AquisicaoServicoPublico(ServicoPublico servicoPublico) {
        super(servicoPublico.getPreco(), servicoPublico.getHipoteca());
    }
}
