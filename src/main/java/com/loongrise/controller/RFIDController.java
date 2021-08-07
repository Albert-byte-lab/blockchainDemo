package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.RFID;
import com.loongrise.service.RFIDService;
import com.loongrise.util.HttpServletRequestUtil;
import org.omg.CORBA.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/rfid")
public class RFIDController {
    @Autowired
    private RFIDService rfidService;

    /**
     * 获取所有的RFID标签
     * @param request
     * @return
     */
    @RequestMapping(value="/getrfid",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> getRFID(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        List<RFID> rfidList = rfidService.queryRFID();
        modelMap.put("rfidList",rfidList);
        modelMap.put("success",true);
        return modelMap;
    }

    @RequestMapping(value="/addrfid",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addRFID(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String rfidStr = HttpServletRequestUtil.getString(request,"rfidStr");
        ObjectMapper mapper = new ObjectMapper();
        try {
            RFID rfid = mapper.readValue(rfidStr,RFID.class);
            System.out.println(rfid.getEpc());
            modelMap.put("success",true);
        } catch (IOException e) {
            e.printStackTrace();
            modelMap.put("success",false);
        }
        return modelMap;
    }

}
