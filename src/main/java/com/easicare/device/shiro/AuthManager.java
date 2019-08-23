package com.easicare.device.shiro;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author df
 * @date 2019/8/6
 */
public class AuthManager {
    public static ShiroAdmin getShiroAdmin() {

        return (ShiroAdmin)getSession().getAttribute("shiroAdmin");

    }

    public static String getSessionId(){
        return getSession().getId();
    }

    public static HttpSession getSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

}
