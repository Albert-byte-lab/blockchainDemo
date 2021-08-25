package com.loongrise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class TestController {
    @GetMapping("/trace/{amId}")
    public String trace(@PathVariable String amId){
        System.out.println(amId);
        return "amTrace";
    }
}
