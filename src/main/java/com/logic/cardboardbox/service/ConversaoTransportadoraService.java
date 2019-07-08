package com.logic.cardboardbox.service;

import com.logic.cardboardbox.model.dto.Transportadora;
import com.logic.cardboardbox.model.dto.TransportadoraSaida;
import com.logic.cardboardbox.utils.TipoTransporteEnum;
import org.springframework.stereotype.Service;

@Service
public class ConversaoTransportadoraService {

    public TransportadoraSaida converterParaSaida(Transportadora transportadora, Long distancia) {
        TransportadoraSaida transportadoraSaida = new TransportadoraSaida();

        transportadoraSaida.setNome(transportadora.getNome());
        transportadoraSaida.setTipoTransporte(TipoTransporteEnum.getTipo(transportadora.getTipoTransporte().getTipoTransporte().intValue()));
        transportadoraSaida.setDistancia(distancia);

        double tempo = transportadora.getTipoTransporte().getTempo() * distancia;
        if (tempo > 60) {
            transportadoraSaida.setTempo(tempo/60);
            transportadoraSaida.setUnidadeTempo("minutos");
        } else {
            transportadoraSaida.setTempo(tempo);
            transportadoraSaida.setUnidadeTempo("segundos");
        }

        transportadoraSaida.setPreco((transportadora.getTipoTransporte().getValor() * distancia) / 10);

        return transportadoraSaida;
    }
}
