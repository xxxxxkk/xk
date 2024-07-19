package com.gw.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author xk
 * @Data 2024/7/19
 * @deprecated admin_node表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin_node")
public class AdminNodeEntity extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String title;

    private String content;

    private Long merchantId;

    private Integer aduitStatus;

    private Long aduitUserId;

    private LocalDateTime aduitTime;

    private String rejectReason;

    private Integer isTop;
}
