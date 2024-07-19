package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
/**
 * 游戏信息
 * @author xk
 * @version 2024年7月17 下午14:15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "game_info")
public class GameInfoEntity  extends BaseEntity {

    @NotBlank(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @NotBlank(message = "游戏名称不能为空")
    @ApiModelProperty(value = "游戏名称", required = true)
    private String name;
    @NotBlank(message = "游戏code不能为空")
    @ApiModelProperty(value = "游戏code", required = true)
    private String code;
    @NotBlank(message = "游戏状态不能为空")
    @ApiModelProperty(value = "游戏状态", required = true)
    private String status;
    @NotBlank(message = "游戏图标不能为空")
    @ApiModelProperty(value = "游戏图标", required = true)
    private String icon;
    @NotBlank(message = "排序不能为空")
    @ApiModelProperty(value = "排序", required = true)
    private Integer order;

    @NotBlank(message = "游戏类型不能为空")
    @ApiModelProperty(value = "游戏类型（1转盘，2砸金蛋，3 红包雨）", required = true)
    private int type;
}
