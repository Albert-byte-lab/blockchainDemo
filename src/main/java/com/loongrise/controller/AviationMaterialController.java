package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.AviationMaterial;
import com.loongrise.entity.RFID;
import com.loongrise.service.AviationMaterialService;
import com.loongrise.service.RFIDService;
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

    @Autowired
    private RFIDService rfidService;

    @RequestMapping(value="/make",method= RequestMethod.GET)
    private ModelAndView showAm2(HttpServletRequest request){
        ModelAndView model = null;
        List<AviationMaterial> aviationMaterialList = aviationMaterialService.getAviationMaterialList();
        if(aviationMaterialList != null){
            request.setAttribute("make_list",aviationMaterialList);
            model = new ModelAndView("make_list");
        }
        return model;
    }



    @RequestMapping(value="/assembPlant",method= RequestMethod.GET)
    private ModelAndView showAm3(HttpServletRequest request){
        ModelAndView model = null;
        List<AviationMaterial> aviationMaterialList = aviationMaterialService.getAviationMaterialList();
        if(aviationMaterialList != null){
            request.setAttribute("assembPlant_list",aviationMaterialList);
            model = new ModelAndView("assembPlant_list");
        }
        return model;
    }


    @RequestMapping(value="/airline",method= RequestMethod.GET)
    private ModelAndView showAm4(HttpServletRequest request){
        ModelAndView model = null;
        List<AviationMaterial> aviationMaterialList = aviationMaterialService.getAviationMaterialList();
        if(aviationMaterialList != null){
            request.setAttribute("airline_list",aviationMaterialList);
            model = new ModelAndView("airline_list");
        }
        return model;
    }


    @RequestMapping(value="/repair",method= RequestMethod.GET)
    private ModelAndView showAm5(HttpServletRequest request){
        ModelAndView model = null;
        List<AviationMaterial> aviationMaterialList = aviationMaterialService.getAviationMaterialList();
        if(aviationMaterialList != null){
            request.setAttribute("repair_list",aviationMaterialList);
            model = new ModelAndView("repair_list");
        }
        return model;
    }




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
        String rfidStr = HttpServletRequestUtil.getString(request,"rfidStr");
        ObjectMapper mapper = new ObjectMapper();
        AviationMaterial am = null;
        RFID rfid = null;
        try{
            am = mapper.readValue(amStr,AviationMaterial.class);
            rfid = mapper.readValue(rfidStr,RFID.class);
            System.out.println("epc值为: "+rfid.getEpc());
            System.out.println("tid值为: "+rfid.getTid());
            System.out.println(am.getAmName());
            if(am != null && rfid != null){
                int num = aviationMaterialService.addAm(am);
                if(num > 0){
                    //获取新增零部件的id值
                    long newId = aviationMaterialService.getNewId();
                    System.out.println("新增零部件的Id为:"+newId);
                    rfid.setAmId(newId);
                    //之后将新增的id及rfid标签信息一起加入到rfid表中
                  int t =   rfidService.addRFID(rfid);
                  if(t > 0){
                      modelMap.put("success",true);
                  }
                }
            }
        }catch (IOException e){
            modelMap.put("success",false);
        }
        return modelMap;
    }
}
