package com.easicare.device.service;

import com.easicare.device.entity.Handled;

/**
 * @author df
 * @date 2019/8/19
 */
public interface HandledService {
    /**
     * 上传处理过的数据
     * @param handled 处理过的JSON数据
     */
    Long uploadHandled(Handled handled);

    /**
     * 根据id获取处理过的数据
     * @param id 处理过的数据id
     */
    Handled getHandled(Long id);
}
