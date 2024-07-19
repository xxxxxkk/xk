package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.Data;

@Data
public class PlantformMerchatGamePlayPageReq extends BasePageReq {
    private Long merchantId;
    private Long gameId;
    private Integer status;
}
