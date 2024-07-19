package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xk
 * @description 针对表【wallet_record】的数据库操作实体
 * @version 2024年7月18 上午 10:51:38

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("plantform_game")
public class PlantformGame extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long plantformId;
    private Long gameId;
    private Integer status;
}
