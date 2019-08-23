package com.easicare.device.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author df
 * @date 2019/8/6
 */
@Slf4j
@Component
public class HandlerInterceptorConfig implements HandlerInterceptor {
    /*@Autowired
    private final RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session= request.getSession();
        String keyName=RedisConfig.reids_prefix+session.getId();
        ShiroAdmin shiroAdmin= (ShiroAdmin) redisTemplate.opsForValue().get(keyName);
        if (shiroAdmin==null){
            throw  new ClassCastException("当前账号未登录,请先登陆");
        }
        String token = request.getHeader("token");
        if (token == null || token.trim().length() == 0) {
            throw new ClassCastException("token 禁止为空");
        }
        if (!shiroAdmin.getToken().equals(token)) {
            throw new ClassCastException("账号在其他地方登录,请重新登录");
        }
        shiroAdmin.setSessionId(" 被拦截 当前会话:"+session.getId());
        request.getSession().setAttribute("shiroAdmin",shiroAdmin);
        redisTemplate.expire(keyName,2, TimeUnit.HOURS);
        return true;
    }*/

}
