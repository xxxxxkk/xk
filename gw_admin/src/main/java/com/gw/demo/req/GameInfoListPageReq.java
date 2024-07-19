package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoListPageReq extends BasePageReq {
    private Long  plantformId;
    private Integer type;
}
