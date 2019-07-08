package com.logic.cardboardbox.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class TipoTransporte implements Serializable {

    private Long tipoTransporte;

    private Integer tempo;

    private Double valor;

    public Long getTipoTransporte() {
        return tipoTransporte;
    }

    public TipoTransporte setTipoTransporte(Long tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }

    public Integer getTempo() {
        return tempo;
    }

    public TipoTransporte setTempo(Integer tempo) {
        this.tempo = tempo;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public TipoTransporte setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTransporte that = (TipoTransporte) o;
        return Objects.equals(tipoTransporte, that.tipoTransporte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTransporte);
    }
}
