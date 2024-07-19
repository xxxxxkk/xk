package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 用户表
 * @author xk
 * @version 创建时间：2024年7月17日
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin_user")
public class UserEntity extends BaseEntity {
    /**
     * 管理员id
     */
    @NotBlank(message = "管理员id不能为空")
    @ApiModelProperty(value = "管理员id", required = true)
    private Long adminId;
    /**
     * 管理员登录账号
     */
    @NotBlank(message = "管理员登录账号不能为空")
    @ApiModelProperty(value = "管理员登录账号", required = true)
    private String account;
    /**
     * 管理员密码
     */
    @NotBlank(message = "管理员密码不能为空")
    @ApiModelProperty(value = "管理员密码", required = true)
    private String password;
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称", required = true)
    private String nickName;
    /**
     * 启用状态
     */
    @ApiModelProperty(value = "启用状态")
    @NotBlank(message = "启用状态不能为空")
    public Integer actionStatus;
    /**
     * 语言
     */
    @NotBlank(message = "语言不能为空")
    @ApiModelProperty(value = "语言", required = true)
    private  Long languageId;
    /**
     * 是否是管理员
     */
    @ApiModelProperty(value = "是否是管理员")
    @NotBlank(message = "是否是管理员不能为空")
    private Integer isAdmin;


}
