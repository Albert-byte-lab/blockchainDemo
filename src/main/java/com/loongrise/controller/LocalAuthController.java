package com.loongrise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loongrise.entity.LocalAuth;
import com.loongrise.entity.UserInfo;
import com.loongrise.service.LocalAuthService;
import com.loongrise.service.UserInfoService;
import com.loongrise.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/localauth")
public class LocalAuthController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LocalAuthService localAuthService;


    @RequestMapping(value = "/listuserinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listUserInfo(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        List<UserInfo> userInfoList = userInfoService.getAllUserInfo();
        if(userInfoList != null){
            modelMap.put("userInfoList",userInfoList);
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }



    @RequestMapping(value="/tologin",method= RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> toLogin(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String userInfoStr = HttpServletRequestUtil.getString(request,"userInfoStr");
        String localAuthStr = HttpServletRequestUtil.getString(request,"localAuthStr");
        LocalAuth localAuth = null;
        UserInfo userInfo = null;
        try{
            userInfo = mapper.readValue(userInfoStr,UserInfo.class);
            localAuth = mapper.readValue(localAuthStr,LocalAuth.class);
            System.out.println(localAuth.getUsername());
            System.out.println("userId???: " + userInfo.getUserId());
        }catch(IOException e){
            modelMap.put("success",false);
            return modelMap;
        }
        LocalAuth result = localAuthService.getLocalAuthBypwd(localAuth);
        if(result != null){
            System.out.println("userInfo.getUserId()?????????:"+userInfo.getUserId());
            UserInfo userInfoTemp = new UserInfo();
            userInfoTemp = userInfoService.getUserInfoById(userInfo.getUserId());
            System.out.println("????????????:"+userInfoTemp.getName());
            System.out.println("??????DESC:"+userInfoTemp.getDesc());
            System.out.println("??????address:"+userInfoTemp.getAddress());
            LocalAuth newLocalAuth = new LocalAuth();
            newLocalAuth.setUsername(result.getUsername());
            newLocalAuth.setPassword(result.getPassword());
            request.getSession().setAttribute("localAuth",newLocalAuth);
            request.getSession().setAttribute("userInfo",userInfoTemp);
            modelMap.put("success",true);
            System.out.println(11111111);
            return modelMap;
        }
        modelMap.put("success",false);
        return modelMap;
    }

    @RequestMapping(value = "/tocancel", method = RequestMethod.POST)
    @ResponseBody
    /**
     * ??????????????????????????????????????????session
     *
     * @param request
     * @return
     * @throws IOException
     */
    private Map<String, Object> logout(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // ?????????session?????????
        request.getSession().setAttribute("userInfo", null);
        request.getSession().setAttribute("localAuth",null);
        modelMap.put("success", true);
        return modelMap;
    }

    /**
     * ?????????????????????
     * @param request
     * @return
     */
    @RequestMapping(value="/toandroidlogin",method= RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> toAndroidLogin(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String username =  request.getParameter("loginname");
        String password =  request.getParameter("password");
        System.out.println("username: "+username);
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUsername(username);
        localAuth.setPassword(password);
        UserInfo userInfo = null;
        LocalAuth result = localAuthService.getLocalAuthBypwd(localAuth);
        if(result != null){
            System.out.println("????????????userId:"+result.getUserId());
            userInfo = userInfoService.getUserInfoById(result.getUserId());
            System.out.println("?????????:"+userInfo.getName());
            System.out.println("address:"+userInfo.getAddress());
            System.out.println("desc "+ userInfo.getDesc());
            if(userInfo != null){
                modelMap.put("userInfo",userInfo);
                modelMap.put("success",true);
            }else{
                modelMap.put("success",false);
            }
        }
        return  modelMap;
    }





}
