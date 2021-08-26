package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.*;
import com.loongrise.service.*;
import com.loongrise.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
            System.out.println("aaaaaaaaaaaaaa"+am.getAircraft().getAcId());
            if(am != null){
                am.setAmCategory(0);
                System.out.println("am.setAmCategory== "+am.getAmCategory());
                int num = aviationMaterialService.addOneAm(am);
                if(num > 0){
                    //录入零件信息时，就添加相应信息到history表中。
                    History history = new History();
                    //1.获取用户信息.
                    UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");

                    history.setName(userInfo.getName());
                    history.setAddress(userInfo.getAddress());
                    history.setDate(new Date());
                    history.setAmCategory(0);
                    //获取新增的零部件id值
                    long newId = aviationMaterialService.getNewId();
                    history.setAmId(newId);
                    System.out.println("newId是:------"+newId);
                    int i = historyService.addHistory(history);
                    if(i>0){
                        modelMap.put("success",true);
                    }
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


    //追踪 Trace
    @GetMapping("/trace/{amId}")
    @ResponseBody
    private ModelAndView trace(@PathVariable String amId,HttpServletRequest request){
        ModelAndView modelAndView = null;
        Long realAmId = Long.parseLong(amId);
        System.out.println("realAmId: "+realAmId);
        //根据零部件Id获取对应的零部件历史记录信息
        List<History> historyListByAmId = historyService.getHistoryListByAmId(realAmId);
        if(historyListByAmId != null){
            for(History history:historyListByAmId){
                System.out.print("getName=  "+history.getName()+"   ");
                System.out.print("getAddress=  "+history.getAddress()+"   ");
                System.out.print("getDate=  "+history.getDate()+"    ");
                System.out.println("getCategory=  "+history.getAmCategory());
                System.out.println();
            }
            request.setAttribute("historyList",historyListByAmId);
            modelAndView = new ModelAndView("amTrace");
        }
        return  modelAndView;
    }
}
