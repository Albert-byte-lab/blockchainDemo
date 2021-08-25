package com.loongrise.controller;

import com.loongrise.entity.AviationMaterial;
import com.loongrise.entity.AviationMaterialCate;
import com.loongrise.entity.History;
import com.loongrise.service.AviationMaterialCateService;
import com.loongrise.service.AviationMaterialService;
import com.loongrise.service.HistoryService;
import com.loongrise.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private AviationMaterialService aviationMaterialService;




}
