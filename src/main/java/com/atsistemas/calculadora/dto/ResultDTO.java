package com.atsistemas.calculadora.dto;

public class ResultDTO {
    Double result;

    public ResultDTO(Double result) {
        this.result = result;
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
