package com.gw.demo.entity.dto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantformMerchatVo {
    private Long merchatId;
    private Long gamePlayId;
    private Integer status;
}
