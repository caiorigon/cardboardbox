package com.logic.cardboardbox.environment;

import com.logic.cardboardbox.model.dto.TransportadoraSaida;
import com.logic.cardboardbox.utils.TipoTransporteEnum;

public class TransportadoraSaidaEnvironment {
    public static TransportadoraSaida criarTransportadoraSaida() {
        TransportadoraSaida transportadoraSaida = new TransportadoraSaida();

        transportadoraSaida.setDistancia(1000L);
        transportadoraSaida.setPreco(10.00);
        transportadoraSaida.setUnidadeTempo("minutos");
        transportadoraSaida.setNome("tsaida");
        transportadoraSaida.setTempo(200.00);
        transportadoraSaida.setTipoTransporte(TipoTransporteEnum.AEREO);

        return transportadoraSaida;
    }
}
