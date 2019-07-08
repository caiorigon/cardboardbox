package com.logic.cardboardbox.controller;

import com.logic.cardboardbox.model.dto.TipoTransporte;
import com.logic.cardboardbox.model.dto.Transportadora;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class Transportadora2Controller {

    private static final Logger log = LoggerFactory.getLogger(Transportadora2Controller.class);

    public List<Transportadora> recuperarDados() {
        RestTemplate restTemplate = new RestTemplate();
        List<Transportadora> transportadora2 = new ArrayList<>();

        try {

            ResponseEntity<List<TipoTransporte>> response = restTemplate.exchange(
                    "http://localhost:8090/transportadora2/service/transportadora",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<TipoTransporte>>() {
                    });


            if (response.getBody() != null) {
                response.getBody().forEach(tipoTransporte -> {
                    Transportadora transportadora = new Transportadora();
                    transportadora.setId(2);
                    transportadora.setNome("transportadora2");
                    transportadora.setTipoTransporte(tipoTransporte);
                    transportadora2.add(transportadora);
                });

                return transportadora2;
            }

        } catch (Exception e) {
            log.error("\n\nErro ao tentar recuperar informações da transportadora 2\n" + e.getMessage());
        }
        return transportadora2;
    }
}