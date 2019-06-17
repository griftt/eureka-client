package com.griftt.orderserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class testController {

    public String returnMsg (){

        return "ok";
    }

    public testController(){

        System.err.println("okkkk");
    }
}
