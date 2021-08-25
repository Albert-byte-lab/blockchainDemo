package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.*;
import com.loongrise.service.*;
import com.loongrise.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value="/am")
public class AviationMaterialController {
    @Autowired
    private AviationMaterialService aviationMaterialService;

    @Autowired
    private RFIDService rfidService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private AircraftService aircraftService;

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
                  //获取当前结点Name address desc
                    UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                    System.out.println("address:"+userInfo.getAddress());
                    History history = new History();
                    history.setPre(null);
                    history.setNext(null);
                    history.setAddress(userInfo.getAddress());
                    history.setAmId(newId);
                    history.setEpc(rfid.getEpc());
                    history.setTid(rfid.getTid());
                    history.setName(userInfo.getName());
                    history.setAddress(userInfo.getAddress());
                    history.setDate(new Date());
                    history.setHashCode("tt");
                    int h = historyService.addHistory(history);
                  if(t > 0 && h > 0){
                      modelMap.put("success",true);
                  }
                }
            }
        }catch (IOException e){
            modelMap.put("success",false);
        }
        return modelMap;
    }

    //飞机制造商工程部门-展示零部件信息,仅包含(name desc 使用年限 所属机型，其他信息为空)
    @RequestMapping(value="/oneshowam",method = RequestMethod.GET)
    private ModelAndView oneShowAm(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<AviationMaterial> amList = aviationMaterialService.getOneAmList();
        List<Aircraft> aircraftList = new ArrayList<>();
        if(amList != null){
            request.setAttribute("amList",amList);
            modelAndView = new ModelAndView("table");
        }
        return modelAndView;
    }

    //获取所有的机型信息
    @RequestMapping(value = "/showaircraftinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> showAircraftInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        List<Aircraft> aircraftList = aircraftService.getAllAircraft();
        System.out.println("====================================="+aircraftList.get(0).getAcName());
        if(aircraftList != null){
            modelMap.put("aircraftList",aircraftList);
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    //one addAm
    @RequestMapping(value="/oneaddam",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> oneAddAm(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String amStr = HttpServletRequestUtil.getString(request,"amStr");
        ObjectMapper mapper = new ObjectMapper();
        AviationMaterial am = null;
        try{
            am = mapper.readValue(amStr,AviationMaterial.class);
            System.out.println("aaaaaaaaaaaaaa"+am.getAircraft().getAcName());
            if(am != null){
                int num = aviationMaterialService.addOneAm(am);
                if(num > 0){
                    modelMap.put("success",true);
                }
            }
        }catch (IOException e){
            modelMap.put("success",false);
        }
        return modelMap;
    }

    //two
    @RequestMapping(value="/twoshowam",method = RequestMethod.GET)
    private ModelAndView twoShowAm(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<AviationMaterial> amList = aviationMaterialService.getTwoAmList();
        if(amList != null){
            request.setAttribute("amList",amList);
            modelAndView = new ModelAndView("table");
        }
        return modelAndView;
    }

    //three
    @RequestMapping(value="/threeshowam",method = RequestMethod.GET)
    private ModelAndView threeShowAm(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<AviationMaterial> amList = aviationMaterialService.getThreeAmList();
        if(amList != null){
            request.setAttribute("amList",amList);
            modelAndView = new ModelAndView("table");
        }
        return modelAndView;
    }

    //four
    @RequestMapping(value="/fourshowam",method = RequestMethod.GET)
    private ModelAndView fourShowAm(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<AviationMaterial> amList = aviationMaterialService.getFourAmList();
        if(amList != null){
            request.setAttribute("amList",amList);
            modelAndView = new ModelAndView("table");
        }
        return modelAndView;
    }

    //five
    @RequestMapping(value="/fiveshowam",method = RequestMethod.GET)
    private ModelAndView fiveShowAm(HttpServletRequest request){
        ModelAndView modelAndView = null;
        List<AviationMaterial> amList = aviationMaterialService.getFiveAmList();
        if(amList != null){
            request.setAttribute("amList",amList);
            modelAndView = new ModelAndView("table");
        }
        return modelAndView;
    }




    
}
