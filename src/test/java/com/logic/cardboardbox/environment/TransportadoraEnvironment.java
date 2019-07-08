package com.logic.cardboardbox.environment;

import com.logic.cardboardbox.model.dto.TipoTransporte;
import com.logic.cardboardbox.model.dto.Transportadora;

import java.util.List;

public class TransportadoraEnvironment {
    public static Transportadora criarTransportadoraAerea() {
        Transportadora transportadora = new Transportadora();

        transportadora.setId(3);
        transportadora.setNome("t3");
        transportadora.setTipoTransporte(new TipoTransporte()
        .setValor(10.00)
        .setTempo(10)
        .setTipoTransporte(1L));

        return transportadora;
    }

    public static Transportadora criarTransportadoraTerrestre() {
        Transportadora transportadora = new Transportadora();

        transportadora.setId(2);
        transportadora.setNome("t2");
        transportadora.setTipoTransporte(new TipoTransporte()
                .setValor(12.00)
                .setTempo(8)
                .setTipoTransporte(2L));

        return transportadora;
    }

    public static List<Transportadora> criarTransportadoraAereaTerrestre() {
        Transportadora transportadora = new Transportadora();

        transportadora.setId(4);
        transportadora.setNome("t4");
        transportadora.setTipoTransporte(new TipoTransporte()
                .setValor(25.00)
                .setTempo(8)
                .setTipoTransporte(1L));

        Transportadora transportadora2 = new Transportadora();

        transportadora2.setId(4);
        transportadora2.setNome("t4");
        transportadora2.setTipoTransporte(new TipoTransporte()
                .setValor(3.00)
                .setTempo(15)
                .setTipoTransporte(2L));

        return List.of(transportadora, transportadora2);
    }
}
