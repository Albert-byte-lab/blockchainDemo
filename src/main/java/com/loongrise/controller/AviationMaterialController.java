package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.AviationMaterial;
import com.loongrise.service.AviationMaterialCateService;
import com.loongrise.service.AviationMaterialService;
import com.loongrise.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/am")
public class AviationMaterialController {
    @Autowired
    private AviationMaterialService aviationMaterialService;

    @RequestMapping(value="/showam",method= RequestMethod.GET)
    private ModelAndView showAm(HttpServletRequest request){
        ModelAndView model = null;
        List<AviationMaterial> aviationMaterialList = aviationMaterialService.getAviationMaterialList();
        if(aviationMaterialList != null){
            request.setAttribute("amList",aviationMaterialList);
            model = new ModelAndView("amList");
        }
        return model;
    }

    @RequestMapping(value="/addam",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addAm(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String amStr = HttpServletRequestUtil.getString(request,"amStr");
        ObjectMapper mapper = new ObjectMapper();
        AviationMaterial am = null;
        try{
            am = mapper.readValue(amStr,AviationMaterial.class);
            System.out.println(am.getAmName());
            if(am != null){
                int num = aviationMaterialService.addAm(am);
                if(num > 0){
                    modelMap.put("success",true);
                }
            }
        }catch (IOException e){
            modelMap.put("success",false);
        }
        return modelMap;
    }
}
