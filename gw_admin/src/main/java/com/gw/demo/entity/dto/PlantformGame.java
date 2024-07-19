package com.gw.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantformGame {
    private Long id;
    private String name;
    private Integer stayus;
    private String icon;
    private String order;
    private String type;
    private String plantformName;
}
