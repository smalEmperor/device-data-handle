package com.easicare.device.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easicare.device.service.HandledService;
import com.easicare.device.entity.Handled;
import com.easicare.device.mapper.handle.HandledMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author df
 * @date 2019/8/19
 */
@Service
public class HandledServiceImpl extends ServiceImpl<HandledMapper, Handled> implements HandledService {

    private final HandledMapper handledMapper;

    @Autowired
    public HandledServiceImpl(HandledMapper handledMapper) {
        this.handledMapper = handledMapper;
    }

    /**
     * 上传处理过的数据
     * @param handled 处理过的JSON数据
     */
    @Override
    public Long uploadHandled(Handled handled) {
        Date date = new Date();
        handled.setCreateTime(date);
        handled.setUpdateTime(date);
        handled.setActive((byte)1);
        handledMapper.insert(handled);
        return handled.getId();
    }

    /**
     * 根据id获取处理过的数据
     * @param id 处理过的数据id
     */
    @Override
    public Handled getHandled(Long id) {
        return handledMapper.selectById(id);
    }
}
