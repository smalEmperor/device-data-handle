package com.easicare.device.service;

import com.easicare.device.entity.Original;

import java.util.List;

/**
 * @author df
 * @date 2019/8/19
 */
public interface OriginalService {
    /**
     * 上传未处理的数据
     * @param origin  原始数据
     */
    Long uploadOrigin(Original origin);

    /**
     * 根据id获取原始数据
     * @param id  原始数据id
     */
    Original getOriginById(Long id);

    /**
     * 更具条件获取数据
     * @param origin  原始数据
     */
    List<Original> getOriginBySelect(Original origin);


    /**
     * 根据id删除原始数据
     * @param id  原始数据id
     */
    Integer deleteOriginById(Long id);

}
