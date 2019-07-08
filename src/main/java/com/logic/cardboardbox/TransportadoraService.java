package com.logic.cardboardbox;

import com.logic.cardboardbox.controller.Transportadora2Controller;
import com.logic.cardboardbox.controller.Transportadora3Controller;
import com.logic.cardboardbox.controller.Transportadora4Controller;
import com.logic.cardboardbox.controller.TransportadoraController;
import com.logic.cardboardbox.model.dto.PesquisaViagem;
import com.logic.cardboardbox.model.dto.TipoTransporte;
import com.logic.cardboardbox.model.dto.Transportadora;
import com.logic.cardboardbox.model.dto.TransportadoraSaida;
import com.logic.cardboardbox.model.entity.Transportadora1Entity;
import com.logic.cardboardbox.repository.Transportadora1Repository;
import com.logic.cardboardbox.utils.PrioridadeEnum;
import com.logic.cardboardbox.utils.ValidacaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransportadoraService {

    private static final Logger log = LoggerFactory.getLogger(TransportadoraController.class);

    @Autowired
    private Transportadora1Repository transportadora1Repository;

    @Autowired
    private Transportadora2Controller transportadora2Controller;

    @Autowired
    private Transportadora3Controller transportadora3Controller;

    @Autowired
    private Transportadora4Controller transportadora4Controller;

    @Autowired
    private ConversaoTransportadoraService conversaoTransportadoraService;

    public List<Transportadora> recuperarTransportadoras() {
        List<Transportadora> transportadoras = new ArrayList<>();

        List<Transportadora1Entity> transportadora1Entities = transportadora1Repository.findAll();

        transportadora1Entities.forEach(transportadora1Entity -> {
            Transportadora transportadora1 = new Transportadora();
            transportadora1.setId(1);
            transportadora1.setNome("Transportadora1");
            transportadora1.setTipoTransporte(
                    new TipoTransporte()
                            .setTipoTransporte(transportadora1Entity.getTipoTransporte())
                            .setTempo(transportadora1Entity.getTempo())
                            .setValor(transportadora1Entity.getValor())
            );
            transportadoras.add(transportadora1);
        });

        transportadoras.addAll(transportadora2Controller.recuperarDados());
        transportadoras.addAll(transportadora3Controller.recuperarDados());
        transportadoras.addAll(transportadora4Controller.recuperarDados());

        return transportadoras;
    }

    public List<TransportadoraSaida> recuperarMelhorTransportadora(PesquisaViagem pesquisaViagem) {

        List<Transportadora> transportadoras = recuperarTransportadoras();
        List<TransportadoraSaida> transportadoraSaidaList = new ArrayList<>();

        if (pesquisaViagem.getOrigem() == null || pesquisaViagem.getOrigem().isEmpty()) {
            throw new ValidacaoException("Campo origem não foi informado ou é inválido");
        }

        if (pesquisaViagem.getDestino() == null || pesquisaViagem.getDestino().isEmpty()) {
            throw new ValidacaoException("Campo destino não foi informado ou é inválido");
        }

        if (pesquisaViagem.getDistancia() == null || pesquisaViagem.getDistancia() < 1) {
            throw new ValidacaoException("Campo distancia não foi informado ou é inválido");
        }

        if (pesquisaViagem.getPrioridade() == null) {
            throw new ValidacaoException("Campo prioridade não foi informado ou é inválido");
        }

        if (pesquisaViagem.getTipoTransporte() != null) {
            transportadoras = transportadoras.stream().filter(transportadora ->
                    transportadora.getTipoTransporte().getTipoTransporte().equals(pesquisaViagem.getTipoTransporte())).collect(Collectors.toList());
        }

        List<Transportadora> melhoresTransportadoras = recuperaListaMenores(transportadoras, pesquisaViagem.getPrioridade(), pesquisaViagem.getDistancia());

        if (melhoresTransportadoras.size() > 1) {
            if (pesquisaViagem.getPrioridade().equals(PrioridadeEnum.PRECO)) {
                melhoresTransportadoras = recuperaListaMenores(melhoresTransportadoras, PrioridadeEnum.TEMPO, pesquisaViagem.getDistancia());
            } else {
                melhoresTransportadoras = recuperaListaMenores(melhoresTransportadoras, PrioridadeEnum.PRECO, pesquisaViagem.getDistancia());
            }
        }

        melhoresTransportadoras.forEach(transportadora ->
                transportadoraSaidaList.add(conversaoTransportadoraService.converterParaSaida(transportadora, pesquisaViagem.getDistancia())));

        return transportadoraSaidaList;
    }

    private List<Transportadora> recuperaListaMenores(List<Transportadora> transportadoras, PrioridadeEnum prioridade, Long distancia) {
        List<Transportadora> melhorTransportadoraList = new ArrayList<>();
        if (prioridade.equals(PrioridadeEnum.TEMPO)) {
            Optional optionalTempo = transportadoras.stream().min(Comparator.comparing(transportadora -> transportadora.getTipoTransporte().getTempo()));

            if (optionalTempo.isPresent()) {
                Transportadora melhorTransportadoraTempo = (Transportadora) optionalTempo.get();
                melhorTransportadoraList = transportadoras.stream().filter(transportadora ->
                        transportadora.getTipoTransporte().getTempo().equals(melhorTransportadoraTempo.getTipoTransporte().getTempo())).collect(Collectors.toList());
            }
        }

        if (prioridade.equals(PrioridadeEnum.PRECO)) {
            Optional optionalPreco = transportadoras.stream().min(Comparator.comparing(transportadora ->
                    (transportadora.getTipoTransporte().getValor() * distancia) / 10));

            if (optionalPreco.isPresent()) {
                Transportadora melhorTransportadoraTempo = (Transportadora) optionalPreco.get();
                melhorTransportadoraList = transportadoras.stream().filter(transportadora ->
                        transportadora.getTipoTransporte().getValor().equals(melhorTransportadoraTempo.getTipoTransporte().getValor())).collect(Collectors.toList());
            }
        }

        return melhorTransportadoraList;
    }
}
