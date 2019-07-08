package com.logic.cardboardbox.utils;

public enum TipoTransporteEnum {
    NENHUM(0L),
    AEREO(1L),
    TERRESTRE(2L);

    private Long tipoTransporte;

    TipoTransporteEnum(Long tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Long getTipoTransporte() {
        return tipoTransporte;
    }

    public static TipoTransporteEnum getTipo(int tipo) {
        switch (tipo) {
            case 1:
                return AEREO;
            case 2:
                return TERRESTRE;
            default:
                return NENHUM;
        }
    }
}
