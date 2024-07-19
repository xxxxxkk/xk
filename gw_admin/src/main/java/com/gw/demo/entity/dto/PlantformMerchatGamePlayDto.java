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
public class PlantformMerchatGamePlayDto {
    private Long id;
    private String merchantName;
    private String gameName;
    private String gamePlayName;
    private Integer status;
    private Integer order;
}
