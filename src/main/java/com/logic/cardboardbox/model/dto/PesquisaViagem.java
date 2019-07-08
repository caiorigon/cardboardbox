package com.logic.cardboardbox.model.dto;

import com.logic.cardboardbox.utils.PrioridadeEnum;

import java.io.Serializable;

public class PesquisaViagem implements Serializable {
    private String origem;
    private String destino;
    private Long distancia;
    private PrioridadeEnum prioridade;
    private Long tipoTransporte;

    public String getOrigem() {
        return origem;
    }

    public PesquisaViagem setOrigem(String origem) {
        this.origem = origem;
        return this;
    }

    public String getDestino() {
        return destino;
    }

    public PesquisaViagem setDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public Long getDistancia() {
        return distancia;
    }

    public PesquisaViagem setDistancia(Long distancia) {
        this.distancia = distancia;
        return this;
    }

    public PrioridadeEnum getPrioridade() {
        return prioridade;
    }

    public PesquisaViagem setPrioridade(PrioridadeEnum prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public Long getTipoTransporte() {
        return tipoTransporte;
    }

    public PesquisaViagem setTipoTransporte(Long tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }
}
