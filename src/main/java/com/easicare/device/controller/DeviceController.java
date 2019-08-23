package com.easicare.device.controller;

import com.alibaba.fastjson.JSONObject;
import com.easicare.device.common.BaseResult;
import com.easicare.device.common.Result;
import com.easicare.device.entity.Handled;
import com.easicare.device.entity.Original;
import com.easicare.device.service.HandledService;
import com.easicare.device.service.OriginalService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author df
 * @date 2019/8/19
 */
//@Api2Doc("设备数据处理接口")
//@ApiComment(seeClass = Original.class)
@RestController
public class DeviceController {

    private final OriginalService originalServiceImpl;

    private final HandledService handledServiceImpl;

    @Autowired
    public DeviceController(OriginalService originalServiceImpl,
                            HandledService handledServiceImpl) {
        this.originalServiceImpl = originalServiceImpl;
        this.handledServiceImpl = handledServiceImpl;
    }

    //@ApiComment("上传原始数据")
    @ApiOperation("上传原始数据")
    @ApiImplicitParam(name = "origin", value = "原始数据JSON,createTime,updateTime,active不传", required = true, dataType = "Original")
    @PostMapping("/uploadOrigin")
    public Result uploadOrigin(@RequestBody Original origin) {
        Long result = originalServiceImpl.uploadOrigin(origin);
        if (result != null) {
            JSONObject data = new JSONObject();
            data.put("id",result);
            return BaseResult.requestSuccess("原始数据上传成功",data);
        } else {
            return BaseResult.requestErr("原始数据上传失败");
        }
    }

    //@ApiComment("根据id获取原始数据")
    @ApiOperation("根据id获取原始数据")
    @ApiImplicitParam(name = "id", value = "原始数据的id", required = true, dataType = "Long")
    @GetMapping("/getOrigin")
    public Result getOriginById(Long id) {
        Original result = originalServiceImpl.getOriginById(id);
        if (result != null) {
            return BaseResult.requestSuccess("数据获取成功",result);
        } else {
            return BaseResult.requestErr("数据获取失败");
        }
    }

    //@ApiComment("条件获取原始数据")
    @ApiOperation("条件获取原始数据")
    @ApiImplicitParam(name = "origin", value = "条件数据JSON", required = true, dataType = "Original")
    @PostMapping("/getOriginSelect")
    public Result getOriginBySelect(@RequestBody Original origin) {
        List<Original> result = originalServiceImpl.getOriginBySelect(origin);
        if (CollectionUtils.isNotEmpty(result)) {
            return BaseResult.requestSuccess("数据获取成功",result);
        } else {
            return BaseResult.requestErr("数据获取失败");
        }
    }

    //@ApiComment("根据id删除原始数据")
    @ApiOperation("根据id删除原始数据")
    @ApiImplicitParam(name = "id", value = "原始数据的id", required = true, dataType = "Long")
    @PostMapping("/deleteOrigin")
    public Result deleteOriginById(Long id) {
        Integer result = originalServiceImpl.deleteOriginById(id);
        if (result != null) {
            return BaseResult.requestSuccess("数据删除成功");
        } else {
            return BaseResult.requestErr("数据删除失败");
        }
    }

    //@ApiComment("上传处理过的数据")
    @ApiOperation("上传处理过的数据")
    @ApiImplicitParam(name = "handled", value = "处理过的JSON数据,createTime,updateTime,active不传", required = true, dataType = "Handled")
    @PostMapping("/uploadHandled")
    public Result uploadHandled(@RequestBody Handled handled) {
        Long result = handledServiceImpl.uploadHandled(handled);
        if (result != null) {
            JSONObject data = new JSONObject();
            data.put("id",result);
            return BaseResult.requestSuccess("处理后的数据上传成功",data);
        } else {
            return BaseResult.requestErr("处理后的数据上传失败");
        }
    }

    //@ApiComment("根据id获取处理过的数据")
    @ApiOperation("根据id获取处理过的数据")
    @ApiImplicitParam(name = "id", value = "处理过数据的id", required = true, dataType = "Long")
    @GetMapping("/getHandled")
    public Result getHandledById(Long id) {
        Handled result = handledServiceImpl.getHandled(id);
        if (result != null) {
            return BaseResult.requestSuccess("数据获取成功",result);
        } else {
            return BaseResult.requestErr("数据获取失败");
        }
    }
}
