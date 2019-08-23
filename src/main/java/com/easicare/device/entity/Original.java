package com.easicare.device.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author df
 * @date 2019/8/19
 */
@Data
@TableName("original")
public class Original {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "原始数据id")
    private Long id;
    @ApiModelProperty(value = "字头")
    private String head;
    @ApiModelProperty(value = "信号质量")
    private String seq;
    @ApiModelProperty(value = "数据序列")
    private String dataIndex;
    @ApiModelProperty(value = "设备ID")
    private String deviceId;
    @ApiModelProperty(value = "设备类型")
    private String deviceType;
    @ApiModelProperty(value = "设备型号")
    private String deviceStyle;
    @ApiModelProperty(value = "电池电量")
    private String pwr;
    @ApiModelProperty(value = "仪器控制码")
    private String cmd;
    @ApiModelProperty(value = "控制值")
    private String controlValue;
    @ApiModelProperty(value = "数据类型码")
    private String dataType;
    @ApiModelProperty(value = "数据长度")
    private String dataLength;
    @ApiModelProperty(value = "有效负载")
    private String payload;
    @ApiModelProperty(value = "效验")
    private String validation;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "是否有效")
    private Byte active;
}
