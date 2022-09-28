package com.atsistemas.calculadora.controller;

import com.atsistemas.calculadora.dto.ResultDTO;
import com.atsistemas.calculadora.service.IOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SumaController implements IOperacion {

    TracerImpl tracer = new TracerImpl();

    @GetMapping("/api/v1/calculadora/sumar")
    public ResponseEntity<ResultDTO> aplicarOperacion(
            @RequestParam(name = "num1") Double num1,
            @RequestParam(name = "num2") Double num2) throws Exception {

        ResultDTO resultado = new ResultDTO(num1 + num2);
        tracer.trace("SumaController :: " + resultado.toString());
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

}