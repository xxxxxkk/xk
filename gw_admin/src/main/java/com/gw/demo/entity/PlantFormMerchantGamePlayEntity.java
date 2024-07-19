package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 商户游戏玩法
 * @author xk
 * @version 2024年7月17 下午14:15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("plantform_merchant_game_play")
public class PlantFormMerchantGamePlayEntity extends BaseEntity {
        @TableId(type = IdType.ASSIGN_ID)
        private Long id;
        private Long merchantId;
        private Long gameId;
        private Long gamePlayId;
        private Integer status;
}
