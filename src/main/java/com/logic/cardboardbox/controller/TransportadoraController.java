package com.logic.cardboardbox.controller;

import com.logic.cardboardbox.TransportadoraService;
import com.logic.cardboardbox.model.dto.PesquisaViagem;
import com.logic.cardboardbox.model.dto.Transportadora;
import com.logic.cardboardbox.model.dto.TransportadoraSaida;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transportadora")
public class TransportadoraController {
    private static final Logger log = LoggerFactory.getLogger(TransportadoraController.class);

    @Autowired
    private TransportadoraService transportadoraService;

    @ApiOperation(
            value = "Recuperar todas as transportadoras",
            notes = "Serviço para recuperar todas as transportadoras. O serviço retorna umas lista de todas as transportadoras.",
            response = Transportadora.class
    )
    @GetMapping("/all")
    public ResponseEntity recuperarTodas() {
        List<Transportadora> transportadoras = transportadoraService.recuperarTransportadoras();

        return ResponseEntity.ok(transportadoras);
    }

    @ApiOperation(
            value = "Recuperar a melhor transportadora",
            notes = "Serviço para recuperar a melhor transportadora baseado nos dados digitados. O serviço retorna umas lista das melhores transportadoras.",
            response = Transportadora.class
    )
    @PostMapping("/recuperarMelhor")
    public ResponseEntity recuperarMelhor(@RequestBody PesquisaViagem pesquisaViagem) {

        try {
            List<TransportadoraSaida> transportadoras = transportadoraService.recuperarMelhorTransportadora(pesquisaViagem);
            return ResponseEntity.ok(transportadoras);
        } catch (Exception e) {
            log.error("\nParametros invalidos: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}