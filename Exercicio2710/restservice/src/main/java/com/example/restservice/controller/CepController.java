package com.example.restservice.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.restservice.model.ViaCep;
import com.example.restservice.service.CepService;

@RestController
public class CepController {


    private final CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

	@PostMapping("/add")
	public ViaCep addAddress(@RequestParam(value = "cep", defaultValue = "0") String cep) {
		String uri = "https://viacep.com.br/ws/"+ cep + "/json/";
		RestTemplate restTemplate = new RestTemplate();
        ViaCep cepToAdd = new ViaCep(restTemplate.getForObject(uri, ViaCep.class));
        if(cepToAdd.getCep() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP does not exist");
        }
        cepService.addCep(cepToAdd);
        return cepToAdd;
    }

    @GetMapping("/all")
	public List<ViaCep> allAddresses() {
        return cepService.getAllCep();
    }

    @GetMapping("/id")
    @ResponseStatus()
    public Optional<ViaCep> address(@RequestParam(value = "cep", defaultValue = "0") String cep) {
        return cepService.getCepByNumber(cep);
    }



    
}