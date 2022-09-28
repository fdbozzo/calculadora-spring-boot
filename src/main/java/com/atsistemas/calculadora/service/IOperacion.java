package com.atsistemas.calculadora.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOperacion {

    ResponseEntity<?> aplicarOperacion(@RequestParam(name = "num1") Double num1, @RequestParam(name = "num2") Double num2) throws Exception;

}
