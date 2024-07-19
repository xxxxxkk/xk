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
 * @version 2024年7月19 上午 10:51:38

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_data_log")
public class SysDataLogEntity extends BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String operate;

    private String ip;

    private String dataChange;

    private String url;

}
