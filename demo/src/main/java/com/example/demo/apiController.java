/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ue0100066h
 */
@RestController
@RequestMapping("/api")
public class apiController {
 
    @GetMapping("/")
    public Map<String, String> api(@RequestParam String nombre) {
        Logger logger = LoggerFactory.getLogger(apiController.class);
        logger.info("*************INGRESA a la API*************");
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("campo2", "valor2");
            map.put("campo3", "valor3");
            map.put("campo4", "valor4");
            map.put("Nombre", nombre);
            
            logger.info("JSON generado exitosamente!\n"+map);
            return map;
        } 
        catch (Exception e) {
            logger.error("Existe un problema "+e);
            return null;
        }

    }
}
