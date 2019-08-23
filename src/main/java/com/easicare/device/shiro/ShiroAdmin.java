package com.easicare.device.shiro;

import lombok.Data;

/**
 * @author df
 * @date 2019/8/6
 */
@Data
public class ShiroAdmin {
    //@ApiModelProperty(value = "管理员id")
    private Integer adminId;

    //@ApiModelProperty(value = "token")
    private String token;

    //@ApiModelProperty(value = "登陆id")
    private String loginCode;

    //@ApiModelProperty(value = "权限id")
    private Integer roleId;

    //@ApiModelProperty(value = "手机号")
    private String phone;

    //@ApiModelProperty(value = "会话id")
    private String sessionId;

}
