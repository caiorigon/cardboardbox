package com.logic.cardboardbox.environment;

import com.logic.cardboardbox.model.entity.Transportadora1Entity;

import java.util.List;

public class Transportadora1EntityEnvironment {

    public static List<Transportadora1Entity> criarListTransportadora1Entities() {
        return List.of(criarTransportadora1Entity());
    }

    public static Transportadora1Entity criarTransportadora1Entity() {
        Transportadora1Entity transportadora1Entity = new Transportadora1Entity();
        transportadora1Entity.setTempo(5);
        transportadora1Entity.setValor(5.0);
        transportadora1Entity.setTipoTransporte(2L);

        return transportadora1Entity;
    }
}
