package com.logic.cardboardbox.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "transportadora1")
public class Transportadora1Entity implements Serializable {

    @Id
    private Long tipoTransporte;
    @Column(name = "tempo")
    private Integer tempo;
    @Column(name = "valor")
    private Double valor;

    public Long getTipoTransporte() {
        return tipoTransporte;
    }

    public Transportadora1Entity setTipoTransporte(Long tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }

    public Integer getTempo() {
        return tempo;
    }

    public Transportadora1Entity setTempo(Integer tempo) {
        this.tempo = tempo;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Transportadora1Entity setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora1Entity that = (Transportadora1Entity) o;
        return tipoTransporte.equals(that.tipoTransporte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoTransporte);
    }
}
