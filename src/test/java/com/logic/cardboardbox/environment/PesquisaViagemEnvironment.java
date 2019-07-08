package com.logic.cardboardbox.environment;

import com.logic.cardboardbox.model.dto.PesquisaViagem;
import com.logic.cardboardbox.utils.PrioridadeEnum;

public class PesquisaViagemEnvironment {
    public static PesquisaViagem criarPesquisaViagemPrecoSemTipo() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.PRECO);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemTempoSemTipo() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.TEMPO);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemPrecoAereo() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.PRECO);
        pesquisaViagem.setTipoTransporte(1L);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemTempoAereo() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.TEMPO);
        pesquisaViagem.setTipoTransporte(1L);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemPrecoTerrestre() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.PRECO);
        pesquisaViagem.setTipoTransporte(2L);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemTempoTerrestre() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setOrigem("A");
        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.TEMPO);
        pesquisaViagem.setTipoTransporte(2L);

        return pesquisaViagem;
    }

    public static PesquisaViagem criarPesquisaViagemSemOrigem() {
        PesquisaViagem pesquisaViagem = new PesquisaViagem();

        pesquisaViagem.setDestino("B");
        pesquisaViagem.setDistancia(1000L);
        pesquisaViagem.setPrioridade(PrioridadeEnum.TEMPO);
        pesquisaViagem.setTipoTransporte(2L);

        return pesquisaViagem;
    }
}
