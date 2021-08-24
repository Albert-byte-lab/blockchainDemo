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
import java.util.ArrayList;
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

    /**
     * 根据epc值获取对应的rfid标签信息
     * @param request
     * @return
     */
    @RequestMapping(value="/getrfidbyepc",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> getRFIDByEpc(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        //获取前端的epc值
        String epc = HttpServletRequestUtil.getString(request,"epc");
        //根据epc值进行查询操作
        RFID rfid = rfidService.getRFIDByEpc(epc);
        if(rfid != null){
            System.out.println("对应标签的epc值为: "+rfid.getEpc());
            System.out.println("对应标签的tid值为: "+rfid.getTid());
            //将查询到的标签值封装至前端。
            modelMap.put("rfid",rfid);
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 根据多个epc值批量获取对应的标签值。
     * @param request
     * @return
     */
    @RequestMapping(value="/getrfidlistbyepclist",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> getRFIDListByEpcList(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        //获取前端封装的json对象数组
        String epcListStr = HttpServletRequestUtil.getString(request,"epcListStr");
        ObjectMapper mapper = new ObjectMapper();
        //用来封装获取到的多个epc值。
        List<String> epcList = new ArrayList<>();
        try {
            RFID[] rfids = mapper.readValue(epcListStr,RFID[].class);
            System.out.println("数组长度是: "+rfids.length);
            for(RFID rfid:rfids){
                System.out.println("epc值为:"+rfid.getEpc());
                epcList.add(rfid.getEpc());
            }
            List<RFID> rfidList = rfidService.getRFIDListByEpcs(epcList);
            if(rfidList != null){
                modelMap.put("rfidList",rfidList);
                modelMap.put("success",true);
            }
        } catch (IOException e) {
            modelMap.put("success",false);
        }
        return modelMap;
    }


}
