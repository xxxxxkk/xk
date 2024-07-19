package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.Data;

@Data
public class PlantformGamePageReq extends BasePageReq {

        private String plantformId;
        private Integer status;
        private String type;
}
