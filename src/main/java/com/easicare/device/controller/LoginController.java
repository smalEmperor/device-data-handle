package com.easicare.device.controller;

import com.easicare.device.common.CustomExceptionMonitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author df
 * @date 2019/8/6
 */
@RestController
@RequestMapping("/login")
public class LoginController extends CustomExceptionMonitor {
    //@Autowired
    //private TSysAdminService tSysAdminService;
   /* @Autowired
    private RedisTemplate redisTemplate;*/

    /*@ApiOperation(value = "登陆", response = String.class)
    @PostMapping("/loginDo")
    public Result loginDo(@RequestBody LoginDto dto){
        if (AuthManager.getSessionId()==null){
            return  ajaxDoneError("登陆异常,错误代码-10000");
        }
        TSysAdmin tSystemAdmin=tSysAdminService.getOne(new QueryWrapper<TSysAdmin>().eq("login_code",dto.getLoginCode()).eq("pwd",dto.getPwd()));
        if (tSystemAdmin==null){
            return  ajaxDoneError("账号或密码有误");
        }
        System.out.println("--------------------------------------");
        ShiroAdmin shiroAdmin=new ShiroAdmin();
        shiroAdmin.setAdminId(tSystemAdmin.getId());
        shiroAdmin.setLoginCode(tSystemAdmin.getLoginCode());
        shiroAdmin.setPhone(tSystemAdmin.getPhone());
        shiroAdmin.setRoleId(tSystemAdmin.getRoleId());
        shiroAdmin.setSessionId(AuthManager.getSessionId());
        shiroAdmin.setToken(RandomStringUtils.randomAlphanumeric(24)+tSystemAdmin.getId());
        String keyName= RedisConfig.reids_prefix+shiroAdmin.getSessionId();
        redisTemplate.opsForValue().set(keyName,shiroAdmin,2, TimeUnit.HOURS);
        return  ajaxDoneSuccess("登陆成功 good",shiroAdmin.getToken());

    }*/

}
