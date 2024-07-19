package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* @author xk
* @description 针对表【game_play】的数据库操作实体
* @version 2024年7月18 上午 10:51:38
 */
@TableName("game_play")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayEntity extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;

    private String code;

    private Integer status;

    private Long gameId;

    private Long gamePlayTypeId;

}
