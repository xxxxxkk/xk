package com.gw.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 游戏信息
 * @author xk
 * @Data 2024/7/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfos {
    private Long gameId;
    private Integer status;
}
