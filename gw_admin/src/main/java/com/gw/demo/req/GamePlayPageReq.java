package com.gw.demo.req;

import com.gw.base.req.BasePageReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xk
 * @version 2024年7月18 上午10:46:00

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayPageReq extends BasePageReq {
    private String gamePlayName;
    private Integer status;
    private Integer gameId;

}
