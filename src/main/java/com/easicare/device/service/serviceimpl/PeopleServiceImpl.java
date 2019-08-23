package com.easicare.device.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easicare.device.mapper.team.PeopleMapper;
import com.easicare.device.service.PeopleService;
import com.easicare.device.entity.People;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author df
 * @since 2019-08-07
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {

    private final MongoTemplate mongoTemplate;

    private final PeopleMapper peopleMapper;

    @Autowired
    public PeopleServiceImpl(PeopleMapper peopleMapper, MongoTemplate mongoTemplate) {
        this.peopleMapper = peopleMapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Map<String, Object>> mybatuisPlusTest(){
        return  peopleMapper.selectMaps(null);
    }

    /**
     * 测试分页
     */
    @Override
    public IPage<People> pageList(){
        IPage<People> page = new Page<>(1, 2);
        return peopleMapper.selectPage(page,new QueryWrapper<>());
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<People> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    /**
     * 创建对象
     * @param user
     */
    @Override
    public void saveUser(People user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据用户名查询对象
     * @param userName
     */
    @Override
    public People findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("Pname").is(userName));
        People user =  mongoTemplate.findOne(query , People.class);
        return user;
    }

    /**
     * 更新对象
     * @param user
     */
    @Override
    public long updateUser(People user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("Pname", user.getPname()).set("teamId", user.getTeamId());
        //更新查询返回结果集的第一条
        UpdateResult result =mongoTemplate.updateFirst(query,update,People.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
        if(result!=null) {
            return result.getMatchedCount();
        } else {
            return 0;
        }
    }

    /**
     * 删除对象
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,People.class);
    }
}
