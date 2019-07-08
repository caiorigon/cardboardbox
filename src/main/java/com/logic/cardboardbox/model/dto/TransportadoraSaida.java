package com.logic.cardboardbox.model.dto;

import com.logic.cardboardbox.utils.TipoTransporteEnum;

import java.io.Serializable;

public class TransportadoraSaida implements Serializable {

    private String nome;

    private TipoTransporteEnum tipoTransporte;

    private Double tempo;

    private String unidadeTempo;

    private Double Preco;

    private Long distancia;

    public String getNome() {
        return nome;
    }

    public TransportadoraSaida setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoTransporteEnum getTipoTransporte() {
        return tipoTransporte;
    }

    public TransportadoraSaida setTipoTransporte(TipoTransporteEnum tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }

    public Double getTempo() {
        return tempo;
    }

    public TransportadoraSaida setTempo(Double tempo) {
        this.tempo = tempo;
        return this;
    }

    public String getUnidadeTempo() {
        return unidadeTempo;
    }

    public TransportadoraSaida setUnidadeTempo(String unidadeTempo) {
        this.unidadeTempo = unidadeTempo;
        return this;
    }

    public Double getPreco() {
        return Preco;
    }

    public TransportadoraSaida setPreco(Double preco) {
        Preco = preco;
        return this;
    }

    public Long getDistancia() {
        return distancia;
    }

    public TransportadoraSaida setDistancia(Long distancia) {
        this.distancia = distancia;
        return this;
    }
}
