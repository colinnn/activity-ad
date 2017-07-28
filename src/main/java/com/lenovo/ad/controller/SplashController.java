package com.lenovo.ad.controller;

import com.lenovo.ad.service.SplashService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by chenlm3 on 2017/7/20.
 */
@RestController
@RequestMapping("")
public class SplashController {
//    private static Logger logger = Logger.getLogger(SplashController.class);
    @Autowired
    private SplashService splashService;

    @RequestMapping(value="/business/splash_intercept!detail.action",method = RequestMethod.GET)
    public Map get_splash(String flagList, HttpServletRequest request){
        System.out.println(getIP(request));
        return splashService.get_all_splash(flagList);
    }

    public String getIP(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("x-forwarded-for:"+request.getHeader("x-forwarded-for"));
        sb.append(" Proxy-Client-IP:"+request.getHeader("Proxy-Client-IP"));
        sb.append(" WL-Proxy-Client-IP:"+request.getHeader("WL-Proxy-Client-IP"));
        sb.append(" request.getRemoteAddr():"+request.getRemoteAddr());
        return sb.toString();
    }

    public String getIRealIPAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equalsIgnoreCase(ip))    {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)   || "null".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)    || "null".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
