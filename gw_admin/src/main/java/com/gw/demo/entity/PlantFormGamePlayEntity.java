package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 平台游戏关联表
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Data
@TableName("plantform_game_play")
public class PlantFormGamePlayEntity extends BaseEntity {
    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Long gamePlayId;
    private Long plantFormId;
    private Long gameId;
    private Integer status;
}
