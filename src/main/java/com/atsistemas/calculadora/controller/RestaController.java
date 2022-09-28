package com.atsistemas.calculadora.controller;

import com.atsistemas.calculadora.dto.ResultDTO;
import com.atsistemas.calculadora.service.IOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaController implements IOperacion {

    TracerImpl tracer = new TracerImpl();

    @GetMapping("/api/v1/calculadora/restar")
    public ResponseEntity<ResultDTO> aplicarOperacion(
            @RequestParam(name = "num1") Double num1,
            @RequestParam(name = "num2") Double num2) throws Exception {

        ResultDTO resultado = new ResultDTO(num1 - num2);
        tracer.trace("RestaController :: " + resultado.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

}