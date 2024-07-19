package com.gw.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xk
 * @Data 2024/7/19

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayInfos {
    private Long gameId;
    private Integer status;
    private Long gamePlayId;
}
