package com.logic.cardboardbox.utils;

public enum PrioridadeEnum {
    PRECO("P"),
    TEMPO("T");

    private String prioridade;

    PrioridadeEnum(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getPrioridade() {
        return prioridade;
    }
}
