package com.gw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.demo.entity.PlantformGame;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xk
 * @version 创建时间：2024年7月19日
 * @description 针对表【plantform_game】的数据库操作mapper
 */
@Mapper
public interface PlantformGameMapper extends BaseMapper<PlantformGame> {
    void updateStatusById(Long id, Integer status);

    void insertPlantGame(PlantformGame plantformGame);

    void updateStatusByPlantformIdAndGamePlayId(Long plantformId, Integer status, Long gamePlayId);

    void delecteByGameIdGamePlayTypeIds(Long gameID, List<Long> gamePlayTypeIds);
}
