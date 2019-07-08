package com.logic.cardboardbox.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class Transportadora implements Serializable {

    private int id;
    private String nome;

    private TipoTransporte tipoTransporte;

    public int getId() {
        return id;
    }

    public Transportadora setId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Transportadora setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoTransporte getTipoTransporte() {
        return tipoTransporte;
    }

    public Transportadora setTipoTransporte(TipoTransporte tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora that = (Transportadora) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
