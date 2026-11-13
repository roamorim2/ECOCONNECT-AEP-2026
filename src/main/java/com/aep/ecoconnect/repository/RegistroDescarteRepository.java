package com.aep.ecoconnect.repository;

import com.aep.ecoconnect.model.RegistroDescarte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroDescarteRepository extends MongoRepository<RegistroDescarte, String> {
    List<RegistroDescarte> findByPontoColetaId(String pontoColetaId);
}