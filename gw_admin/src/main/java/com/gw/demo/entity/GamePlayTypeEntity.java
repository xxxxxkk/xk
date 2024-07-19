package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 游戏玩法类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("game_paly_type")
public class GamePlayTypeEntity extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String code;
    private Integer status;

//    private Long gameId;
//    private String gameName;
//    private Long gamePlayTypeId;
//    private String gamePlayTypeName;

}
