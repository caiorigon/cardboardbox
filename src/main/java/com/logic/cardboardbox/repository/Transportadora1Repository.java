package com.logic.cardboardbox.repository;


import com.logic.cardboardbox.model.entity.Transportadora1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Transportadora1Repository extends JpaRepository<Transportadora1Entity, Long> {

    Optional<Transportadora1Entity> findByTipoTransporte(Long tipoTransporte);
}

