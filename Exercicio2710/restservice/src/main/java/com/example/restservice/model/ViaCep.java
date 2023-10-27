package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViaCep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;


    public ViaCep(String cep, String logradouro, String complemento, String localidade){
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.localidade = localidade;
    }
    public ViaCep(ViaCep cep){
        this.cep = cep.getCep();
        this.logradouro = cep.getLogradouro();
        this.complemento = cep.getComplemento();
        this.localidade = cep.getLocalidade();
    }

    public ViaCep(){

    }
        /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }
    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }
    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }
    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    /**
     * @return the localidade
     */
    public String getLocalidade() {
        return localidade;
    }
    /**
     * @param localidade the localidade to set
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

}
