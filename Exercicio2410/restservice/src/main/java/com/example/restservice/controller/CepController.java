package com.example.restservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.restservice.model.ViaCep;
import com.example.restservice.service.CepService;

@RestController
public class CepController {


    private final CepService cepService;

    @Autowired
    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

	@GetMapping("/")
	public ViaCep address(@RequestParam(value = "cep", defaultValue = "0") String cep) {
		String uri = "https://viacep.com.br/ws/"+ cep + "/json/";
		RestTemplate restTemplate = new RestTemplate();
        ViaCep cepToAdd = new ViaCep(restTemplate.getForObject(uri, ViaCep.class));
        cepService.addCep(cepToAdd);
        return cepToAdd;
    }

    @GetMapping("/all")
	public List<ViaCep> addresses() {
        return cepService.getAllCep();
    }

    
}