package com.logic.cardboardbox.service;

import com.logic.cardboardbox.controller.Transportadora2Controller;
import com.logic.cardboardbox.controller.Transportadora3Controller;
import com.logic.cardboardbox.controller.Transportadora4Controller;
import com.logic.cardboardbox.environment.PesquisaViagemEnvironment;
import com.logic.cardboardbox.environment.Transportadora1EntityEnvironment;
import com.logic.cardboardbox.environment.TransportadoraEnvironment;
import com.logic.cardboardbox.environment.TransportadoraSaidaEnvironment;
import com.logic.cardboardbox.model.dto.PesquisaViagem;
import com.logic.cardboardbox.model.dto.Transportadora;
import com.logic.cardboardbox.model.dto.TransportadoraSaida;
import com.logic.cardboardbox.model.entity.Transportadora1Entity;
import com.logic.cardboardbox.repository.Transportadora1Repository;
import com.logic.cardboardbox.utils.ValidacaoException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@DisplayName("Classe do TransportadoraService")
public class TransportadoraServiceTest {

    @InjectMocks
    private TransportadoraService transportadoraService;

    @Mock
    private Transportadora1Repository transportadora1Repository;

    @Mock
    private Transportadora2Controller transportadora2Controller;

    @Mock
    private Transportadora3Controller transportadora3Controller;

    @Mock
    private Transportadora4Controller transportadora4Controller;

    @Mock
    private ConversaoTransportadoraService conversaoTransportadoraService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Teste para obter a Melhor Transportadora")
    public void recuperarMelhorTransportadoraTest() {

        PesquisaViagem pesquisaViagem = PesquisaViagemEnvironment.criarPesquisaViagemPrecoAereo();

        List<Transportadora1Entity> transportadora1List = Transportadora1EntityEnvironment.criarListTransportadora1Entities();
        when(transportadora1Repository.findAll()).thenReturn(transportadora1List);

        List<Transportadora> transportadora2List = List.of(TransportadoraEnvironment.criarTransportadoraAerea());
        when(transportadora2Controller.recuperarDados()).thenReturn(transportadora2List);

        List<Transportadora> transportadora3List = List.of(TransportadoraEnvironment.criarTransportadoraTerrestre());
        when(transportadora3Controller.recuperarDados()).thenReturn(transportadora3List);

        List<Transportadora> transportadora4List = TransportadoraEnvironment.criarTransportadoraAereaTerrestre();
        when(transportadora4Controller.recuperarDados()).thenReturn(transportadora4List);

        TransportadoraSaida transportadoraSaida = TransportadoraSaidaEnvironment.criarTransportadoraSaida();
        when(conversaoTransportadoraService.converterParaSaida(any(), anyLong())).thenReturn(transportadoraSaida);

        List<TransportadoraSaida> transportadoraSaidaList = transportadoraService.recuperarMelhorTransportadora(pesquisaViagem);

        Assertions.assertEquals(1000, transportadoraSaidaList.get(0).getDistancia());
        Assertions.assertEquals("tsaida", transportadoraSaidaList.get(0).getNome());
    }


    @Test
    @DisplayName("Teste para obter a Melhor Transportadora dispara excecao")
    public void recuperarMelhorTransportadoraThrowTest() {

        PesquisaViagem pesquisaViagem = PesquisaViagemEnvironment.criarPesquisaViagemSemOrigem();

        List<Transportadora1Entity> transportadora1List = Transportadora1EntityEnvironment.criarListTransportadora1Entities();
        when(transportadora1Repository.findAll()).thenReturn(transportadora1List);

        List<Transportadora> transportadora2List = List.of(TransportadoraEnvironment.criarTransportadoraAerea());
        when(transportadora2Controller.recuperarDados()).thenReturn(transportadora2List);

        List<Transportadora> transportadora3List = List.of(TransportadoraEnvironment.criarTransportadoraTerrestre());
        when(transportadora3Controller.recuperarDados()).thenReturn(transportadora3List);

        List<Transportadora> transportadora4List = TransportadoraEnvironment.criarTransportadoraAereaTerrestre();
        when(transportadora4Controller.recuperarDados()).thenReturn(transportadora4List);

        ValidacaoException exception = Assertions.assertThrows(ValidacaoException.class,
                () -> transportadoraService.recuperarMelhorTransportadora(pesquisaViagem));

        Assertions.assertEquals("Campo origem não foi informado ou é inválido", (exception.getErro()));
    }
}
