package com.loongrise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
    @GetMapping("/trace")
    public String trace(){
        return "trace";
    }
}
