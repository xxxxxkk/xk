package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayTypeEntityPageReq extends BasePageReq {
    private String name;
    private Integer status;
    private String code;
}
