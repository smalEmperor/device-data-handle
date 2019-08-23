package com.easicare.device.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easicare.device.entity.Original;
import com.easicare.device.mapper.handle.OriginalMapper;
import com.easicare.device.service.OriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author df
 * @date 2019/8/19
 */
@Service
public class OriginalServiceImpl extends ServiceImpl<OriginalMapper, Original> implements OriginalService {

    private final OriginalMapper originalMapper;

    @Autowired
    public OriginalServiceImpl(OriginalMapper originalMapper) {
        this.originalMapper = originalMapper;
    }

    /**
     * 上传未处理的数据
     * @param origin  原始数据
     */
    @Override
    public Long uploadOrigin(Original origin) {
        Date date = new Date();
        origin.setCreateTime(date);
        origin.setUpdateTime(date);
        origin.setActive((byte)1);
        originalMapper.insert(origin);
        return origin.getId();
    }

    /**
     * 根据id获取原始数据
     * @param id  原始数据id
     */
    @Override
    public Original getOriginById(Long id) {
        return originalMapper.selectById(id);
    }

    /**
     * 更具条件获取数据
     * @param origin  原始数据
     */
    @Override
    public List<Original> getOriginBySelect(Original origin) {
        return originalMapper.selectList(new QueryWrapper<>(origin));
    }

    /**
     * 根据id删除原始数据
     * @param id  原始数据id
     */
    @Override
    public Integer deleteOriginById(Long id) {
        Original origin = new Original();
        origin.setId(id);
        origin.setUpdateTime(new Date());
        origin.setActive((byte)0);
        return originalMapper.updateById(origin);
    }
}
