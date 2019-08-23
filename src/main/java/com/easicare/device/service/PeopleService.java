package com.easicare.device.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.easicare.device.entity.People;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author df
 * @since 2019-08-07
 */
public interface PeopleService extends IService<People> {

    List<Map<String, Object>> mybatuisPlusTest();

    IPage<People> pageList();

    @Override
    boolean saveOrUpdateBatch(Collection<People> entityList);

    /**
     * 创建对象
     * @param user
     */
    void saveUser(People user);

    /**
     * 根据用户名查询对象
     * @param userName
     */
    People findUserByUserName(String userName);

    /**
     * 更新对象
     * @param user
     */
    public long updateUser(People user);

    /**
     * 删除对象
     * @param id
     */
    public void deleteUserById(Integer id);

}
