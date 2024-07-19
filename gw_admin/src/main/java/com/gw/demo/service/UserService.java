package com.gw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.demo.entity.UserEntity;
import com.gw.util.Result;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 针对表【user】的数据库操作Service
 */
public interface UserService extends IService<UserEntity> {
        /**
         * 登录
         * @param user
         * @return
         */
        Result login(UserEntity user);

        /**
         * 登出
         * @return
         */
        Result logout();
}
