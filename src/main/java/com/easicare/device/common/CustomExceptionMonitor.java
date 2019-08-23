package com.easicare.device.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author df
 * @date 2019/8/6
 */
@Slf4j
public class CustomExceptionMonitor extends BaseResult {
    /**
     * 抛出自定义BusinessException异常
     */
    @ExceptionHandler({CustomException.class})
    @ResponseBody
    public Result business(CustomException ex) {
        log.info(ex.toString());
        return new Result(Result.ERROR,ex.getMessage());
    }



    protected void check(String code ,Object obj){
        if (obj==null|| "null".equals(obj.toString().trim()) ||obj.toString().trim().length()==0) {
            throw new CustomException("参数[" +code+ "]不能为空");
        }
    }

}
