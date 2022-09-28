package com.atsistemas.calculadora.controller;

import com.atsistemas.calculadora.CalculadoraApplication;
import com.atsistemas.calculadora.dto.ResultDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@SpringBootTest(classes = CalculadoraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ErroresTest {
    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<ResultDTO> dividir(double num1, double num2) throws URISyntaxException, HttpClientErrorException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/api/v1/calculadora/dividir?num1=" + num1 + "&num2=" + num2;
        URI uri = new URI(baseUrl);
        ResultDTO resp = new ResultDTO(Objects.requireNonNull(restTemplate.getForEntity(uri, JsonNode.class).getBody()));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Test
    void deberiaDarError_HttpClientErrorException_alLlamarAUnaOperacionNoExistente() throws URISyntaxException {
        ResponseEntity<ResultDTO> resultado = null;
        try {
            resultado = dividir(6.02, 2.00);
            //Comprueba el resultado
            Assertions.assertEquals(404, resultado.getStatusCodeValue());

        } catch (HttpClientErrorException e) {
            Assertions.assertEquals(404, e.getRawStatusCode());
        }

    }

}