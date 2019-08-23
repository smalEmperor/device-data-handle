package com.easicare.device.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author df
 * @date 2019/8/6
 */
@Data
public class Result {

    public static final int SUCCESS = 200;
    public static final int ERROR= 500;
    public static final String SUCCESSMSG = "成功";

    @ApiModelProperty(value = "状态码")
    private int code = 0;

    @ApiModelProperty(value = "说明信息")
    private String msg = "";

    @ApiModelProperty(value = "数据")
    private Object data;

    public Result(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Result(int code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

}
