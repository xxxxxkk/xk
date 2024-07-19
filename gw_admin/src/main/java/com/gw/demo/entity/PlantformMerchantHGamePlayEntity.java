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
 * @author xk
 * @description 针对表【game_paly_type】的数据库操作实体
 * @version 2024年7月19 上午 10:51:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("plantform_merchant_game_play")
public class PlantformMerchantHGamePlayEntity extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long merchantId;
    private Long gameId;
    private Long gamePlayId;
    private Integer status;
}
