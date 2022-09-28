package com.atsistemas.calculadora.controller;

import com.atsistemas.calculadora.service.IOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Sumar implements IOperacion {

    TracerImpl tracer = new TracerImpl();

    @GetMapping("/api/v1/calculadora/sumar")
    public ResponseEntity<?> aplicarOperacion(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) throws Exception {
        Double resultado = num1 + num2;
        tracer.trace("CalculadoraController :: " + resultado);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

}