package com.example.restservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.restservice.dao.CepDao;
import com.example.restservice.model.ViaCep;

@Controller
public class CepService {
    
    private final CepDao cepDao;

    @Autowired
    public CepService(@Qualifier("FakeDao") CepDao cepDao) {
        this.cepDao = cepDao;
    }

    public int addCep(ViaCep cep) {
        return cepDao.insertCep(cep);
    }

    public List<ViaCep> getAllCep(){
        return cepDao.selectAllCep();
    }

    public Optional<ViaCep> getCepByNumber(String cep){
        return cepDao.selectCepByNumber(cep);
    }

    public int deleteCepByNumber(String cep) { 
        return cepDao.deleteCepByNumber(cep);
    }

    public int updateCepByNumber(String cep, ViaCep newCep){
        return cepDao.updateCepByNumber(cep, newCep);
    }


}
