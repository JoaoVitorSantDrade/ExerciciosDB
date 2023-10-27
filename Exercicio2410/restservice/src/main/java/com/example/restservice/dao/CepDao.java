package com.example.restservice.dao;

import java.util.List;
import java.util.Optional;

import com.example.restservice.model.ViaCep;

public interface CepDao {
    int insertCep(ViaCep cep);

    List<ViaCep> selectAllCep();

    Optional<ViaCep> selectCepByNumber(String cepNumber);

    int deleteCepByNumber(String cepNumber);

    int updateCepByNumber(String cepNumber, ViaCep cep);
    
}
