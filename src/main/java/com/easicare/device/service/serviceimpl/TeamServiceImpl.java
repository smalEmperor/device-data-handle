package com.easicare.device.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easicare.device.entity.Team;
import com.easicare.device.mapper.team.TeamMapper;
import com.easicare.device.service.TeamService;
import org.springframework.stereotype.Service;

/**
 * @author df
 * @since 2019-08-07
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

}
