package com.aep.ecoconnect.repository;

import com.aep.ecoconnect.model.PontoColeta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoColetaRepository extends MongoRepository<PontoColeta, String> {
}