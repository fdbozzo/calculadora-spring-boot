package com.atsistemas.calculadora.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class ResultDTO {
    private Double result;

    public ResultDTO(Double result) {
        this.result = result;
    }

    // Usado por el Unit Testing
    public ResultDTO(JsonNode result) {
        this.result = result.get("result").asDouble();
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return this.result.toString();
    }
}
