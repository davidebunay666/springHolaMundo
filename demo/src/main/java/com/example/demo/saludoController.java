/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author ue0100066h
 */
@Controller
public class saludoController {
    @GetMapping("/saludo")
	public String saludo() {
            Logger logger = LoggerFactory.getLogger(saludoController.class);
            logger.info("*************INGRESA a saludo*************");
            return "saludo";
    }
}
