package com.gw.demo.controller;

import com.gw.demo.entity.SecurityUser;
import com.gw.demo.entity.UserEntity;
import com.gw.demo.service.UserService;
import com.gw.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * user控制器
 * @author xk
 * @version 2024年7月17 上午10:33:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestParam String account, @RequestParam String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccount(account);
        userEntity.setPassword(password);
        return userService.login(userEntity);
    }
    @PostMapping("/logout")
    public Result logout() {
        return userService.logout();
    }
}
