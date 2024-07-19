package com.gw.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xk
 * @Data 2024/7/19

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantformGameDto {
    private Long plantformId;
    private List<GameInfos> gameInfos;
}
