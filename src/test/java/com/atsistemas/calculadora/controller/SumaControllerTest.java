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
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@SpringBootTest(classes = CalculadoraApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class SumaControllerTest {
    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<ResultDTO> sumar(double num1, double num2) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/api/v1/calculadora/sumar?num1=" + num1 + "&num2=" + num2;
        URI uri = new URI(baseUrl);
        ResultDTO resp = new ResultDTO(Objects.requireNonNull(restTemplate.getForEntity(uri, JsonNode.class).getBody()));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @Test
    void deberiaSumarDosNumeros() throws URISyntaxException {
        ResponseEntity<ResultDTO> resultado = sumar(4.01, 6.02);

        //Comprueba el resultado
        Assertions.assertEquals(200, resultado.getStatusCodeValue());
        Assertions.assertEquals(10.03d, Objects.requireNonNull(resultado.getBody()).getResult());
    }
}