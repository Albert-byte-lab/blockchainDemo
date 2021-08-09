package com.loongrise.controller;

import com.loongrise.entity.History;
import com.loongrise.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/showhistory",method = RequestMethod.GET)
    private ModelAndView showHistory(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<History> historyList = historyService.getHistoryList();
        if(historyList != null){
            request.setAttribute("historyList",historyList);
            modelAndView = new ModelAndView("historyList");
        }
        return modelAndView;
    }



}
