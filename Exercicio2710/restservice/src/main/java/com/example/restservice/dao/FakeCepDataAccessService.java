package com.example.restservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.restservice.model.ViaCep;

@Repository("FakeDao")
public class FakeCepDataAccessService implements CepDao{
    private static List<ViaCep> DB = new ArrayList<>();


    @Override
    public int insertCep(ViaCep cep) {
        DB.add(cep);
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ViaCep> selectAllCep() {
        // TODO Auto-generated method stub
        return DB;
    }

    @Override
    public Optional<ViaCep> selectCepByNumber(String cepNumber) {
        return DB
        .stream()
        .filter(s -> s.getCep().equals(cepNumber))
        .findFirst();
    }

    @Override
    public int deleteCepByNumber(String cepNumber) {
        Optional<ViaCep> selectedCep = selectCepByNumber(cepNumber);
        if (selectedCep.isPresent()) {
            DB.remove(selectedCep.get());
            return 1;
        }

        return 0;
    }


    @Override
    public int updateCepByNumber(String cepNumber, ViaCep cep) {
        return selectCepByNumber(cepNumber)
        .map(c -> {
            int indexOfCepToUpadate = DB.indexOf(c);
            if (indexOfCepToUpadate >= 0) { 
                DB.set(indexOfCepToUpadate, new ViaCep(cep));
                return 1;
            }
            return 0;
        })
        .orElse(0);
    }


}
