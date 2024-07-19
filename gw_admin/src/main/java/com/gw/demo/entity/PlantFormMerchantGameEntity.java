package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户游戏关联表
 * @author xk
 * @version 2024年7月17 下午14:18:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("plantform_merchant_game")
public class PlantFormMerchantGameEntity extends PlantFormGamePlayEntity{
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long merchantId;
    private Long gameId;
    private Integer status;
}
