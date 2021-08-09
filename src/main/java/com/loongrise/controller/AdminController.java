package com.loongrise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="admin",method= {RequestMethod.GET})
public class AdminController {

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public String login() {
        return "/login";
    }
    @RequestMapping(value = "/index",method = {RequestMethod.GET})
    public String index() {
        return "/index";
    }
    @RequestMapping(value = "/make_index",method = {RequestMethod.GET})
    public String index2() {
        return "make_index";
    }
    @RequestMapping(value = "/assembPlant_index",method = {RequestMethod.GET})
    public String index3() {
        return "assembPlant_index";
    }
    @RequestMapping(value = "/airline_index",method = {RequestMethod.GET})
    public String index4() {
        return "airline_index";
    }
    @RequestMapping(value = "/repair_index",method = {RequestMethod.GET})
    public String index5() {
        return "repair_index";
    }
    @RequestMapping(value = "/welcome")
    public String welcome() {
        return  "/welcome";
    }
    @RequestMapping(value = "/amadd")
    public String amAdd() {
        return  "/amAdd";
    }
}
