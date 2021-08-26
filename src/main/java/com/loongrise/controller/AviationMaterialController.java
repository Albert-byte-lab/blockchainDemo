package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.*;
import com.loongrise.service.*;
import com.loongrise.util.HttpServletRequestUtil;
import com.sun.javafx.collections.ImmutableObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
        long amCategory = 0;
        //获取目前登录的角色信息
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        System.out.println("userId是: "+userInfo.getUserId());
        long userId = userInfo.getUserId();
        if(userId == 1){
            amCategory = 0;
        }else if(userId == 2){
            amCategory = 1;
        }else if(userId == 3){
            amCategory = 2;
        }else if(userId == 4){
            amCategory = 3;
        }else if(userId == 5){
            amCategory = 4;
        }
        History history = new History();
        history.setAmId(realAmId);
        history.setAmCategory(amCategory);
        //根据零部件Id获取对应的零部件历史记录信息
        List<History> historyListByAmId = historyService.getHistoryListByAmId(history);
        if(historyListByAmId != null){
            for(History h:historyListByAmId){
                System.out.print("getName=  "+h.getName()+"   ");
                System.out.print("getAddress=  "+h.getAddress()+"   ");
                System.out.print("getDate=  "+h.getDate()+"    ");
                System.out.println("getCategory=  "+h.getAmCategory());
                System.out.println();
            }
            request.setAttribute("historyList",historyListByAmId);
            modelAndView = new ModelAndView("amTrace");
        }
        return  modelAndView;
    }

    @GetMapping("/showambyamid/{amId}")
    private ModelAndView showAmByAmId(@PathVariable String amId,HttpServletRequest request){
        Long realAmId = Long.parseLong(amId);
        System.out.println("amId是:"+realAmId);
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        ModelAndView model = null;
        AviationMaterial am = aviationMaterialService.getAmById(realAmId);
        if(am != null){
            System.out.println("am.getAmName()的值是: "+am.getAmName());
            request.setAttribute("am",am);
            if(userInfo.getUserId() == 2){
                model = new ModelAndView("editAm");
            }else if(userInfo.getUserId() == 3){
                model = new ModelAndView("editAmTwo");
            }
        }
        return model;
    }

    //飞机制造商工程部门更新零部件信息
    @RequestMapping(value = "/modifyam",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> modifyAm(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String rfidStr = HttpServletRequestUtil.getString(request,"rfidStr");
        String amStr = HttpServletRequestUtil.getString(request,"amStr");
        RFID rfid = null;
        AviationMaterial am = null;
        try{
            am = mapper.readValue(amStr,AviationMaterial.class);
            rfid = mapper.readValue(rfidStr,RFID.class);
            if(am != null && rfid != null){
                //获取零部件原先的amCategory的值
                AviationMaterial amTemp = aviationMaterialService.getAmById(am.getAmId());
                long amCategory = amTemp.getAmCategory();
                long newAmCategory = amCategory + 1;
                am.setAmCategory(newAmCategory);
                //在原有的amCategory值的基础之上加1再更新零部件信息。
               int num1 =  aviationMaterialService.modifyOneAm(am);
               //2.新增rfid记录
               rfid.setAmId(am.getAmId());
               int num2 = rfidService.addRFID(rfid);
               if(num1 > 0 && num2 > 0){
                  //3.更新历史纪录表
                   UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                   History history = new History();
                   history.setDate(new Date());
                   history.setAddress(userInfo.getAddress());
                   history.setName(userInfo.getName());
                   history.setAmCategory(newAmCategory);
                   history.setEpc(rfid.getEpc());
                   history.setTid(rfid.getTid());
                   history.setAmId(am.getAmId());
                   //更新当前结点的pre和之前结点的next
                   long preHistoryId = historyService.getNewAmId(am.getAmId());
                   history.setPre(preHistoryId);
                   //将这些数据新增至历史记录表。
                   int result = historyService.addHistory(history);
                   if(result > 0){
                       History history2 = historyService.getHistoryByHistoryId(preHistoryId);
                       //获取最新 新增的那条记录的history值
                       history2.setNext(historyService.getNewAmId(am.getAmId()));
                       int i = historyService.modifyHistory(history2);
                       if(i > 0){
                           modelMap.put("success",true);
                       }
                   }
               }
            }
        }catch (IOException e){
           modelMap.put("success",false);
        }
        return modelMap;
    }

    //零部件供应商更新零部件
    @RequestMapping(value = "/modifyamtwo",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> modifyAmTwo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String amStr = HttpServletRequestUtil.getString(request,"amStr");
        AviationMaterial am = null;
        try{
            am = mapper.readValue(amStr,AviationMaterial.class);
            if(am != null){
                //获取零部件原先的amCategory的值
                AviationMaterial amTemp = aviationMaterialService.getAmById(am.getAmId());
                long amCategory = amTemp.getAmCategory();
                long newAmCategory = amCategory + 1;
                am.setAmCategory(newAmCategory);
                //在原有的amCategory值的基础之上加1再更新零部件信息。
                int num1 =  aviationMaterialService.modifyOneAm(am);
                if(num1 > 0){
                    //2.获取零部件对应的rfid的信息
                    RFID rfid = rfidService.getRFIDByAmId(am.getAmId());
                    //3.更新历史纪录表
                    UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
                    History history = new History();
                    history.setDate(new Date());
                    history.setAddress(userInfo.getAddress());
                    history.setName(userInfo.getName());
                    history.setAmCategory(newAmCategory);
                    history.setEpc(rfid.getEpc());
                    history.setTid(rfid.getTid());
                    history.setAmId(am.getAmId());
                    //更新当前结点的pre和之前结点的next
                    long preHistoryId = historyService.getNewAmId(am.getAmId());
                    history.setPre(preHistoryId);
                    //将这些数据新增至历史记录表。
                    int result = historyService.addHistory(history);
                    if(result > 0){
                        History history2 = historyService.getHistoryByHistoryId(preHistoryId);
                        //获取最新 新增的那条记录的history值
                        history2.setNext(historyService.getNewAmId(am.getAmId()));
                        int i = historyService.modifyHistory(history2);
                        if(i > 0){
                            modelMap.put("success",true);
                        }
                    }
                }
            }
        }catch (IOException e){
            modelMap.put("success",false);
        }
        return modelMap;
    }

}
