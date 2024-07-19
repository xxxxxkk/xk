package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.EarlyWarningEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 针对表【early_warning】的数据库操作mapper

 */
@Mapper
public interface EarlyWarningEntityMapper extends BaseMapper<EarlyWarningEntity> {
}
