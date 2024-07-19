package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantformGameMeangePageReq extends BasePageReq {
    private Long merchantId;
    private String gameName;

    private Long status;

}
