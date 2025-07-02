package com.example.clase06mongodb.clase06mongodb.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class TestController {

  @GetMapping("/hola")
  public String mostrarHola(){
    log.info("en el controlador TestController, metodo mostrarHola");

    return  "Hola desplegado desde Websphere Liberty";

  }
}
