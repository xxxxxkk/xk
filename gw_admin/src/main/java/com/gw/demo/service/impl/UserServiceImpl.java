package com.gw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.demo.entity.SecurityUser;
import com.gw.demo.entity.UserEntity;
import com.gw.demo.mapper.UserMapper;
import com.gw.demo.service.UserService;
import com.gw.util.JWTUtils;
import com.gw.util.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
/**
 * 用户服务
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private AuthenticationManager authenticationManager;

        @Resource
    private JWTUtils jwtUtils;

    @Override
    public Result login(UserEntity user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getAccount(), user.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
            UserEntity userEntity = securityUser.getUser();
            String token = jwtUtils.createJwt(userEntity);
            redisTemplate.opsForValue().set("token:" + userEntity.getAdminId(), token, 1000, TimeUnit.MINUTES);
            return Result.success(token);
        } catch (BadCredentialsException e) {
            return Result.fail("用户名或密码错误");
        }
    }
    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity loginUser = (UserEntity) authentication.getPrincipal();
        Long userid = loginUser.getAdminId();
        redisTemplate.delete("token:"+userid);
        return Result.success("退出成功");
    }

}
