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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/localauth")
public class LocalAuthController {

    @Autowired
    private LocalAuthService localAuthService;

    @RequestMapping(value="/tologin",method= RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> toLogin(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
         long userId = HttpServletRequestUtil.getLong(request,"userId");
        String localAuthStr = HttpServletRequestUtil.getString(request,"localAuthStr");
        LocalAuth localAuth = null;
        try{
            localAuth = mapper.readValue(localAuthStr,LocalAuth.class);
            System.out.println(localAuth.getUsername());
        }catch(IOException e){
            modelMap.put("success",false);
            return modelMap;
        }
        LocalAuth result = localAuthService.getLocalAuthBypwd(localAuth);
        if(result != null){
            LocalAuth newLocalAuth = new LocalAuth();
            newLocalAuth.setUsername(result.getUsername());
            newLocalAuth.setPassword(result.getPassword());
            request.getSession().setAttribute("localAuth",newLocalAuth);
            modelMap.put("success",true);
            System.out.println(11111111);
            return modelMap;
        }
        modelMap.put("success",false);
        return modelMap;
    }
}
