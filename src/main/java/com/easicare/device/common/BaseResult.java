package com.easicare.device.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author df
 * @date 2019/8/6
 */
@Slf4j
public class BaseResult {

    @Autowired
    protected HttpServletRequest request;

    /**
     * 返回成功结果集
     */
    public static Result requestSuccess(Object data) {
        return new Result(Result.SUCCESS, Result.SUCCESSMSG, data);
    }

    /**
     * 返回成功结果
     */
    public static Result requestSuccess(String message) {
        return new Result(Result.SUCCESS, message);
    }

    /**
     * 返回成功结果和对象
     */
    public static Result requestSuccess(String message,Object data) {
        return new Result(Result.SUCCESS, message,data);
    }

    /**
     * 返回失败结果集
     */
    public static Result requestErr(String message) {
        return new Result(Result.ERROR, message);
    }

    /**
     * 获取ip
     */
    protected String getRealIp(){
        String ip = request.getHeader("X-Real-IP");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
