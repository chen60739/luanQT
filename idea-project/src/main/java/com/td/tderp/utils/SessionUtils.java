package com.td.tderp.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class SessionUtils {
    public static final String sessionKey="sessionUser";
    public  static String ip;
    public static HashMap<String,HttpSession> sessionMap=new HashMap<>();

    private static HttpSession getSession(){
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        }catch (Exception e){
        }
        return session;
    }

    private static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        ip = IpUtils.getIpAddress(attrs.getRequest());
        return attrs.getRequest();
    }

    public static Object getObject(){
        return getSession().getAttribute(sessionKey);
    }

    public static Object getIpObject(){
        String ip = IpUtils.getIpAddress(getRequest());
        HttpSession httpSession = sessionMap.get(ip);
        return httpSession.getAttribute(sessionKey);
    }

    public static  void setObject(Object o){
        HttpSession httpSession = getSession();
        httpSession.setAttribute(sessionKey,o);
        sessionMap.put(ip,httpSession);
    }

    public static void invalidate(){
        HttpSession session = getSession();
        session.removeAttribute(sessionKey);
        sessionMap.remove(ip);
        session.invalidate();
    }
}
